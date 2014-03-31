package studyTrade.sfa.standard;


import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
/* test*/
public class UserRegisterPanel extends Panel {
	
	private static final long serialVersionUID = 1L;
	private final Startpage main;

	public UserRegisterPanel(Startpage startpage) {
		this.main = startpage;
		Label label = new Label("Registrierung");
		final Label label_error = new Label("");
		label_error.setVisible(false);
		VerticalLayout layout = new VerticalLayout();

		final TextField tf_forename = new TextField("Vorname");
		final TextField tf_lastname = new TextField("Nachname");
		final TextField tf_nickname = new TextField("Username");
		final TextField tf_city = new TextField("Wohnort");
		final TextField tf_mail = new TextField("E-Mail");
		final TextField tf_studydirection = new TextField("Studienrichtung");

		/*TODO Hier noch der Passwort check*/
		final PasswordField pf_password1 = new PasswordField("Passwort");
		final PasswordField pf_password2 = new PasswordField(
				"Passwort wiederholen");
		

		final ComboBox combo_university = new ComboBox("Hochschule");

		combo_university.setInvalidAllowed(false);
		combo_university.setNullSelectionAllowed(false);
		combo_university.addItem("Hochschule 1");
		combo_university.addItem("Hochschule 2");
		combo_university.addItem("Hochschule 3");
		combo_university.addItem("Hochschule 4");
		combo_university.addItem("Hochschule 5");

		
		/*TODO Checkbox muss noch überprüft werden*/
		CheckBox check_agb = new CheckBox(
				"Ich habe die AGBs gelesen und akzeptiert.");
		Button bt_register = new Button("Registrieren");

		layout.addComponent(label);
		layout.addComponent(tf_forename);
		layout.addComponent(tf_lastname);
		layout.addComponent(tf_nickname);
		layout.addComponent(tf_city);
		layout.addComponent(combo_university);
		layout.addComponent(tf_studydirection);
		layout.addComponent(tf_mail);
		layout.addComponent(pf_password1);
		layout.addComponent(pf_password2);
		layout.addComponent(check_agb);
		layout.addComponent(label_error);
		layout.addComponent(bt_register);

		setContent(layout);

		bt_register.addClickListener(new Button.ClickListener() {

			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				String result = Register(tf_forename.getValue(),
						tf_lastname.getValue(), tf_nickname.getValue(),
						tf_city.getValue(), combo_university.getValue(),
						tf_studydirection.getValue(), tf_mail.getValue(),
						pf_password1.getValue(), pf_password2.getValue());

				if (result.equals("")) {
					main.Registered();
				} else {
					label_error.setValue(result);
					label_error.setVisible(true);
				}

			}
		});

	}

	public static String Register(String forename, String lastname,
			String nickname, String city, Object university,
			String studydirection, String mail, String password1,
			String password2) {
		/*
		 * forename lastname nickname city university studydirection mail
		 * password1 password2
		 */

		/*TODO Sollte man nochmal �berdenken, funktioniert noch nicht so 100% */
		if (forename != "" & lastname != "" & nickname != "" & city != ""
				& university != "" & studydirection != "" & mail != ""
				& password1 != "" & password2 != "") {
			if (mail.matches("[a-zA-Z0-9äÄöÖüÜß-]+@[a-zA-Z0-9äÄöÖüÜß-]+.[a-zA-Z0-9ß-]+"/*
																						 *TODO Filter für trashmail etc.
																						 */)) {
				if (password1.equals(password2)) {
					UserManagement usermanagement = new UserManagement();

					if (usermanagement.RegisterMe(forename, lastname, nickname,
							city, university, studydirection, mail, password1)) {
						return "";
					} else {
						/*TODO Hier müssen IDs statt Strings zurück gegeben werden
						 * und vielleicht kann man eine einzelne Klasse anlegen
						 * aus der NUR strings zurückgegeben werden ?      */
						return "User schon vorhanden";
					}

				} else {
					return "pws stimmen nicht überein";
				}
			} else {
				return "invalid mail";
			}
		} else {
			return "leeres Feld irgendwo";
		}

	}
}

