package com.in.eschool.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.in.eschool.model.Assignment;

public interface AssignmentService {
	void addAssignment(Assignment assignment);
	 
	void deleteAssignment(Integer id);
	
	List<Assignment> getAllAssignments();
	
	 void updateAssignment(Integer id,Assignment assignment);

	List<Assignment> getMyAssignment(HttpServletRequest httpServletRequest);

//	List<Assignment> getMyAssignmet(HttpServletRequest request);

	

	

}
