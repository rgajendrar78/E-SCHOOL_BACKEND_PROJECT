package com.in.eschool.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.eschool.model.Assignment;
import com.in.eschool.model.Attendance;
import com.in.eschool.repository.AssignmentRepository;
import com.in.eschool.service.AssignmentService;
@Service
public class AssignmentServiceImpl implements AssignmentService{
	private Logger logger=LoggerFactory.getLogger(AttendanceServiceImpl.class);
	
	@Autowired
	public AssignmentRepository assignmentRepository;

	public AssignmentServiceImpl() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void addAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		assignmentRepository.save(assignment);
		
	}

	@Override
	public void deleteAssignment(Integer id) {
		// TODO Auto-generated method stub
		assignmentRepository.deleteById(id);
		
	}

	@Override
	public List<Assignment> getAllAssignments() {
		// TODO Auto-generated method stub
		List<Assignment> assignments=new ArrayList<>();
		assignmentRepository.findAll().forEach(assignments::add);
		 return assignments;
	}

	@Override
	public void updateAssignment(Integer id, Assignment assignment) {
		// TODO Auto-generated method stub
		assignmentRepository.save(assignment);
		
	}
	
	@Override
	public List<Assignment> getMyAssignment(HttpServletRequest request){
		HttpSession httpSession = request.getSession(true);
		String username=(String) httpSession.getAttribute("username");
		logger.info("Get attendence for username:{}",username);
		return assignmentRepository.findByUsername(username);
	}



	

}
