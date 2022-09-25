package p1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.sql.rowset.Predicate;

public class TextbookBag implements Serializable{
	private ArrayList<Textbook> list;
	
	public TextbookBag() {
		list = new ArrayList<>();
	}
	public void insert(Textbook textbook) {
		list.add(textbook);
	}
	public ArrayList<Textbook> getBookList(){
		return list;
	}
	public ArrayList<Textbook> deleteByIsbn(String isbn) {
		int i;
		for(i =0; i<list.size();i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				break;
			}
		}
		if(i!=list.size()) {
			list.remove(i);
			return list;
		}
		else {
			return null;
		}
	
	}
	public Textbook sequentialSearchByIsbn(String isbn) {
		for(int i =0; i<list.size();i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				return list.get(i);
			}
		}
		return null;
	}
	public void update(Textbook book) {
		list.set(list.indexOf(sequentialSearchByIsbn(book.getIsbn())), book);

	}
	
//	public Textbook[] search(Predicate predicate) {
//		Textbook temp[] = new Textbook[list.size()];
//		int count =0;
//		for(int i =0; i<list.size();i++) {
//			if(predicate.test(list.get(i))) {
//				temp[count++]=list.get(i);
//			}
//		}
//		return Arrays.copyOf(temp, count);
//	}
	
	
}