package com.example.studentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentservice.exception.StudentNotFoundException;
import com.example.studentservice.model.Student;
import com.example.studentservice.repo.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student getStudentByStudentId(Integer studentId) {
		return studentRepository.findById(studentId).orElseThrow(() -> 
		new StudentNotFoundException("Student not found with following id"));
	}
	
	@Override
	public List<Student> getStudentByFirstName(String studentName) {
		return studentRepository.findByFirstName(studentName);
	}
	
	@Override
	public void deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
	}
	
	@Override
	public Student getStudentByFirstNameAndLastName(String firstName, String lastName) {
	 return studentRepository.findByFirstNameAndLastName(firstName,lastName).orElseThrow(() -> 
		new StudentNotFoundException("Student not found with following id"));
	}

	@Override
	public List<Student> findByFirstNameLike(String namePattern) {
		return studentRepository.findByFirstNameLike(namePattern);
	}

	@Override
	public Student findByPassPortNumber(String passPortNumber) {
		return studentRepository.findByPassportNumber(passPortNumber).orElseThrow(() -> 
		new StudentNotFoundException("Student not found with following id"));
	}

	@Override
	public List<Student> findByGradePointsBetween(Double start, Double end) {
		return studentRepository.findByGradePointsBetween(start, end);
	}

	@Override
	public List<Student> findByGradePointsGreaterThanEqual(Double gradePoint) {
		return studentRepository.findByGradePointsGreaterThanEqual(gradePoint);
	}

	@Override
	public List<Student> findTop5ByGradePoints(Double gradePoint) {
		return studentRepository.findTop5ByGradePoints(gradePoint);
	}

	@Override
	public List<Student> findByPassportNumberStartingWith(String prefix) {
		return studentRepository.findByPassportNumberStartingWith(prefix) ;
	}

	@Override
	public Student findFirstByGradePointsOrderByGradePointsDesc(Double gradePoint) {
		return studentRepository.findFirstByGradePointsOrderByGradePointsDesc(gradePoint);
	}

	@Override
	public List<Student> getStudentByGradePoints(Double gradePoints) {
		return studentRepository.findByGradePoints(gradePoints);
	}

	@Override
	public List<Student> getStudentFirstNameLike(String namePattern) {
		return studentRepository.findByFirstNameLike(namePattern);
	}
}
