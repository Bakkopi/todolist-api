//package com.bakkopi.todoapi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//// SOURCES:
//// - https://youtu.be/b9O9NI-RJ3o?si=HaWS3rt7QznqQXfn
//// - https://spring.io/guides/gs/securing-web/
//
//@EnableWebFluxSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin((form) -> form
//                .loginPage("/login")
//                .permitAll()
//            )
//            .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//            User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//}
