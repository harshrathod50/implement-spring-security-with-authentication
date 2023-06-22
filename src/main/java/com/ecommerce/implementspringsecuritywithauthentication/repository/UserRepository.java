package com.ecommerce.implementspringsecuritywithauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.implementspringsecuritywithauthentication.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  @Query(value = "SELECT email FROM user WHERE email = ?1")
  public Optional<UserEntity> findByEmail(String email);
}
