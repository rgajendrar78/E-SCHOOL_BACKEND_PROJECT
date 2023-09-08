package com.in.eschool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.in.eschool.model.Test;
import com.in.eschool.service.TestService;


@RestController
@CrossOrigin("*")
public class TestController {
	
	@Autowired
	private TestService testService; 
	
	@RequestMapping("/tests")
	public List<Test>getAllTests(){
		return testService.getAllTests();
	}
	
	@PostMapping("/test")
	public void addTest(@RequestBody Test test) {
		
		testService.addTest(test);
	}
	
	@PutMapping("/test/{id}")
	public void updateTest(@PathVariable Integer id, @RequestBody Test test) {
	
		testService.updateTest(id, test);
	}
	@DeleteMapping("/test/{id}")
	public void deleteTest(@PathVariable Integer id) {
		testService.deleteTest(id);
	}
	
	
	@RequestMapping("/getMyTest")
	public List<Test>getMyTest(HttpServletRequest httpServletRequest){
		return testService.getMyTest(httpServletRequest);
	}

	public TestController() {
		// TODO Auto-generated constructor stub
	}

}
