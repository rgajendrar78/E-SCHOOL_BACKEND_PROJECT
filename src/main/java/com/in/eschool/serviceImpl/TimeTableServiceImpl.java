package com.in.eschool.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.eschool.model.TimeTable;
import com.in.eschool.repository.TimeTableRepository;
import com.in.eschool.service.TimeTableService;

@Service
public class TimeTableServiceImpl implements TimeTableService {
	
	@Autowired
	public TimeTableRepository timeTableRepo;

	@Override
	public List<TimeTable> getAllTimeTables()
	{
		List<TimeTable> timeTable =new ArrayList<>();
		timeTableRepo.findAll().forEach(timeTable::add);
		return timeTable;	
	}

	@Override
	public void addTimeTable(TimeTable timeTable) {
		timeTableRepo.save(timeTable);	
	}

	@Override
	public void updateTimeTable(Integer id, TimeTable timeTable) {
		timeTableRepo.save(timeTable);	
	}

	@Override
	public void deleteTimeTable(Integer id) {
		timeTableRepo.deleteById(id);
	}

}
