package com.in.eschool.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.eschool.model.Attendance;
import com.in.eschool.repository.AttendanceRepository;
import com.in.eschool.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	private Logger logger=LoggerFactory.getLogger(AttendanceServiceImpl.class);
	
	@Autowired
	public AttendanceRepository attendanceRepository;
	
	@Override
	public void addAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);	
	}

	@Override
	public void deleteAttendance(Integer id) {
		attendanceRepository.deleteById(id);
	}

	@Override
	public List<Attendance> getAllAttendances() {
		List<Attendance> attendances=new ArrayList<>();
		 attendanceRepository.findAll().forEach(attendances::add);
		 return attendances;
	}

	@Override
	public void updateAttendance(Integer id, Attendance attendance) {
		attendanceRepository.save(attendance);
		
	}

	@Override
	public List<Attendance> getMyAttendance(HttpServletRequest request){
		HttpSession httpSession = request.getSession(true);
		String username=(String) httpSession.getAttribute("username");
		logger.info("Get attendence for username:{}",username);
		return attendanceRepository.findByUsername(username);
	}
}
