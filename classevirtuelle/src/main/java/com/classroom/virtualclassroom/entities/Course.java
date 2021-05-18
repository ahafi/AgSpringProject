package com.classroom.virtualclassroom.entities;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="Cours")
public class Course implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "heureDebut")
	private String startTime;
	
	@Column(name = "heureFin")
	private String endTime;
	
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "matiere", nullable = false)
    private Subject subject;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "classe", nullable = false)
    private Classroom classroom;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jour", nullable = false)
    private Day day;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Long id, String startTime, String endTime, Subject subject, Classroom classroom, Day day) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.subject = subject;
		this.classroom = classroom;
		this.day = day;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", subject=" + subject
				+ ", classroom=" + classroom + ", day=" + day + "]";
	}

	
}
