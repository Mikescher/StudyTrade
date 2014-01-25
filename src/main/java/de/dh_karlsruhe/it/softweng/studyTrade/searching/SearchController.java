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
	public String getSearch(ModelMap model, @Valid SearchBean bean, BindingResult br) {
		if(bean.cutString()){
		return "result";}
		else{
		return "search";}
		}
		
	}


