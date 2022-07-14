package com.greatlearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.greatlearning.entity.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
