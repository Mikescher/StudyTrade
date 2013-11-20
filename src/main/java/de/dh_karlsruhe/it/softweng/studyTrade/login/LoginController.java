package de.dh_karlsruhe.it.softweng.studyTrade.login;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public String getLoginView(@Valid LoginBean bean, BindingResult br) {
		if (br.hasErrors()) {
			return "login";
		} else {
			return "afterlogin";
		}
		
	}
}
