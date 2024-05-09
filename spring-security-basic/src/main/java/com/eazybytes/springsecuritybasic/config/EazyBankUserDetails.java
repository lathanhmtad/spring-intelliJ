//package com.eazybytes.springsecuritybasic.config;
//
//import com.eazybytes.springsecuritybasic.model.Customer;
//import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class EazyBankUserDetails implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//        String email, password = null;
//        Customer customer = customerRepository.findByEmail(usernameOrEmail)
//                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + usernameOrEmail));
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(customer.getRole()));
//
//        return new User(
//                customer.getEmail(),
//                customer.getPwd(),
//                authorities
//        );
//    }
//}
