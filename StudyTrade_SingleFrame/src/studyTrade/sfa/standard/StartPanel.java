package studyTrade.sfa.standard;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class StartPanel extends Panel {

	private final Startpage main;

	public StartPanel(Startpage startpage) {
		this.main = startpage;
		Label label = new Label("StartPanel");
		VerticalLayout layout = new VerticalLayout();
		Label label_login = new Label("Login");
		final TextField tf_username = new TextField("Benutzername");
		final PasswordField tf_password = new PasswordField("Passwort");
		Button button_login = new Button("Login");
		Button button_register = new Button("Registrierung");
		layout.addComponent(label);
		layout.addComponent(label_login);
		layout.addComponent(tf_username);
		layout.addComponent(tf_password);
		layout.addComponent(button_login);
		layout.addComponent(button_register);
		setContent(layout);

		/* Click-Actions !! */
		button_login.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Login(tf_username.getValue(), tf_password.getValue());
			}
		});

		button_register.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				main.doRegister();

			}
		});

	}

	private void Login(String username, String password) {
		UserManagement dologin = new UserManagement();
		if (dologin.LogMeIn(username, password)) {
			main.loginOk();
		} else {
			main.loginFalse();
		}
	}
}
