package com.springboot.thymeprj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.thymeprj.model.Student;
import com.springboot.thymeprj.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository)
	{
		this.studentRepository=studentRepository;
	}
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> students=studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Student> output=studentRepository.findById(theId);
		Student stu=null;
		if(output.isPresent())
		{
			stu=output.get();
		}
		return stu;
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
	}

}
