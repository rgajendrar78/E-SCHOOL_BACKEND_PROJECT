package com.in.eschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.eschool.model.TimeTable;
import com.in.eschool.service.TimeTableService;
@RestController
@CrossOrigin("*")
public class TimeTableController {
	
	@Autowired
	private TimeTableService timeTableService; 
	
	@RequestMapping("/timetables")
	public List<TimeTable>getAllTimeTables(){
		return timeTableService.getAllTimeTables();
	}
	
	@PostMapping("/timetable")
	public void addTimeTable(@RequestBody TimeTable timeTable) {
		
		timeTableService.addTimeTable(timeTable);
	}
	
	@PutMapping("/timetable/{id}")
	public void updateStudent(@PathVariable Integer id, @RequestBody TimeTable timeTable) {
	
		timeTableService.updateTimeTable(id, timeTable);
	}
	@DeleteMapping("/timetable/{id}")
	public void deleteTimeTable(@PathVariable Integer id) {
		timeTableService.deleteTimeTable(id);
	}

	public TimeTableController() {
		// TODO Auto-generated constructor stub
	}

}
