package studyTrade.sfa.standard;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class MainFramePanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Startpage main;

	public MainFramePanel(Startpage startpage) {
		this.main = startpage;

		VerticalLayout layout = new VerticalLayout();
		Label label = new Label("Mainframe");
		Button button = new Button("User abrufen");

		final Table table = new Table("User in DB");
		table.addContainerProperty("ID", Integer.class, null);
		table.addContainerProperty("Username", String.class, null);
		table.addContainerProperty("Password", String.class, null);

		layout.addComponent(label);
		layout.addComponent(button);
		layout.addComponent(table);
		setContent(layout);

		button.addClickListener(new Button.ClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					ResultSet rs_user = UserFromDB();
					while (rs_user.next()) {
						int id = rs_user.getInt(1);
						String username = rs_user.getString(2);
						String password = rs_user.getString(3);

						Object newItemId = table.addItem();
						Item row1 = table.getItem(newItemId);
						row1.getItemProperty("ID").setValue(id);
						row1.getItemProperty("Username").setValue(username);
						row1.getItemProperty("Password").setValue(password);

						System.out.println(id + username + password);
					}
				} catch (UnsupportedOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	private ResultSet UserFromDB() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/project_one", "server", "passwort");
			stmt = con.createStatement();
			String query = "select * from user_table";
			rs = stmt.executeQuery(query);
			return rs;

		} catch (InstantiationException e) {

			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
