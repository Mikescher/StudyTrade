/**
 * 
 */
package de.dh_karlsruhe.it.softweng.studyTrade.articles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class ArticleBean implements Serializable {

	private static final long serialVersionUID = 1L;
	/*Artikeleigenschaften*/
	private String article_name;
	private int article_category;
	private float article_price;
	private int article_user_id;
	private String article_city;
	private String article_description;
	private String article_condition;
	private String article_contact;
	private List<String> testlist;
	public ArticleBean() {
	}

	public ArticleBean(String article_name, int article_category,
			float article_price, int article_user_id, String article_city,
			String article_description, String article_condition, String article_contact ) {
		super();
		this.article_name = article_name;
		this.article_category = article_category;
		this.article_price = article_price;
		this.article_user_id = article_user_id;
		this.article_city = article_city;
		this.article_description = article_description;
		this.article_condition = article_condition;
		this.article_contact = article_contact;
	}

	/**
	 * @return the article_name
	 */
	@NotNull 
	@NotEmpty(message ="Bitte geben sie einen Artikelnamen an.")
	public String getArticle_name() {
		return article_name;
	}

	/**
	 * @param article_name the article_name to set
	 */
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}

	/**
	 * @return the article_category
	 */

	@NotNull(message ="Bitte wählen sie eine Kategorie für ihr Angebot.")
	public int getArticle_category() {
		return article_category;
	}

	/**
	 * @param article_category the article_category to set
	 */
	public void setArticle_category(int article_category) {
		this.article_category = article_category;
	}

	/**
	 * @return the article_price
	 */
	/*Validation @Min(x) didn't work !! */
	@NotNull(message ="Bitte geben sie einen Preis ein")
	public float getArticle_price() {
		return article_price;
	}

	/**
	 * @param article_price the article_price to set
	 */
	public void setArticle_price(float article_price) {
		this.article_price = article_price;
	}

	/**
	 * @return the article_user_id
	 */
	@NotNull(message="Bitte geben sie einen Preis an.")
	public int getArticle_user_id() {
		return article_user_id;
	}

	/**
	 * @param article_user_id the article_user_id to set
	 */
	public void setArticle_user_id(int article_user_id) {
		this.article_user_id = article_user_id;
	}

	/**
	 * @return the article_city
	 */
	@NotNull
	@NotEmpty(message ="Bitte geben sie einen Ort an.")
	public String getArticle_city() {
		return article_city;
	}

	/**
	 * @param article_city the article_city to set
	 */
	public void setArticle_city(String article_city) {
		this.article_city = article_city;
	}

	/**
	 * @return the article_description
	 */
	@NotNull
	@NotEmpty(message ="Das Feld Artikelbeschreibung ist leer.")
	public String getArticle_description() {
		return article_description;
	}

	/**
	 * @param article_description the article_description to set
	 */

	public void setArticle_description(String article_description) {
		this.article_description = article_description;
	}

	/**
	 * @return the article_condition
	 */
	@NotNull
	@NotEmpty(message ="Bitte geben sie den Zustand an.")
	public String getArticle_condition() {
		return article_condition;
	}

	/**
	 * @param article_condition the article_condition to set
	 */
	public void setArticle_condition(String article_condition) {
		this.article_condition = article_condition;
	}

	/**
	 * @return the article_contact
	 */
	@NotNull
	@NotEmpty(message ="Das Feld Kontakt ist leer.")
	public String getarticle_contact() {
		return article_contact;
	}

	/**
	 * @param article_contact the article_contact to set
	 */
	public void setarticle_contact(String article_contact) {
		this.article_contact = article_contact;
	}

	public boolean searchArticlesInDB(){
		return true;
	}

	public List<String> getTestlist() {
		testlist = new ArrayList<String>();
		testlist.add("test");
		testlist.add("bla");
		testlist.add("blubber");
		
		return testlist;
	}

	public void setTestlist(List<String> testlist) {
		this.testlist = testlist;
	}
}
