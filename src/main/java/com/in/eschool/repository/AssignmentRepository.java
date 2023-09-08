package com.in.eschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.in.eschool.model.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer>{

	@Query("select a from Assignment a inner join User u on a.user.id=u.id where u.email=:username")
	List<Assignment> findByUsername(String username);

}
