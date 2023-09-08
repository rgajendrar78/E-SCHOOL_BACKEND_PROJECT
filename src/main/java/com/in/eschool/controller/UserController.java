package com.in.eschool.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.eschool.model.Attendance;
import com.in.eschool.model.User;
import com.in.eschool.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	private Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService UserService;
	

	
	@GetMapping("/users")
	public List<User>getAllStudents(){
		return UserService.getAllStudents();
	}

		
//	@RequestMapping("/student")
//	public List<User>findUserByFname(@PathParam("fname")String fname){
//		logger.info("@findUserByName fname:{}",fname);
//		if(fname!=null) {
//			return studentService.findUserByFname(fname);
//		}
//		else {
//			return studentService.getAllStudents();
//		}
//		
//  }
	@GetMapping("/user/{fname}")
	public List<User>findUserByFname(@PathVariable String fname){
		return UserService.findUserByFname(fname);
	}
	
	
	
	@GetMapping("/getMyProfile/{Email}")
	public List<User>findUserByEmail(@PathVariable String Email){
		return UserService.findUserByFname(Email);
	}
	
	
	
//	@RequestMapping(method=RequestMethod.POST,value="/subjects")
	@PostMapping("/user")
	public User addStudent(@RequestBody User user ) {
	
		return this.UserService.addStudent(user);
	}
	
//	@RequestMapping(method=RequestMethod.PUT,value="/subjects/{id}")
	@PutMapping("/user/{id}")
	public void updateStudent(@PathVariable Integer id, @RequestBody User user) {
	
		UserService.updateStudent(id, user);
	}
	
	@DeleteMapping("/user/{id}")
//	@RequestMapping(method=RequestMethod.DELETE,value="/subjects/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		UserService.deleteStudent(id);
	}
	
	@PostMapping("/user/{id}")
	public Boolean update(@PathVariable Integer id) {
		 UserService.updateStudent(id, null);
		 return true;
	}
	
	@GetMapping("/getMyProfile")
	public List<User>getMyProfile(HttpServletRequest httpServletRequest){
		return UserService.getMyProfile(httpServletRequest);
	}

}
