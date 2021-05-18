package com.classroom.virtualclassroom.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Classe")
public class Classroom implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "nom")
	private String name;
	
	@Column(name = "anneeScolaire")
	private String schoolyear;
	
	@OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Student> students;
	
	
	@OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Course> courses;

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classroom(Long id, String name, String schoolyear, Teacher teacher, Set<Student> students,
			Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.schoolyear = schoolyear;
		this.students = students;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", name=" + name + ", schoolyear=" + schoolyear + 
				
				", students=" + students + ", courses=" + courses + "]";
	}

	
}
