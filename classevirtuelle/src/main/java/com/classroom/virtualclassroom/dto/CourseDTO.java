package com.classroom.virtualclassroom.dto;

import java.util.Date;

public class CourseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;	
	
	private String startTime;
	
	private String endTime;	
	
	private Date dayDate;
	
	private String subjectTitle;
	
	private String classroomName;
	

		
		
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Date getDayDate() {
		return dayDate;
	}

	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}

	

    public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
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