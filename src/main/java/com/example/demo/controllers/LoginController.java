package com.example.demo.controllers;

import com.example.demo.viewModels.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authorize")
public class LoginController {
    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            return ResponseEntity.ok("Login successful");
            }
        catch (AuthenticationException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }



//@Controller
//public class LoginController {
//    @GetMapping("/login")
//    String login() {
//        return "login";
//    }
//}
//    @GetMapping
//    public String home() {
//        return "Hello, world";
//    }
//
//    @PreAuthorize("hasRole('ROLE_CLIENT', 'ROLE_EMPLOYEE', 'ROLE_MANAGER')")
//    @GetMapping("/client")
//    public String client() {
//        return "Hello, client";
//    }
//
//    @PreAuthorize("hasRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')")
//    @GetMapping("/employee")
//    public String employee() {
//        return "Hello, employee";
//    }
//
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
//    @GetMapping("/manager")
//    public String manager() {
//        return "Hello, manager";
//    }
}