package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.greatlearning.entity.Student;

@Component
public interface IStudentService {
	public List<Student> getAll();

	public void deleteDetailsById(int id);

	public Student addNewStudent(Student student);

	public void updateDetailsByID(int id, Student student);
	
	public Optional<Student> getById(int id);

}

