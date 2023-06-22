package com.ecommerce.implementspringsecuritywithauthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.implementspringsecuritywithauthentication.entity.UserEntity;
import com.ecommerce.implementspringsecuritywithauthentication.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity u = userRepository
      .findByEmail(username)
      .orElseThrow(() -> {
        throw new UsernameNotFoundException(username);
      });
    System.out.println(u);
    return u;
  }
}
