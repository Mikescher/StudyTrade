package studyTrade.sfa.standard;
/*############################################
 * Datenbank: 
 * Schema: project_one
 * table: new_users
 * sql create :
__________________________________
CREATE TABLE `project_one`.`table_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `forename` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `university` VARCHAR(45) NOT NULL,
  `studydirection` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `activated` INT NOT NULL,
  PRIMARY KEY (`id`));
__________________________________
 * user: server
 * password: password
 * #########################################*/

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("studytrade_singleframe")
public class Startpage extends UI {
	private LoginPanel loginpanel;
	private MainFramePanel mainframepanel;
	private VerticalLayout layout;
	private ErrorMsg error;
	private StartPanel startpanel;
	private UserRegisterPanel userregisterpanel;
	private UserInterface userinterface;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Startpage.class)
	public static class Servlet extends VaadinServlet {
	}

	protected void init(VaadinRequest request) {
		loginpanel = new LoginPanel(this);
		mainframepanel = new MainFramePanel(this);
		error = new ErrorMsg(this);
		startpanel = new StartPanel(this);
		userregisterpanel = new UserRegisterPanel(this);
		userinterface = new UserInterface(this);

		mainframepanel.setVisible(false);
		error.setVisible(false);
		loginpanel.setVisible(false);
		startpanel.setVisible(true);
		userregisterpanel.setVisible(false);
		userinterface.setVisible(true);

		layout = new VerticalLayout();
		layout.addComponent(loginpanel);
		layout.addComponent(mainframepanel);
		layout.addComponent(error);
		layout.addComponent(startpanel);
		layout.addComponent(userregisterpanel);
		this.setContent(layout);
	}

	public void loginOk() {
		try {
			;
			startpanel.setVisible(false);

			mainframepanel.setVisible(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loginFalse() {
		loginpanel.setVisible(false);
		error.setVisible(true);

	}

	public void doRegister() {
		startpanel.setVisible(false);
		userregisterpanel.setVisible(true);
	}

	public void Registered() {
		userregisterpanel.setVisible(false);
		userinterface.setVisible(true);

	}

}