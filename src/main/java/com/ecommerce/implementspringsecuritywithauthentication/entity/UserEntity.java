package com.ecommerce.implementspringsecuritywithauthentication.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import lombok.Data;

@Entity(name = "user")
@Table(name = "user")
@Data
public class UserEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(unique = true)
  private String email;

  private String password;

  @Column(name = "date_modified")
  private Timestamp dateModified = new Timestamp(new Date().getTime());

  @Column(name = "date_created")
  private Timestamp dateCreated = new Timestamp(new Date().getTime());

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
  }
}
