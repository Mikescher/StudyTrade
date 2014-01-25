/**
 * 
 */
package de.dh_karlsruhe.it.softweng.studyTrade.searching;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.validator.constraints.NotEmpty;


public class SearchBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private String searchString;

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

	public boolean cutString(){
		/*splits the search string into individual strings */
		searchString = searchString.replaceAll("[^a-zA-ZöÖäÄüÜß0-9\\-]", " ");
		/*In der Sucheingabe werden nur Buchstaben, Zahlen, Umlaute und Bindestrich erlaubt */
		System.out.println("Sonderzeichen gelöscht: "+searchString);

		StringTokenizer tk = new StringTokenizer( searchString );
		List<String> ac = new ArrayList<String>();
		int i = 0;
		System.out.println("Ausgabe Liste: ");

		while ( tk.hasMoreTokens()){
			String x = tk.nextToken();
			int m = x.length();

			if (m < 3) {
				/* Wenn ein Wort kürzer als 3 Zeichen ist, wird es mit 
				 * dem vorherigen Wort zusammen als String gespeichert
				 * z.B. Eingabe = "iPhone 4 black" wid gespeichert
				 * String1 = "iPhone 4", String2 = "black"   */
				if(i==0){
					ac.add(i,x);
					i++;
				}else {
					i--;
					String t = ac.get(i);
					String s = t + " " + x;
					ac.set(i,s);
					i++;
				}
			} else {
				ac.add(i,x);
				i++;
			}

		}
		/*Testweise Ausgabe der Strings in der Konsole*/
		for(String elem : ac){
			System.out.println(elem);
			System.out.println(elem.length());
		}
		return true;
	}

}
