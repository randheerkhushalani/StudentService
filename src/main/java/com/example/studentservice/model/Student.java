package com.example.studentservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message="first name should have atleast one character")
	private String firstName;
	@NotBlank(message="last name shoukd have atleast one character")
	private String lastName;
	@Size(min=6,message="Passport number should be of atleast 6 characters")
	@Pattern(regexp ="RT[0-9]{4}")
	private String passportNumber;
	@DecimalMin(value = "4.5", message="Grade Points should be greater than 4.5")
	@DecimalMax(value = "10.0", message="Grade Points should be less than or equal to 10.0")
	private BigDecimal gradePoints;
	private String branch;
	public Student(int id, String firstName, String lastName, String passportNumber, BigDecimal gradePoints, String branch) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.gradePoints = gradePoints;
		this.branch = branch;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public BigDecimal getGradePoints() {
		return gradePoints;
	}
	public void setGradePoints(BigDecimal gradePoints) {
		this.gradePoints = gradePoints;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", passportNumber="
				+ passportNumber + ", gradePoints=" + gradePoints + ", branch=" + branch + "]";
	}
	
	
}