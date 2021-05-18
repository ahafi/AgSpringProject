package com.classroom.virtualclassroom.dto;



public class TeacherDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String phone;
	
	private String studentName;
	
	private String classroomName;
	
	
	
	public TeacherDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TeacherDTO(Long id, String firstname, String lastname, String email, String phone, String studentName,
			String classroomName) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.studentName = studentName;
		this.classroomName = classroomName;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public String getClassroomName() {
		return classroomName;
	}



	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	}


