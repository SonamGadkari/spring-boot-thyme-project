package com.springboot.thymeprj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	List<Student> stuList=studentService.findAll();
	themodel.addAttribute("students",stuList);
	return "list-students";
}

@GetMapping("/showFormForAdd")
public String showForm(Model themodel)
{
	themodel.addAttribute("student",new Student());	
	return "showForm";
}

@GetMapping("/aboutme")
public String showAboutme(Model themodel)
{
	return "aboutme";
}

@PostMapping("/save")
public String saveForm(@ModelAttribute("student") Student theStudent)
{
	studentService.save(theStudent);
	return "redirect:/students/list";	
}
}
