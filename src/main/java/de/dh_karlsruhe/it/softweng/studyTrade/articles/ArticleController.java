package de.dh_karlsruhe.it.softweng.studyTrade.articles;

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
@RequestMapping("article")
@SessionAttributes("articleBean")
public class ArticleController {

	@ModelAttribute("articleBean")
	public ArticleBean createFormBean() {
		return new ArticleBean();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String displayForm() {
		return "newArticle";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String getNewArticleView(ModelMap model, @Valid ArticleBean bean, BindingResult br) {
		if (br.hasErrors() || ! bean.searchArticlesInDB()) {
			StringBuilder errBuilder = new StringBuilder();
			for (ObjectError err : br.getAllErrors()) {
				errBuilder.append(err.getDefaultMessage() + "<br \\>");
			}
			if (! bean.searchArticlesInDB()) {
				errBuilder.append("Fehler" + "<br \\>");
			}
			errBuilder.substring(0, errBuilder.length() - 6); // REM last <br \>
			model.addAttribute("infomsg", errBuilder.toString());
			return "newArticle";
		} else {
			/*TODO
			 * -> noch irgendeine Validierung der Eingaben ?? 
			 * -> Eintragung in DB
			 * */
			model.addAttribute("infomsg", "Erfolgreich");
			
			return "newArticle";


		}
	}

}
