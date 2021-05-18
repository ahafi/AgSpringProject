package com.classroom.virtualclassroom.dto;



public class UserDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long Id;		
	
	private String login;
	
	private String password;
	
	private String role;
	
		
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserDTO(Long id, String login, String password, String role) {
		super();
		Id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	}


