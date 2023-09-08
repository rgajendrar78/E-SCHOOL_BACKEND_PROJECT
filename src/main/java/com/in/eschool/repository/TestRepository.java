package com.in.eschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.eschool.model.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer>{

	@Query("select a from Test a inner join User u on a.user.id=u.id where u.email=:username")
	List<Test> findByUsername(String username);

}
