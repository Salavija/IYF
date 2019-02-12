package it.documentManagementSystem.DTO;

public class UserPutDTO {
		
	private Long userId;
	private String name;
	private String lastName;
	private String password;	 

	
	public UserPutDTO(Long userId, String name, String lastName, String password) {
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}	

}
