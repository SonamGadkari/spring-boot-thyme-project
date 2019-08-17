package com.springboot.thymeprj.dao;

import java.util.List;

import com.springboot.thymeprj.model.Student;

public interface StudentDAO {
	
	public List<Student> listAll();

	public Student listStudent(int id);

	public Student addStudent(Student thestudent);

	public void delStudent(int id);

}
