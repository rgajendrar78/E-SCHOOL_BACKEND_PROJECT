package com.in.eschool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.eschool.model.SecurityUser;

@Repository 
public interface SecurityUserRepository extends JpaRepository<SecurityUser, String> { 
   Optional<SecurityUser> findSecurityUserByUsername(String username); 
}