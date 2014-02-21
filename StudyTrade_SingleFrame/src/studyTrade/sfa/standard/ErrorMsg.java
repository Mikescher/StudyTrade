package studyTrade.sfa.standard;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class ErrorMsg extends Panel {

	/**
	 * s
	 */
	private static final long serialVersionUID = 1L;
	private final Startpage main;

	public ErrorMsg(Startpage startpage) {
		this.main = startpage;
		Label label = new Label("Login fehlgeschlagen !!!");
		setContent(label);
	}

}
