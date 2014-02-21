package studyTrade.sfa.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

	public List<String> connect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/project_one",
					"server", "passwort");
			stmt = con.createStatement();
			String query = "select * from user_table;";
			rs = stmt.executeQuery(query);
			List<String> list = new ArrayList<String>();
		
while(rs.next()){
	int id = rs.getInt(1);
	String username = rs.getString(2);
	String password = rs.getString(3);
	String result = id + " " + username + " " + password;
	list.add(result);
}
for( int i = 0; i < list.size(); i++)
{
    System.out.println(list.get(i));
}


			if(!con.isClosed())
				System.out.println("Successfully connected to " +
						"MySQL server using TCP/IP...");
			return list;

		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			try {
				if(con != null)
					con.close();
			} catch(SQLException e) {}
		}
		return null;
	}
}