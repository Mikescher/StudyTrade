package de.dh_karlsruhe.it.softweng.studyTrade.login;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	private String username;
	private String password;

	@NotNull
	@NotEmpty(message ="Bitte geben sie eine Benutzernamen an")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@NotEmpty(message ="Bitte geben sie ein Passwort an")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = doHash(password);
	}
	
	public String doHash(String s) {
		return String.valueOf(s.hashCode()); // Worst Hashing evar ^^ Just 4 Testing
	}
	
	public boolean isInDB() {
		return username.equalsIgnoreCase("root") && password.equalsIgnoreCase(doHash("123"));
	}
}
