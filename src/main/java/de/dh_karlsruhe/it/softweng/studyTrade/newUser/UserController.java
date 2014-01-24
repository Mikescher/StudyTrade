package de.dh_karlsruhe.it.softweng.studyTrade.newUser;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("newUser")
@SessionAttributes("userBean")
public class UserController {


	@ModelAttribute("userBean")
	public UserBean createFormBean() {
			return new UserBean();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayForm() {
			return "newUser";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getSearch(ModelMap model, @Valid UserBean bean, BindingResult br) {
	return "newUser"; /* TODO Verwendung von register.jsp !!*/
	}
}
