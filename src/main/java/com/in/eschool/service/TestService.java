package com.in.eschool.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.in.eschool.model.Attendance;
import com.in.eschool.model.Test;

public interface TestService {

	void addTest(Test test);

	void deleteTest(Integer id);
	
	 List<Test> getAllTests();

	void updateTest(Integer id, Test test);

	List<Test> getMyTest(HttpServletRequest request);
}
