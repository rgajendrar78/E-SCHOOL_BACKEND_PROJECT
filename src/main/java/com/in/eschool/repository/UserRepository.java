package com.in.eschool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.eschool.model.Attendance;
import com.in.eschool.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	
	List<User> findUserByFname(String fname);
	List<User> findUserByEmail(String email);
	 
}
