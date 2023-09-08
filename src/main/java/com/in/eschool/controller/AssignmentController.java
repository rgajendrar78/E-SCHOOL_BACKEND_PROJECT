package com.in.eschool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.eschool.model.Assignment;
import com.in.eschool.model.Attendance;
import com.in.eschool.service.AssignmentService;


@RestController
@CrossOrigin("*")
public class AssignmentController {
	
	private Logger logger=LoggerFactory.getLogger(AssignmentController.class);
	
	@Autowired
	private AssignmentService assignmentSevice;
	
	@RequestMapping("/assignments")
	public List<Assignment>getAllAssignments(){
		return assignmentSevice.getAllAssignments();
	}
	
	@PostMapping("/assignment")
	public void addAssignment(@RequestBody Assignment assignment) {
		if(assignment!=null && assignment.getUser()!=null) {
			logger.info("Inside addAssignment:{}",assignment.getUser().getId());
		}
		assignmentSevice.addAssignment(assignment);
	}
	
	@PutMapping("/assignment/{id}")
	public void updateAssignment(@PathVariable Integer id, @RequestBody Assignment assignment) {
	
		assignmentSevice.updateAssignment(id, assignment);
	}
	@DeleteMapping("/assignment/{id}")
	public void deleteAssignment(@PathVariable Integer id) {
		assignmentSevice.deleteAssignment(id);
	}

	
	@RequestMapping("/getMyAssignment")
	public List<Assignment>getMyAssignment(HttpServletRequest httpServletRequest){
		return assignmentSevice.getMyAssignment(httpServletRequest);
	}
	

	public AssignmentController() {
		// TODO Auto-generated constructor stub
	}

}
