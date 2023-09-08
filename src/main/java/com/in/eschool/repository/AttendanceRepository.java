package com.in.eschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.eschool.model.Attendance;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Integer>{

	@Query("select a from Attendance a inner join User u on a.user.id=u.id where u.email=:username")
	List<Attendance> findByUsername(String username);

}
