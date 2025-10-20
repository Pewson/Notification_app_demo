package com.example.demo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        // Create a custom cookie
        Cookie sessionCookie = new Cookie("USER_SESSION", authentication.getName());
        sessionCookie.setSecure(true); // Set to true in production
        sessionCookie.setPath("/");
        sessionCookie.setMaxAge(3600); // 1 hour

        // Add the cookie to the response
        response.addCookie(sessionCookie);

        // Redirect or handle success
        super.onAuthenticationSuccess(request, response, authentication);
    }
}