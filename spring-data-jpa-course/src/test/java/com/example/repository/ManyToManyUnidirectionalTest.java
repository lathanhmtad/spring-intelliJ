package com.example.repository;

import com.example.entity.Role;
import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
//        User user = new User();
//        user.setFirstName("ramesh");
//        user.setLastName("fadatare");
//        user.setEmail("ramesh@gmail.com");
//        user.setPassword("123");

        User user2 = new User();
        user2.setFirstName("duy");
        user2.setLastName("nguyen");
        user2.setEmail("nguyenduy@gmail.com");
        user2.setPassword("123123");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

//        user.getRoles().add(admin);
//        user.getRoles().add(customer);

        user2.getRoles().add(admin);
        user2.getRoles().add(customer);

        userRepository.save(user2);
//        userRepository.save(user2);
    }

    @Test
    void updateUser() {
        User user = userRepository.findById(1L).get();
        user.setFirstName("duy");
        user.setEmail("duy@gmail.com");

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");

        user.getRoles().clear();
        user.getRoles().add(roleUser);

        userRepository.save(user);
    }

    @Test
    void deleteUser() {

        userRepository.deleteById(2L);
    }


    @Test
    void fetchUser() {
        User user = userRepository.findById(1L).get();
        System.out.println(user);

        user.getRoles().forEach(r -> {
            System.out.println(r.getName());
        });
    }
}
