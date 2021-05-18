package com.classroom.virtualclassroom.dto;


public class ClassroomDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private String name;
	
	private String schoolyear;
	
	private String teacherName;
	
	private String course;
	
	private String studentName; 
	
	
	public ClassroomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClassroomDTO(Long id, String name, String schoolyear, String teacherName, String course,
			String studentName) {
		super();
		Id = id;
		this.name = name;
		this.schoolyear = schoolyear;
		this.teacherName = teacherName;
		this.course = course;
		this.studentName = studentName;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSchoolyear() {
		return schoolyear;
	}


	public void setSchoolyear(String schoolyear) {
		this.schoolyear = schoolyear;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}