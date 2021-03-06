package com.example.studentservice.controller;



import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.studentservice.model.Student;
import com.example.studentservice.repo.StudentRepository;
import com.example.studentservice.service.StudentService;

@RestController
@RequestMapping(path = "/students")
@Validated
public class StudentController {
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> addStudent( @Valid @RequestBody Student student) {
		Student savedStudent  = studentRepo.save(student);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();  
		return ResponseEntity.created(location).build();  
	}

	@GetMapping("{studentId}")
	public Student retrieveStudent(@PathVariable @NotBlank int studentId) {
		return studentService.getStudentByStudentId(studentId);
	}

	@GetMapping
	public List<Student> retrieveAllStudents() {
		List<Student> student = studentRepo.findAll();
		return student;
	}

	@GetMapping("/firstname/{firstName}")
	public List<Student>  retrieveByFirstName(@PathVariable String firstName) {
		return studentService.getStudentByFirstName(firstName);
	}

	@GetMapping("/firstname/{firstName}/lastName/{lastName}")
	public Student retrieveByFirstAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
		return studentService.getStudentByFirstNameAndLastName(firstName, lastName);
	}

	@GetMapping("/gradepoint/{gradePoints}")
	public List<Student> retrieveByGradePoints(@PathVariable BigDecimal gradePoints) {
		return studentService.getStudentByGradePoints(gradePoints);
	}
	
	@GetMapping("/gradepoint/{start}/{end}")
	public List<Student> retrieveBetweenGradePoints(@PathVariable("start") BigDecimal start, @PathVariable("end") BigDecimal end ) {
		return studentService.findByGradePointsBetween(start, end);
	}
	
	@GetMapping("/passportnumber/{passportNumber}")
	public Student retrieveByPassPortNumber(@PathVariable @Size(min=6, message="Should be atleast 6 characters") String passportNumber ) {
		return studentService.findByPassPortNumber(passportNumber);
	}
	
	@DeleteMapping(value="/{studentId}")    
	public void delete(@PathVariable int studentId){ 
		studentService.deleteStudent(studentId);
	}    
	
	@GetMapping("/passportnumber/start/{prefix}")
	public List<Student> findByPassportNumberStartingWith(@PathVariable String prefix) {
		return studentService.findByPassportNumberStartingWith(prefix);
	}
	
	@GetMapping("/gradepoint/highest/{gradepoint}")
	public Student findFirstByGradePointsOrderByGradePointsDesc(BigDecimal gradePoint) {
		return studentService.findFirstByGradePointsOrderByGradePointsDesc(gradePoint);
	}

	
}
