package com.example.studentservice.repo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentservice.model.Student;




@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
	List<Student> findByFirstName(String firstName);
	List<Student> findByGradePoints(BigDecimal gradePoint);
	List<Student> findByFirstNameLike(String namePattern);
	Optional<Student> findByPassportNumber(String passPortNumber);
	List<Student> findByGradePointsBetween(BigDecimal start, BigDecimal end);
	List<Student> findByGradePointsGreaterThanEqual(BigDecimal gradePoint);
	List<Student> findTop5ByGradePoints(BigDecimal gradePoint);
	List<Student> findByPassportNumberStartingWith(String prefix);
	Student findFirstByGradePointsOrderByGradePointsDesc(BigDecimal gradePoint);
}
