package com.classroom.virtualclassroom.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="devoir")
public class Schoolwork implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "dateDevoir")
	private Date dateSchoolwork;
	
	  
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "matiere", nullable = false)
    private Subject subject;


	public Schoolwork() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Schoolwork(Long id, Date dateSchoolwork, Subject subject) {
		super();
		this.id = id;
		this.dateSchoolwork = dateSchoolwork;
		this.subject = subject;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateSchoolwork() {
		return dateSchoolwork;
	}


	public void setDateSchoolwork(Date dateSchoolwork) {
		this.dateSchoolwork = dateSchoolwork;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Schoolwork [id=" + id + ", dateSchoolwork=" + dateSchoolwork + ", subject=" + subject + "]";
	}
    
    
}
