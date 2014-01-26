package de.dh_karlsruhe.it.softweng.studyTrade.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	private String username;
	private String password;
	private Statement st = null;
	private Connection con = null;
	private ResultSet rs = null;
	

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
		/*this.password = doHash(password);*/
		/*Fur den Anfang auf Hashing verzichtet*/
		this.password = password;
	}

	public String doHash(String s) {
		return String.valueOf(s.hashCode()); // Worst Hashing evar ^^ Just 4 Testing
	}


	
	
	
	public boolean isInDB() throws IOException  {
	
			try{ 
			
			/* rudimentäre Datenbankabfrage
			 * im Verzeichnis /eclipse/lib/
			 * muss der jdbc Driver liegen, den findet ihr unter 
			 * http://dev.mysql.com/downloads/connector/j/
			 * und die Datei heißt: mysql-connector-java-5.1.28-bin.jar
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*Der User muss natürlich in der DB angelegt werden
			 * und mit den nötigen Rechten ausgestattet werden */
			String user = "server";
			String serv_password = "passwort";
		  
			/*Verbindungsaufbau zur DB, bei mir heißt sie project_one*/
			con = DriverManager.getConnection("jdbc:mysql://localhost/project_one", user, serv_password);

			/*SQL Statement erstellen ...*/
			st = con.createStatement();
			String query = "Select count(*) AS CNT from new_users where user_nickname ='"+username+"' and user_password='"+password+"'";
			/*... und ausführen*/
			rs = st.executeQuery(query);
			int CNT = 0;

			/*SQL liefert einen Wert (CNT) zurück der auf jeden Fall true ist. */
			if(rs.next()){
				CNT = rs.getInt("CNT");
			}
			if(CNT == 1){
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
}
