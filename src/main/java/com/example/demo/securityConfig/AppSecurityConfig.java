package com.example.demo.securityConfig;

import com.example.demo.services.UserCredsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig {

    //    @Bean
//    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
//        return new MvcRequestMatcher.Builder(introspector);
//    }
    private final UserCredsService userCredsService;

    public AppSecurityConfig(UserCredsService userCredsService) {
        this.userCredsService = userCredsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http/*, MvcRequestMatcher.Builder mvc*/) throws Exception {
        http
                .csrf((csrf) -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
                        /*.requestMatchers(AntPathRequestMatcher.antMatcher("/manager")).hasAnyRole("manager", "admin")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/client")).hasAnyRole("client", "manager", "admin")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/employee")).hasAnyRole("manager", "employee", "admin")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/insurance")).hasAnyRole("manager", "employee", "admin", "client")*/
                        .anyRequest().authenticated())
                .userDetailsService(userCredsService)
                .headers(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
//                .sessionManagement(httpSecuritySessionManagementConfigurer ->
//                        httpSecuritySessionManagementConfigurer
//                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
