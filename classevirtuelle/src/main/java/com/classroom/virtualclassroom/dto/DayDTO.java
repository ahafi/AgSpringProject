package com.classroom.virtualclassroom.dto;

import java.util.Date;

public class DayDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private String name;
	
	private Date date;
		
	private String course;
	
	
	
	public DayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DayDTO(Long id, String name, Date date, String course) {
		super();
		Id = id;
		this.name = name;
		this.date = date;
		this.course = course;
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



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
			
}