package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query("from Course c where c.courseName = :courseName")
	Course findByName(@Param("courseName") String courseName);
}
