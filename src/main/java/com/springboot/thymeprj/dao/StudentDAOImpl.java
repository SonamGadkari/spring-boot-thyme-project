package com.springboot.thymeprj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.thymeprj.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	//Constructor Injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Query<Student> query=session.createQuery("from Student",Student.class);					
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public Student listStudent(int id)	
	{
		Session session= entityManager.unwrap(Session.class);
		Student stu=session.get(Student.class,id);
		return stu;		
	}	
	@Override
	@Transactional
	public Student addStudent(Student thestudent)
	{
		Session session =entityManager.unwrap(Session.class);
		session.saveOrUpdate(thestudent);
		return session.get(Student.class,thestudent.getId());
	}
	@Override
	@Transactional
	public void delStudent(int id)
	{
		Session session =entityManager.unwrap(Session.class);
		Student stu=session.get(Student.class,id);
		session.remove(stu);
	}
	
}
