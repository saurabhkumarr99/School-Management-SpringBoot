package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Course;

@Service
public class CourseDAO {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getCourseById(int courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}

	public Course getCourseByName(String courseName) {
		return courseRepository.findByName(courseName);
	}

	public Course registerCourse(Course course) {
		return courseRepository.save(course);
	}

	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}
}
