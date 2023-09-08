package com.in.eschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.in.eschool.model.SecurityUser;
import com.in.eschool.repository.SecurityUserRepository; 

public class SecurityUserDetailsService implements UserDetailsService { 
   @Autowired 
   private SecurityUserRepository userRepository; 
   
   @Override 
   public UserDetails loadUserByUsername(String username) 
   throws UsernameNotFoundException { 
	   SecurityUser user = userRepository.findSecurityUserByUsername(username) 
			   .orElseThrow(() -> new UsernameNotFoundException("User not present"));
         return user; 
   } 
   public void createUser(UserDetails user) { 
      userRepository.save((SecurityUser) user); 
   } 
}