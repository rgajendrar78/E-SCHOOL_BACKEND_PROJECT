package com.in.eschool.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.in.eschool.model.Attendance;
import com.in.eschool.model.User;

public interface UserService {
	 List<User> findUserByFname(String fname);

	User addStudent(User student);

	List<User> getAllStudents();

	void deleteStudent(Integer id);

	void updateStudent(Integer id, User student);

	List<User> getMyProfile(HttpServletRequest request);
}
