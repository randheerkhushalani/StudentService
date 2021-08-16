package com.example.studentservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.studentservice.model.Student;

public interface StudentService {
	List<Student> findByFirstNameLike(String namePattern);
	Student findByPassPortNumber(String passPortNumber);
	List<Student> findByGradePointsBetween(BigDecimal start, BigDecimal end);
	List<Student> findByGradePointsGreaterThanEqual(BigDecimal gradePoint);
	List<Student> findTop5ByGradePoints(BigDecimal gradePoint);
	List<Student> findByPassportNumberStartingWith(String prefix);
	Student findFirstByGradePointsOrderByGradePointsDesc(BigDecimal gradePoint);
	Student getStudentByStudentId(Integer studentId);
	List<Student> getStudentByFirstName(String studentName);
	List<Student> getStudentByGradePoints(BigDecimal gradePoints);
	List<Student> getStudentFirstNameLike(String namePattern);
	void deleteStudent(Integer studentId);
	Student getStudentByFirstNameAndLastName(String firstName, String lastName);
}
