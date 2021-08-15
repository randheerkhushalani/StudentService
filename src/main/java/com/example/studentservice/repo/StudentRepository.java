package com.example.studentservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentservice.model.Student;




@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
	List<Student> findByFirstName(String firstName);
	List<Student> findByGradePoints(Double gradePoint);
	List<Student> findByFirstNameLike(String namePattern);
	Optional<Student> findByPassportNumber(String passPortNumber);
	List<Student> findByGradePointsBetween(Double start, Double end);
	List<Student> findByGradePointsGreaterThanEqual(Double gradePoint);
	List<Student> findTop5ByGradePoints(Double gradePoint);
	List<Student> findByPassportNumberStartingWith(String prefix);
	Student findFirstByGradePointsOrderByGradePointsDesc(Double gradePoint);
}
