package de.dh_karlsruhe.it.softweng.studyTrade.login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	private String username;
	private String password;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 5)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@NotEmpty
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
