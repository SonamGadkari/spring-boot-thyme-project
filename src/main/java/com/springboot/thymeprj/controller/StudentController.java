package com.springboot.thymeprj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.thymeprj.model.Student;
import com.springboot.thymeprj.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	
@GetMapping("/list")
public String allStudents(Model themodel)
{
	/*Student stu= new Student(1,"Sonam","Gadekari","sonam.klu@gmail.com");
	Student stu1= new Student(2,"Suman","Gadekari","suman.klu@gmail.com");
	Student stu2= new Student(3,"Rohith","Gadekari","rohith.klu@gmail.com");
	List<Student> stuList=new ArrayList<Student>();
	stuList.add(stu);
	stuList.add(stu1);
	stuList.add(stu2);
	*/
	List<Student> stuList=studentService.findAll();
	themodel.addAttribute("students",stuList);
	return "list-students";
}
}
