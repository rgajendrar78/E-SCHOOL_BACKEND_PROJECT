package com.in.eschool.service;

import java.util.List;

import com.in.eschool.model.TimeTable;

public interface TimeTableService {
	
	void addTimeTable(TimeTable timetable);

	void deleteTimeTable(Integer id);

	void updateTimeTable(Integer id, TimeTable timetable);
	
	 List<TimeTable> getAllTimeTables();



}
