package com.in.eschool.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.in.eschool.model.Attendance;
import com.in.eschool.model.SecurityUser;
import com.in.eschool.model.User;
import com.in.eschool.repository.SecurityUserRepository;
import com.in.eschool.repository.UserRepository;
import com.in.eschool.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private Logger logger=LoggerFactory.getLogger(AttendanceServiceImpl.class);
	@Autowired
	public UserRepository StudentRepo;
	
	@Autowired
	public SecurityUserRepository securityUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllStudents()
	{
		List<User> students =new ArrayList<>();
		StudentRepo.findAll().forEach(students::add);
		return students;
		
	}

	@Override
	public User addStudent(User student) {
		
		SecurityUser securityUser=new SecurityUser(student.getEmail(),passwordEncoder.encode(student.getPassword()) , true, student.getRole());
		securityUserRepository.save(securityUser);
		return StudentRepo.save(student);
		
	}

	@Override
	public void updateStudent(Integer id, User student) {
		if(student!=null) {
			Optional<User> user= StudentRepo.findById(id);
		User temp=user.get();
		temp.setIsenable(student.isIsenable());
		StudentRepo.save(temp);
		System.out.println("Succesfully updata");
		}
		
	}

	@Override
	public void deleteStudent(Integer id) {
		StudentRepo.deleteById(id);
		
	}

	
    @Override
	public List<User> findUserByFname(String fname) {
		return StudentRepo.findUserByFname(fname);
	}

    @Override
	public List<User>getMyProfile(HttpServletRequest request){
		HttpSession httpSession = request.getSession(true);
		String Email=(String) httpSession.getAttribute("username");
		logger.info("Get user for username:{}",Email);
		return StudentRepo.findUserByEmail(Email);
	}
}
