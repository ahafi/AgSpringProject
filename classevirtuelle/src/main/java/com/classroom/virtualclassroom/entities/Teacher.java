package com.classroom.virtualclassroom.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;





@Entity
@Table(name="Enseignant")
public class Teacher implements Serializable{
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
	
	@Column(name = "email")
	private String email;
		
	@Column(name = "numTel")
	private String phone;
	

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
		    private Set<Student> students;


	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Teacher(Long id, String firstname, String lastname, String email, String phone, Classroom classroom,
			Set<Student> students) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.students = students;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + ", students=" + students + "]";
	}


	

	
}

