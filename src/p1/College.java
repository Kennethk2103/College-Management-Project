package p1;

import java.io.Serializable;

public class College implements Serializable{
	private static PersonBag personBag;
	private static TextbookBag textBag;
	private static College college;
	
	private College() {
		personBag = new PersonBag(2000);
		textBag = new TextbookBag();
		this.college=college;
	}
	public static PersonBag getPersonBag() {
		return personBag;
	}
	public static void setPersonBag(PersonBag pBag) {
		College.personBag = pBag;
	}
	public static TextbookBag getTextbookBag() {
		return textBag;
	}
	public static void setTextbookBag(TextbookBag tBag) {
		College.textBag = tBag;
	}
	public static College getCollege() {
		if(college==null) {
			new College();
		}
		return college;
	}
	public static void setCollege(College college) {
		College.college = college;
	}
	
	
	

}
