package com.classroom.virtualclassroom.dto;

import java.util.Date;

public class SubjectDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private String title;
	
	private Date dateSchoolwork;
	
	private String courseStartTime;
	
	private String courseEndTime;
		
		
	public SubjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SubjectDTO(Long id, String title, Date dateSchoolwork, String courseStartTime, String courseEndTime) {
		super();
		Id = id;
		this.title = title;
		this.dateSchoolwork = dateSchoolwork;
		this.courseStartTime = courseStartTime;
		this.courseEndTime = courseEndTime;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getDateSchoolwork() {
		return dateSchoolwork;
	}


	public void setDateSchoolwork(Date dateSchoolwork) {
		this.dateSchoolwork = dateSchoolwork;
	}


	public String getCourseStartTime() {
		return courseStartTime;
	}


	public void setCourseStartTime(String courseStartTime) {
		this.courseStartTime = courseStartTime;
	}


	public String getCourseEndTime() {
		return courseEndTime;
	}


	public void setCourseEndTime(String courseEndTime) {
		this.courseEndTime = courseEndTime;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
			
}