package studyTrade.sfa.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private final Startpage main;

	@SuppressWarnings("serial")
	public LoginPanel(Startpage startpage) {

		this.main = startpage;

		VerticalLayout layout = new VerticalLayout();
		final TextField tf1 = new TextField("Username");
		final PasswordField tf2 = new PasswordField("Passwort");
		Button button = new Button("test");

		layout.addComponent(tf1);
		layout.addComponent(tf2);
		layout.addComponent(button);
		setContent(layout);
		button.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				doLogin(tf1.getValue(), tf2.getValue());

			}
		});

	}

	protected void doLogin(String username, String password) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/project_one", "server", "passwort");
			stmt = con.createStatement();
			String query = "select count(*) as CNT from user_table where username='"
					+ username + "' and password='" + password + "'";
			rs = stmt.executeQuery(query);
			int CNT = 0;
			while (rs.next()) {
				CNT = rs.getInt(1);
			}

			if (CNT == 1) {
				main.loginOk();
			} else {
				main.loginFalse();
			}

		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
