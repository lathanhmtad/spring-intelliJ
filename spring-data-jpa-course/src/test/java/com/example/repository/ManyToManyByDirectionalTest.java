package com.example.repository;

import com.example.entity.Role;
import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyByDirectionalTest {


    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRole() {
        User user = new User();
        user.setFirstName("huy");
        user.setLastName("dinh");
        user.setEmail("huy@gmail.com");
        user.setPassword("123123");

        User user2 = new User();
        user2.setFirstName("admin");
        user2.setLastName("duy");
        user2.setEmail("admin@gmail.com");
        user2.setPassword("111");

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");

        roleAdmin.getUsers().add(user);
        roleAdmin.getUsers().add(user2);

        user.getRoles().add(roleAdmin);
        user2.getRoles().add(roleAdmin);

        roleRepository.save(roleAdmin);
    }

    @Test
    void fetchRole() {
        List<Role> roles =  roleRepository.findAll();
        roles.forEach(r -> {
            System.out.println(r.getName());
            r.getUsers().forEach(u -> {
                System.out.println(u.getFirstName());
            });
        });
    }
}
