package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.greatlearning.dao.StudentRepository;
import com.greatlearning.entity.Student;

@Component
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAll() {
		List<Student> studentList = null;
		try {
			studentList = (List<Student>) studentRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public void deleteDetailsById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student addNewStudent(Student student) {
		Student newStudent = null;
		try {
			newStudent = studentRepository.save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newStudent;
	}

	@Override
	public void updateDetailsByID(int id, Student student) {
		student.setStudentId(id);
		studentRepository.save(student);

	}

	@Override
	public Optional<Student> getById(int id) {
		Optional<Student> student = null;
		try {
			student = studentRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

}
