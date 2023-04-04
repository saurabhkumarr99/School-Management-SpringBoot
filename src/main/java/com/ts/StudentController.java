package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.StudentDAO;
import com.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentDAO studentDAO;

	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
		return studentDAO.getAllStudents();
	}

	@GetMapping("/getStudentById/{studentId}")
	public Student getEmpById(@PathVariable("studentId") int studentId) {
		Student student = studentDAO.getStudentById(studentId);

		if (student != null)
			return student;
		return new Student(0, "Student Not Found!!!", 0, null);
	}

	@GetMapping("/getStudentByName/{studentName}")
	public Student getDeptByName(@PathVariable("studentName") String studentName) {
		Student student = studentDAO.getStudentByName(studentName);

		if (student != null)
			return student;
		return new Student(0, "student Not Found!!!", 0, null);
	}

	@PostMapping("/registerStudent")
	public String registerStudent(@RequestBody Student student) {
       
		Student std = studentDAO.registerStudent(student);

		if (std != null)
			return std + "\nStudent Registered into the Database";

		return "Student Registeration Failed!!!";
	}

	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		
		Student std = studentDAO.registerStudent(student);

		if (std != null)
			return std + "\nStudent Record Updated in the Database";

		return "Student Updation Failed!!!";
	}

	@DeleteMapping("/deleteStudent/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int studentId) {
	
		studentDAO.deleteStudent(studentId);;
		return "Student(" + studentId + ") Record Deleted Successfully!";
	}

}
