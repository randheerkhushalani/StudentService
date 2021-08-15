package com.example.studentservice.service;

import java.util.List;
import java.util.Optional;

import com.example.studentservice.model.Student;

public interface StudentService {
	List<Student> findByFirstNameLike(String namePattern);
	Student findByPassPortNumber(String passPortNumber);
	List<Student> findByGradePointsBetween(Double start, Double end);
	List<Student> findByGradePointsGreaterThanEqual(Double gradePoint);
	List<Student> findTop5ByGradePoints(Double gradePoint);
	List<Student> findByPassportNumberStartingWith(String prefix);
	Student findFirstByGradePointsOrderByGradePointsDesc(Double gradePoint);
	Student getStudentByStudentId(Integer studentId);
	List<Student> getStudentByFirstName(String studentName);
	List<Student> getStudentByGradePoints(Double gradePoints);
	List<Student> getStudentFirstNameLike(String namePattern);
	void deleteStudent(Integer studentId);
	Student getStudentByFirstNameAndLastName(String firstName, String lastName);
}
