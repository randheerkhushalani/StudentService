package com.example.studentservice.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.studentservice.model.Student;

@ControllerAdvice
@SuppressWarnings({ "rawtypes", "unchecked" })
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ExceptionResponse error = new ExceptionResponse("Server Error", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ExceptionResponse error = new ExceptionResponse("Record Not Found", details);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PassportNumberInvalidException.class)
	public final ResponseEntity<Object> handlePassportNumberInvalidException(PassportNumberInvalidException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ExceptionResponse error = new ExceptionResponse("Passport number invalid", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(GradePointsRangeInvalidException.class)
	public final ResponseEntity<Object> handleGradePointsRangeInvalidException(GradePointsRangeInvalidException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ExceptionResponse error = new ExceptionResponse("Grade Points range invalid", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ExceptionResponse error = new ExceptionResponse("Validation Failed", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ExceptionResponse error = new ExceptionResponse("Validation Failed", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

}