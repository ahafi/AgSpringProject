package com.classroom.virtualclassroom.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Matiere")
public class Subject implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "intitule")
	private String title;
	
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Course> courses;
	
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Schoolwork> schoolworks;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Long id, String title, Set<Course> courses, Set<Schoolwork> schoolworks) {
		super();
		this.id = id;
		this.title = title;
		this.courses = courses;
		this.schoolworks = schoolworks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Schoolwork> getSchoolworks() {
		return schoolworks;
	}

	public void setSchoolworks(Set<Schoolwork> schoolworks) {
		this.schoolworks = schoolworks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", courses=" + courses + ", schoolworks=" + schoolworks + "]";
	}


}
