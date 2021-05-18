package com.classroom.virtualclassroom.dto;



public class ParentDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String address;
	
	private String phone;
	
	
	
	public ParentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ParentDTO(Long id, String firstname, String lastname, String email, String address, String phone,
			String studentName) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	}


