/**
 * 
 */
package de.dh_karlsruhe.it.softweng.studyTrade.searching;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.dh_karlsruhe.it.softweng.studyTrade.login.LoginBean;


/**
 * @author b25966
 *
 */
@Controller
@RequestMapping("search")
@SessionAttributes("searchBean")
public class SearchController {

	@ModelAttribute("searchBean")
	public SearchBean createFormBean() {
			return new SearchBean();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayForm() {
			return "search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getLoginView(ModelMap model, @Valid LoginBean bean, BindingResult br) {
		return "search";
		}
		
	}


