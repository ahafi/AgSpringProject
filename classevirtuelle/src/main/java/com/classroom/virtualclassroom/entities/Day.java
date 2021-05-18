package com.classroom.virtualclassroom.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name="Jour")
public class Day {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "date")
	private Date date;
	
	@OneToMany(mappedBy = "day", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Course> courses;

	public Day() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Day(Long id, Date date, Set<Course> courses) {
		super();
		this.id = id;
		this.date = date;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Day [id=" + id + ", date=" + date + ", courses=" + courses + "]";
	}
	
	




	
}
