package com.eazybytes.springsecuritybasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryEazyUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    InMemoryUserDetailsManager inMemoryUserDetailsManager;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails u1 = inMemoryUserDetailsManager.loadUserByUsername(authentication.getName());
        if(passwordEncoder.matches(authentication.getCredentials().toString(), u1.getPassword()))
        {
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new UsernamePasswordAuthenticationToken(u1.getUsername(), u1.getPassword(), authorities);
        }
        else {
            throw new BadCredentialsException("Invalid password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (TestingAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
