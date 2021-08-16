package com.example.studentservice.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentservice.exception.GradePointsRangeInvalidException;
import com.example.studentservice.exception.PassportNumberInvalidException;
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
		if(!passPortNumber.startsWith("RT")) {
			throw new PassportNumberInvalidException("Passport number is invalid");
		}
			return studentRepository.findByPassportNumber(passPortNumber).orElseThrow(() -> 
			new StudentNotFoundException("Student not found with following passport number"));
		}

	@Override
	public List<Student> findByGradePointsBetween(BigDecimal start, BigDecimal end) {
		if(start.doubleValue()>end.doubleValue()) {
			throw new GradePointsRangeInvalidException("lower limit should be less than upper limit");
		} 
			return studentRepository.findByGradePointsBetween(start, end);
	}

	@Override
	public List<Student> findByGradePointsGreaterThanEqual(BigDecimal gradePoint) {
		if(gradePoint.doubleValue() > 10 || gradePoint.doubleValue() < 4.5) {
			throw new GradePointsRangeInvalidException("Gradepoint must be between 4.5 and 10");
		}
		return studentRepository.findByGradePointsGreaterThanEqual(gradePoint);
	}

	@Override
	public List<Student> findTop5ByGradePoints(BigDecimal gradePoint) {
		if(gradePoint.doubleValue() > 10) {
			throw new GradePointsRangeInvalidException("Entered GradePoint is out of range");
		}
		return studentRepository.findTop5ByGradePoints(gradePoint);
	}

	@Override
	public List<Student> findByPassportNumberStartingWith(String prefix) {
		if(!prefix.startsWith("RT")) {
			throw new PassportNumberInvalidException("Passport number is invalid");
		} else {
			return studentRepository.findByPassportNumberStartingWith(prefix) ;
		}
	}

	@Override
	public Student findFirstByGradePointsOrderByGradePointsDesc(BigDecimal gradePoint) {
		if(gradePoint.doubleValue() > 10 || gradePoint.doubleValue() < 4.5) {
			throw new GradePointsRangeInvalidException("Gradepoint must be between 4.5 and 10");
		}
		return studentRepository.findFirstByGradePointsOrderByGradePointsDesc(gradePoint);
	}

	@Override
	public List<Student> getStudentByGradePoints(BigDecimal gradePoints) {
		if(gradePoints.doubleValue() > 10 || gradePoints.doubleValue() < 4.5) {
			throw new GradePointsRangeInvalidException("Gradepoint must be between 4.5 and 10");
		}
		return studentRepository.findByGradePoints(gradePoints);
	}

	@Override
	public List<Student> getStudentFirstNameLike(String namePattern) {
		return studentRepository.findByFirstNameLike(namePattern);
	}
}
