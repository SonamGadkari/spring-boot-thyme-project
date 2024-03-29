package com.springboot.thymeprj.service;

import java.util.List;

import com.springboot.thymeprj.model.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
}
