package com.perscholas.security;

import com.perscholas.security.repository.CreateTables;
import com.perscholas.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);



	}

}
