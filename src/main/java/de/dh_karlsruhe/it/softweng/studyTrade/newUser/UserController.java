package de.dh_karlsruhe.it.softweng.studyTrade.newUser;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("register")
@SessionAttributes("userBean")
public class UserController {


	@ModelAttribute("userBean")
	public UserBean createFormBean() {
			return new UserBean();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayForm() {
			return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getSearch(ModelMap model, @Valid UserBean bean, BindingResult br) {
		if (br.hasErrors() || ! bean.UserAlreadyInDB()) {
			StringBuilder errBuilder = new StringBuilder();
			for (ObjectError err : br.getAllErrors()) {
				errBuilder.append(err.getDefaultMessage() + "<br \\>");
			}
			if (! bean.UserAlreadyInDB()) {
				errBuilder.append("Fehler" + "<br \\>");
			}
			errBuilder.substring(0, errBuilder.length() - 6); // REM last <br \>
			model.addAttribute("infomsg", errBuilder.toString());
			return "register";
		} else {
			/*TODO
			 * -> noch irgendeine Validierung der Eingaben ?? 
			 * -> Eintragung in DB
			 * */
			model.addAttribute("infomsg", "Erfolgreich");
			if(bean.UserToDB()){
			return "register";
			}else{
				System.out.println("Fehler in der DB-Verbindung, siehe LOG !");
				return "register";
			}

		}}
}
