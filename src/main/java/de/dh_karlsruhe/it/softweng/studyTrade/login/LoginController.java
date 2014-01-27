package de.dh_karlsruhe.it.softweng.studyTrade.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("login")
@SessionAttributes("loginBean")
public class LoginController {

	@ModelAttribute("loginBean")
	public LoginBean createFormBean() {
		return new LoginBean();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String displayForm() {
		return "login";
	}

	/*@RequestMapping(method = RequestMethod.POST)
	public String getLoginView(ModelMap model, @Valid LoginBean bean, BindingResult br) throws IOException {
		if (br.hasErrors() || ! bean.isInDB()) {
			StringBuilder errBuilder = new StringBuilder();
			for (ObjectError err : br.getAllErrors()) {
				errBuilder.append(err.getDefaultMessage() + "<br \\>");
			}
			if (! bean.isInDB()) {
				errBuilder.append("Benutzername oder Passwort sind falsch" + "<br \\>");
			}
			errBuilder.substring(0, errBuilder.length() - 6); // REM last <br \>
			model.addAttribute("infomsg", errBuilder.toString());
			return "login";
		} else {
			model.addAttribute("loginname", bean.getUsername());
			return "login_succ";
		}

	}*/
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String gotoLogin(Model model) throws Exception{
	return "login";
		
	}
}
