package com.eazybytes.springsecuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
//@ComponentScan("com.eazybytes.springsecuritybasic") // optional
public class SpringSecurityBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123")
//                .authorities("admin")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("1234")
//                .authorities("read")
//                .build();

//        return new InMemoryUserDetailsManager(admin, user);
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		UserDetails admin = User.withUsername("admin").password("123").authorities("admin").build();
		UserDetails user = User.withUsername("user").password("123").authorities("read").build();
		inMemoryUserDetailsManager.createUser(admin);
		inMemoryUserDetailsManager.createUser(user);
		return inMemoryUserDetailsManager;
	}
}
