package com.faisal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.faisal.model.Role;
import com.faisal.model.Student;
import com.faisal.model.User;
import com.faisal.service.RoleService;
import com.faisal.service.StudentService;
import com.faisal.service.UserService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostConstruct
	public void initializeUsers() {

		System.out.println("Inside Post construct");
		
		Role adminRole=new Role("Admin");
		Role userRole=new Role("User");
		
		roleService.add(userRole);
		roleService.add(adminRole);
		
		List<Role> adminRoles = new ArrayList<Role>();
		adminRoles.add(adminRole);
		adminRoles.add(userRole);

		List<Role> userRoles = new ArrayList<Role>();
		userRoles.add(userRole);

		
		User admin = new User("faisal", "faisal", "ACTIVE", adminRoles);
		User user = new User("raza", "raza", "ACTIVE", userRoles);
		
		userService.add(user);
		userService.add(admin);
		
		System.out.println("user="+user);
		System.out.println("admin="+admin);

	}

	@RequestMapping({ "/index", "/" })
	public String setupForm(Map<String, Object> map) {

		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}

	@RequestMapping(value = "/student.do", method = RequestMethod.POST)
	public String doActions(@ModelAttribute Student student,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		Student studentResult = new Student();

		switch (action.toLowerCase()) {
		case "add":
			studentService.add(student);
			studentResult = student;
			break;
		case "edit":
			studentService.edit(student);
			studentResult = student;
			break;
		case "delete":
			studentService.delete(student.getId());
			studentResult = new Student();
			break;
		case "search":
			Student searchedStudent = studentService
					.getStudent(student.getId());
			studentResult = searchedStudent != null ? searchedStudent
					: new Student();
			break;

		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";

	}

}
