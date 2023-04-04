package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("from Student s where s.StudentName = :StudentName")
	Student findByName(@Param("StudentName") String StudentName);
}
