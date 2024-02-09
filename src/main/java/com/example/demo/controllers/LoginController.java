package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//public class LoginController {
//    @GetMapping("/login")
//    String login() {
//        return "login";
//    }
//}
@RestController
public class LoginController {

    @GetMapping
    public String home() {
        return "Hello, world";
    }

    @PreAuthorize("hasRole('ROLE_CLIENT', 'ROLE_EMPLOYEE', 'ROLE_MANAGER')")
    @GetMapping("/client")
    public String client() {
        return "Hello, client";
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')")
    @GetMapping("/employee")
    public String employee() {
        return "Hello, employee";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping("/manager")
    public String manager() {
        return "Hello, manager";
    }
}