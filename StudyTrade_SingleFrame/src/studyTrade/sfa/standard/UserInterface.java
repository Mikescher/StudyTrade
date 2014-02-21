package studyTrade.sfa.standard;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class UserInterface extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Startpage main;

	public UserInterface(Startpage startpage) {
		VerticalLayout layout = new VerticalLayout();
		Button bt_back = new Button("zur�ck zum Start");
		this.main = startpage;
		Label label = new Label("userinterface");
		layout.addComponent(label);
		layout.addComponent(bt_back);
		setContent(layout);

		bt_back.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				main.loginOk();

			}
		});
	}

}
