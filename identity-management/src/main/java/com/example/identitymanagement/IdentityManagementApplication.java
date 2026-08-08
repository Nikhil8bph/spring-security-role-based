package com.example.identitymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.identitymanagement", "com.example.sharedkernel"})
@SpringBootApplication
public class IdentityManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityManagementApplication.class, args);
    }

}
