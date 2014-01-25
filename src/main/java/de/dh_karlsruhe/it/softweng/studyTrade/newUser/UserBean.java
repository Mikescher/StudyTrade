/**
 * 
 */
package de.dh_karlsruhe.it.softweng.studyTrade.newUser;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserBean implements Serializable{


	private static final long serialVersionUID = 1L;

	private String user_nickname;
	private String user_lastname;
	private String user_forename;
	private String user_city;
	private String user_mail;
	private String user_password;
	private int user_school;
	private int user_studydirection;

	private Connection con = null;
	PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public UserBean( String user_nickname, String user_lastname,
			String user_forename, String user_city, String user_mail,
			String user_password, int user_school, int user_studydirection) {
		super();

		this.user_nickname = user_nickname;
		this.user_lastname = user_lastname;
		this.user_forename = user_forename;
		this.user_city = user_city;
		this.user_mail = user_mail;
		this.user_password = user_password;
		this.user_school = user_school;
		this.user_studydirection = user_studydirection;

	}

	/**
	 * @return the user_nickname
	 */
	@NotNull
	@NotEmpty(message ="Feld leer")
	public String getUser_nickname() {
		return user_nickname;
	}

	/**
	 * @param user_nickname the user_nickname to set
	 */
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
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
	@NotNull(message ="Schule")
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
	@NotNull(message ="Studienrichtung")
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

	public boolean UserAlreadyInDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			/*Der User muss natürlich in der DB angelegt werden
			 * und mit den nötigen Rechten ausgestattet werden */
			String user = "server";
			String serv_password = "passwort";

			/*Verbindungsaufbau zur DB, bei mir heißt sie project_one*/
			con = DriverManager.getConnection("jdbc:mysql://localhost/project_one", user, serv_password);

			/*SQL Statement erstellen ...*/
			st = con.createStatement();
			/*TODO spezialisierte Rückmeldungen ausgeben !!*/
			String query = "Select count(*) AS CNT from new_users where ( user_forename='"+user_forename+"' and user_lastname='"+user_lastname + 
					"' ) or user_mail='" + user_mail +
					"' or user_nickname= '" + user_nickname +"'";
			/*... und ausführen*/
			rs = st.executeQuery(query);
			int CNT = 0;

			/*SQL liefert EINEN Wert (CNT) zurück der auf jeden Fall true ist. */
			if(rs.next()){
				CNT = rs.getInt("CNT");
			}
			if(CNT == 0){
				System.out.println("User ist bereits in der DB vorhanden ");
				return true;
			}
			return false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean UserToDB(){
		try {

			Class.forName("com.mysql.jdbc.Driver");
			/*Der User muss natürlich in der DB angelegt werden
			 * und mit den nötigen Rechten ausgestattet werden */
			String user = "server";
			String serv_password = "passwort";
			/*TODO Login-Daten auslagern*/

			Calendar cal = Calendar.getInstance();  
			java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());

			/*Verbindungsaufbau zur DB, bei mir heißt sie project_one*/
			con = DriverManager.getConnection("jdbc:mysql://localhost/project_one", user, serv_password);
			String query = "INSERT INTO new_users VALUES (default,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(query);

			pst.setString(1, user_nickname);
			pst.setString(2, user_lastname);
			pst.setString(3, user_forename);
			pst.setString(4, user_city);
			pst.setString(5, user_mail);
			pst.setString(6, user_password);
			pst.setLong(7, user_school);
			pst.setLong(8, user_studydirection);
			pst.setTimestamp(9, timestamp);
			pst.executeUpdate();
			con.close();

			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
}
