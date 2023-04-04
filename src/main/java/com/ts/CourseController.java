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

import com.dao.CourseDAO;
import com.model.Course;

@RestController
public class CourseController {

	@Autowired
	CourseDAO courseDAO;

	@GetMapping("/getAllCourses")
	public List<Course> getAllCourse() {
		return courseDAO.getAllCourses();
	}

	@GetMapping("/getCourseById/{courseId}")
	public Course getCourseById(@PathVariable("courseId") int courseId) {
		Course course = courseDAO.getCourseById(courseId);

		if (course != null)
			return course;
		return new Course(0, "Course Not Found!!!", 0, null);
	}

	@GetMapping("/getCourseByName/{courseName}")
	public Course getCourseByName(@PathVariable("courseName") String courseName) {
		Course course = courseDAO.getCourseByName(courseName);

		if (course != null)
			return course;
		return new Course(0, "Course Not Found!!!", 0, null);
	}

	@PostMapping("/registerCourse")
	public String registerCourse(@RequestBody Course course) {

		Course crs = courseDAO.registerCourse(course);

		if (crs != null)
			return crs + "\nCourse Registered into the Database";

		return "Course Registeration Failed!!!";
	}

	@PutMapping("/updateCourse")
	public String updateCourse(@RequestBody Course course) {
		
		Course crs = courseDAO.registerCourse(course);

		if (crs != null)
			return crs + "\nCourse Record Updated in the Database";

		return "Course Updation Failed!!!";
	}

	@DeleteMapping("/deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable("courseId") int courseId) {
		
		courseDAO.deleteCourse(courseId);
		return "Course(" + courseId + ") Record Deleted Successfully!";
	}

}
