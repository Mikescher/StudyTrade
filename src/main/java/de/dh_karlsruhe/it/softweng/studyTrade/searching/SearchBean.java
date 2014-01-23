/**
 * 
 */
package de.dh_karlsruhe.it.softweng.studyTrade.searching;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author b25966
 *
 */
public class SearchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String searchString;
	/**
	 * 
	 */
	public SearchBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param searchString
	 */
	public SearchBean(String searchString) {
		super();
		this.searchString = searchString;
	}
	/**
	 * @return the searchString
	 */
	@NotEmpty
	public String getSearchString() {
		return searchString;
	}
	/**
	 * @param searchString the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

}
