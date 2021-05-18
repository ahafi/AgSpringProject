package com.classroom.virtualclassroom.dto;

import java.util.Date;

public class SchoolworkDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private Date dateSchoolwork;
	
	private String subjectTitle;
		
		
	public SchoolworkDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SchoolworkDTO(Long id, Date dateSchoolwork, String subjectTitle) {
		super();
		Id = id;
		this.dateSchoolwork = dateSchoolwork;
		this.subjectTitle = subjectTitle;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Date getDateSchoolwork() {
		return dateSchoolwork;
	}


	public void setDateSchoolwork(Date dateSchoolwork) {
		this.dateSchoolwork = dateSchoolwork;
	}


	public String getSubjectTitle() {
		return subjectTitle;
	}


	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

			
}