package com.ecommerce.implementspringsecuritywithauthentication.provider;

import com.ecommerce.implementspringsecuritywithauthentication.service.ApplicationUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationAuthenticationProvider implements AuthenticationProvider {
  @Autowired
  private ApplicationUserDetailsService applicationUserDetailsService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getPrincipal().toString();
    String password = authentication.getCredentials().toString();
    UserDetails user;
    try {
      user = applicationUserDetailsService.loadUserByUsername(username);
    } catch(UsernameNotFoundException e) {
      return null;
    }
    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new AuthenticationException("Invalid username or password") {};
    }
    return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
  }

  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
