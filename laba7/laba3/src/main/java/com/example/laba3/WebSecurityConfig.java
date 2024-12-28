package com.example.laba3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {http
            .authorizeHttpRequests((auth) -> auth
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/students/create/**", "/students/update/**", "/students/edit/**", "/students/delete/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )

            .formLogin(Customizer.withDefaults()); return http.build();
    }


//    @Bean
//    public UserDetailsManager inMemoryUserDetailManager() {
//        UserDetails user1 = User
//                .withUsername("user1671")
//                .password(passwordEncoder().encode("pass"))
//                .roles("USER") // Роль USER
//                .build();
//
//        UserDetails user2 = User
//                .withUsername("admin1671")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER", "ADMIN") // Роли USER и ADMIN
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
    }



}
