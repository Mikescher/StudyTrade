/**
 * 
 */
package de.dh_karlsruhe.it.softweng.studyTrade.searching;

import java.io.Serializable;
import java.util.ArrayList;
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
		searchString = searchString.replaceAll("[^a-zA-ZäÄöÖüÜß0-9\\-\\,]", " ");
		/*In der Sucheingabe werden nur Buchstaben, Zahlen, Umlaute und Bindestrich erlaubt */
		System.out.println("Sonderzeichen gelöscht: "+searchString);

		StringTokenizer tk = new StringTokenizer( searchString );
		ArrayList<String> arrayList = new ArrayList<String>();
		int i = 0;
		
		while ( tk.hasMoreTokens()){
			String x = tk.nextToken();
			int m = x.length();

			if (m < 3) {
				/* Wenn ein Wort kÃ¼rzer als 3 Zeichen ist, wird es mit 
				 * dem vorherigen Wort zusammen als String gespeichert
				 * z.B. Eingabe = "iPhone 4 black" wid gespeichert
				 * String1 = "iPhone 4", String2 = "black"   */
				if(i==0){
					arrayList.add(i,x);
					i++;
				}else {
					i--;
					String t = arrayList.get(i);
					String s = t + " " + x;
					arrayList.set(i,s);
					i++;
				}
			} else {
				arrayList.add(i,x);
				i++;
			}
				
			
		}
		/*Testweise Ausgabe der Strings in der Konsole*/
		System.out.println("Ausgabe Liste: ");
		for(String elem : arrayList){
			System.out.println(elem);
			System.out.println(elem.length());
			
			
		}
		
		analyseString(arrayList);
		return true;
	}
	public void analyseString(ArrayList<String> ac){
		
		for(String elem : ac){
			if(elem.matches("[schwarz|weis|grün|blau|rot|gelb]+")){
				/*Liste von Farben ?*/
				System.out.println(elem +" Eingabe ist eine Farbe");
			}
			else if(elem.matches("[a-zA-ZäÄöÖüÜß]+")){
				System.out.println(elem +" Eingabe besteht nur aus Buchstaben");
			}
			else if(elem.matches("[0-9]+,[0-9]+")){
				System.out.println(elem + " Eingabe ist ein Preis");
			}
			
			else if(elem.matches("[,]+[0-9a-zA-ZäÄöÖüÜß]+")){;
				/*Erstes Zeichen löschen ? Was wäre bei ::ABCD ? */
				System.out.println(elem + "Tippfehler");
			}
			else if(elem.matches("[0-9]*")){
				if(elem.length()==5){
					System.out.println(elem + " Eingabe ist eine Postleitzahl");
				}else{
				System.out.println(elem + " Eingabe besteht nur aus Zahlen");
			}
				}
			else if(elem.matches("[a-zA-ZäÄöÖüÜß]+[0-9|a-zA-Z]+")){;
			/*Erstes Zeichen lÃ¶schen ? Was wÃ¤re bei ::ABCD ?*/
			System.out.println(elem + " ist eine Artikelbezeichnung");
			}	
			else{
				System.out.println(elem + "sonstige Eingabe, wird noch nicht abgefangen");
			}
		}
	}
	
		
	}


