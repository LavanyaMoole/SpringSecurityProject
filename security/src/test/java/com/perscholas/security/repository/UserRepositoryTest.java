package com.perscholas.security.repository;

import com.perscholas.security.Role;
import com.perscholas.security.SecurityApplication;
import com.perscholas.security.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = SecurityApplication.class)
class UserRepositoryTest {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        User user=new User();
        user.setEmail("suresh@gmail.com");
        user.setFirstName("suresh");
        user.setLastName("moole");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRole(Role.valueOf("ADMIN"));
        User user1=new User();
        user1.setEmail("lavanya@gmail.com");
        user1.setPassword(passwordEncoder.encode("1234"));
        user1.setFirstName("lavanya");
        user1.setLastName("moole");
        user1.setRole(Role.valueOf("USER"));
        userRepository.save(user);
        userRepository.save(user1);
      }




}