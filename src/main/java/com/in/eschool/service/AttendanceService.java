package com.in.eschool.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.in.eschool.model.Attendance;

public interface AttendanceService {

	 void addAttendance(Attendance attendance);
	 
	void deleteAttendance(Integer id);
	
	List<Attendance> getAllAttendances();
	
	 void updateAttendance(Integer id,Attendance attendance);

	List<Attendance> getMyAttendance(HttpServletRequest request);
	
}



