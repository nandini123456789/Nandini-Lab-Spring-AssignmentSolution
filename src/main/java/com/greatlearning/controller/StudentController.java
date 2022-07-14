package com.greatlearning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.entity.Student;
import com.greatlearning.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;

	@GetMapping("/test")
	public String get() {
		return "Hello World";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

//	@RequestMapping("/list")
//	public String listOfStudents(Model model) {
//		List<Student> students = studentService.getAll();
//		model.addAttribute("Student",students);
//		return "list-students";
//		
//	}
//
//	@RequestMapping("/showFormForAdd")
//	public String showFormForAdd(Model model) int id {
//		 Student newStudent= new Student();
//		 model.addAttribute("Student",newStudent);
//		 return "Student-form";
//	}
//	@RequestMapping("/showFormForUpdate")
//	public String showFormForAdd(@RequestParam("studentId") int id, Model model) {
//		 Student student= studentService.updateDetailsByID(0, null)
//		 model.addAttribute("Student",newStudent);
//		 return "Student-form";
//	}
//	

	@GetMapping("/all-students")
	public ResponseEntity<List<Student>> getAllStudentsDetails() {
		List<Student> studentsList = null;
		studentsList = studentService.getAll();
		if (studentsList.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(studentsList));
	}

	@PostMapping("/new-student")
	public ResponseEntity<Student> addNewStudentDetails(@RequestBody Student student) {
		Student newStudent = null;
		try {
			newStudent = studentService.addNewStudent(student);
			return ResponseEntity.of(Optional.of(newStudent));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable(value = "id") int id) {
		try {
			studentService.deleteDetailsById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateStudentDetialsById(@PathVariable(value = "id") int id,
			@RequestBody Student student) {
		try {
			studentService.updateDetailsByID(id, student);
			return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
