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
import com.in.eschool.model.Test;
import com.in.eschool.repository.TestRepository;
import com.in.eschool.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	private Logger logger=LoggerFactory.getLogger(AttendanceServiceImpl.class);

	@Autowired
	public TestRepository testRepo;

	@Override
	public void addTest(Test test) {
		// TODO Auto-generated method stub
		testRepo.save(test);
	}
	@Override
	public void deleteTest(Integer id) {
		// TODO Auto-generated method stub
		testRepo.deleteById(id);	
	}

	@Override
	public void updateTest(Integer id, Test test) {
		// TODO Auto-generated method stub
		testRepo.save(test);
	}
	@Override
	public List<Test> getAllTests() {
		{
			List<Test> tests =new ArrayList<>();
			testRepo.findAll().forEach(tests::add);
			return tests;
			
		}
	}
		
		@Override
		public List<Test> getMyTest(HttpServletRequest request){
			HttpSession httpSession = request.getSession(true);
			String username=(String) httpSession.getAttribute("username");
			logger.info("Get test for username:{}",username);
			return testRepo.findByUsername(username);
		}
	}


