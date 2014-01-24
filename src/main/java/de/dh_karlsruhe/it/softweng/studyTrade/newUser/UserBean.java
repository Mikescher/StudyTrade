/**
 * 
 */
package de.dh_karlsruhe.it.softweng.studyTrade.newUser;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String user_id;
    private String user_name;
    private String user_lastname;
    private String user_forename;
    private String user_city;
    private String user_mail;
    private String user_password;
    private int user_school;
    private int user_studydirection;
    private Date user_logindate;

    public UserBean() {
		// TODO Auto-generated constructor stub
	}

	
	public UserBean(String user_id, String user_name, String user_lastname,
			String user_forename, String user_city, String user_mail,
			String user_password, int user_school, int user_studydirection,
			Date user_logindate) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.user_forename = user_forename;
		this.user_city = user_city;
		this.user_mail = user_mail;
		this.user_password = user_password;
		this.user_school = user_school;
		this.user_studydirection = user_studydirection;
		this.user_logindate = user_logindate;
	}

	/**
	 * @return the user_id
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_name
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the user_lastname
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_lastname() {
		return user_lastname;
	}

	/**
	 * @param user_lastname the user_lastname to set
	 */
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	/**
	 * @return the user_forename
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_forename() {
		return user_forename;
	}

	/**
	 * @param user_forename the user_forename to set
	 */
	public void setUser_forename(String user_forename) {
		this.user_forename = user_forename;
	}

	/**
	 * @return the user_city
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_city() {
		return user_city;
	}

	/**
	 * @param user_city the user_city to set
	 */
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	/**
	 * @return the user_mail
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_mail() {
		return user_mail;
	}

	/**
	 * @param user_mail the user_mail to set
	 */
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	/**
	 * @return the user_password
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_password() {
		return user_password;
	}

	/**
	 * @param user_password the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * @return the user_school
	 */
	@NotNull(message ="Feld leer")
	public int getUser_school() {
		return user_school;
	}

	/**
	 * @param user_school the user_school to set
	 */
	public void setUser_school(int user_school) {
		this.user_school = user_school;
	}

	/**
	 * @return the user_studydirection
	 */
	@NotNull(message ="Feld leer")
	public int getUser_studydirection() {
		return user_studydirection;
	}

	/**
	 * @param user_studydirection the user_studydirection to set
	 */
	public void setUser_studydirection(int user_studydirection) {
		this.user_studydirection = user_studydirection;
	}

	/**
	 * @return the user_logindate
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public Date getUser_logindate() {
		return user_logindate;
	}

	/**
	 * @param user_logindate the user_logindate to set
	 */
	public void setUser_logindate(Date user_logindate) {
		this.user_logindate = user_logindate;
	}

}
