package com.classroom.virtualclassroom.dto;


import java.util.Date;






public class StudentDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private String firstname;
	
	private String lastname;
	
	private String teacherName;
	
	private String parentName;
	
	private String classroomName; 
	
	private Date dateOfBirth;
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentDTO(Long id, String firstname, String lastname, String teacherName, String parentName, String classroomName,
			Date dateOfBirth) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.teacherName = teacherName;
		this.parentName = parentName;
		this.classroomName = classroomName;
		this.dateOfBirth = dateOfBirth;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getClassroomName() {
		return classroomName;
	}


	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	}


