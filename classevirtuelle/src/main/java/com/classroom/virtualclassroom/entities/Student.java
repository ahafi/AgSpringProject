package com.classroom.virtualclassroom.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name="Eleve")
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "nom")
	private String firstname;
	
	@Column(name = "prenom")
	private String lastname;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "dateNaissance")
	private Date dateOfBirth;
	
	 
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "enseignant",referencedColumnName = "id", nullable = true)
	    private Teacher teacher;
	    	  
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "classe", referencedColumnName = "id", nullable = true)
	    private Classroom classroom;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "parent", referencedColumnName = "id",nullable = true)
	    private Parent parent;

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Student(Long id, String firstname, String lastname, Date dateOfBirth, Teacher teacher,
				Classroom classroom, Parent parent) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.dateOfBirth = dateOfBirth;
			this.teacher = teacher;
			this.classroom = classroom;
			this.parent = parent;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Teacher getTeacher() {
			return teacher;
		}

		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}

		public Classroom getClassroom() {
			return classroom;
		}

		public void setClassroom(Classroom classroom) {
			this.classroom = classroom;
		}

		public Parent getParent() {
			return parent;
		}

		public void setParent(Parent parent) {
			this.parent = parent;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth="
					+ dateOfBirth + ", teacher=" + teacher + ", classroom=" + classroom + ", parent=" + parent + "]";
		}

			
		
	}


