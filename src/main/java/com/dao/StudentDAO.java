package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Student;

@Service
public class StudentDAO {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(int studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	public Student getStudentByName(String studentName) {
		return studentRepository.findByName(studentName);
	}

	public Student registerStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
	}

}
