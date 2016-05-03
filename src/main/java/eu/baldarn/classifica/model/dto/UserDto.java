package eu.baldarn.classifica.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

import eu.baldarn.classifica.model.User;

public class UserDto{
	
	private Long id;

	@NotEmpty(message = "select an username")
	private String username;
	
	@NotEmpty(message = "enter a password")
	private String password;
	
	public UserDto(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto(User user){
		this.username = user.getUsername();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}