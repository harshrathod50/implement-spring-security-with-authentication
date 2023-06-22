package com.ecommerce.implementspringsecuritywithauthentication.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ecommerce.implementspringsecuritywithauthentication.service.ApplicationUserDetailsService;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration {

  @Bean
  static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder amb = http.getSharedObject(AuthenticationManagerBuilder.class);
    DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
    dap.setPasswordEncoder(passwordEncoder());
    dap.setUserDetailsService(userDetailsService());
    amb.authenticationProvider(dap);
    return amb.build();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((authorize) -> {
      authorize.anyRequest().authenticated();
    }).formLogin(withDefaults()).httpBasic(withDefaults());
    return http.build();
  }

  @Bean
  UserDetailsService userDetailsService() {
    return new ApplicationUserDetailsService();
  }
}
