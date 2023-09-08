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

import com.in.eschool.model.Attendance;
import com.in.eschool.service.AttendanceService;

@RestController
@CrossOrigin("*")
public class AttendanceController {
	
	private Logger logger=LoggerFactory.getLogger(AssignmentController.class);
	
	@Autowired
	private AttendanceService attendanceSevice;
	
	@RequestMapping("/attendances")
	public List<Attendance>getAllAttendances(){
		return attendanceSevice.getAllAttendances();
	}
	
	@PostMapping("/attendance")
	public void addAttendance(@RequestBody Attendance attendance) {
		if(attendance!=null && attendance.getUser()!=null) {
			logger.info("Inside addAssignment:{}",attendance.getUser().getId());
		}
		
		attendanceSevice.addAttendance(attendance);
	}
	
	@PutMapping("/attendance/{id}")
	public void updateAttendance(@PathVariable Integer id, @RequestBody Attendance attendance) {
	
		attendanceSevice.updateAttendance(id, attendance);
	}
	@DeleteMapping("/attendance/{id}")
	public void deleteTest(@PathVariable Integer id) {
		attendanceSevice.deleteAttendance(id);
	}

	public AttendanceController() {
		// TODO Auto-generated constructor stub
	}


	@RequestMapping("/getMyAttendance")
	public List<Attendance>getMyAttendance(HttpServletRequest httpServletRequest){
		return attendanceSevice.getMyAttendance(httpServletRequest);
	}
	
}
