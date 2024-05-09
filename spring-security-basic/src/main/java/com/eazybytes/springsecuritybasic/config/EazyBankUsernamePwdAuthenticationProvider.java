package com.eazybytes.springsecuritybasic.config;

import com.eazybytes.springsecuritybasic.model.Customer;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider, ProviderManager {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Customer customer = customerRepository.findByEmail(username).orElseThrow(
                () -> new BadCredentialsException("No user registered with this details")
        );
        if(passwordEncoder.matches(pwd, customer.getPwd()))
        {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.getRole()));
            return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
        }
        else {
            throw new BadCredentialsException("Invalid password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (TestingAuthenticationToken.class.isAssignableFrom(authentication));
    }

//    @Override
//    public Authentication authenticate(Authentication auth)
//            throws AuthenticationException {
//        String username = auth.getName();
//        String password = auth.getCredentials()
//                .toString();
//
//        if ("user".equals(username) && "pass".equals(password)) {
//            return new UsernamePasswordAuthenticationToken
//                    (username, password, Collections.emptyList());
//        } else {
//            throw new
//                    BadCredentialsException("External system authentication failed");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> auth) {
//        return auth.equals(UsernamePasswordAuthenticationToken.class);
//    }
}
