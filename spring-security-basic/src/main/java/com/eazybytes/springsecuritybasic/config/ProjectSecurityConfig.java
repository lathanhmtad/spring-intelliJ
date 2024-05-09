package com.eazybytes.springsecuritybasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
public class ProjectSecurityConfig  {

    @Autowired PasswordEncoder passwordEncoder;

    @Autowired
    EazyBankUsernamePwdAuthenticationProvider customAuthProvider;

    @Autowired InMemoryEazyUsernamePwdAuthenticationProvider inMemoryEazyUsernamePwdAuthenticationProvider;


    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customAuthProvider);
        authenticationManagerBuilder.authenticationProvider(inMemoryEazyUsernamePwdAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(request -> request
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCard")
                        .authenticated()
                .requestMatchers("/notices", "/contact", "/register", "/test").permitAll()
        )
                .authenticationManager(authManager(httpSecurity))
                .formLogin(
                       Customizer.withDefaults()
                )
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }




}
