package p1;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;





public class Utilities {
	private static ArrayList<String> firstNameList;
	private static ArrayList<String> lastNameList;
	private static ArrayList<String> majorList;
	private static ArrayList<String>titleList;
	private static ArrayList<String>isbnList;
	
	
	
	///General Use Utilities
	public static Name emitName() {
		String first = firstNameList.get((int) (Math.random() * firstNameList.size()));
		String last = lastNameList.get((int) (Math.random() * lastNameList.size()));
		Name name = new Name(first,last);
		return name;
	}
	private static ArrayList<String> convertToList(String fileName){
		ArrayList<String> list = new ArrayList<>();
		File file = new File(fileName);
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				list.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	private static ArrayList<String> convertMajorToList(String fileName){
		ArrayList<String> list = new ArrayList<>();
		File file = new File(fileName);
		try {
			Scanner scan = new Scanner(file);
			String line = scan.nextLine();
			String[] temp=line.split(",");
			for(int i=0; i<temp.length;i++) {
				list.add(temp[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void loadLists(String firstNameFile,String lastNameFile,String titleFile,String isbnFile,String majorFileName) {
		firstNameList = convertToList(firstNameFile);
		lastNameList = convertToList(lastNameFile);
		majorList = convertMajorToList(majorFileName);
		titleList = convertToList(titleFile);
		isbnList = convertToList(isbnFile);
		
	}
	
	
	/////////TextBook
	public static void fillTextbookBag(TextbookBag bookBag,int size) {
		for(int i =0 ; i<size;i++) {
			Name name = emitName();
			String title = titleList.get(i);
			String isbn = isbnList.get(i);
			double price = Utilities.emitPrice();
			bookBag.insert(new Textbook(title,name,isbn,price));
		}
		
	}
	
	public static double emitPrice() {
		Double price = Math.random()*200;
		return Math.round(price*100.0)/100.0;
	}
	
	public static void backUpTextBookBag() {
		try {
			FileOutputStream fos = new FileOutputStream("BackupData/TextbookBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(College.getTextbookBag());
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void restoreTextBookBag() {
		File file = new File("BackupData/TextbookBag.dat");
		if(!file.exists()) {
			College.setTextbookBag(new TextbookBag());
		}
		else {
			try {
				FileInputStream fis = new FileInputStream("BackupData/TextbookBag.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				College.setTextbookBag((TextbookBag)ois.readObject()); 
				ois.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	////Students and Instructors
	public static void importStudents(PersonBag theBag) {
		
		for(int i=0;i<1000;i++) {
			Name name = Utilities.emitName();
			String major = Utilities.emitMajor();
			Double gpa = emitGpa();
			theBag.insert(new Student(name,gpa,major));
		}
	}
	public static String emitMajor() {
		return majorList.get((int)(Math.random()*majorList.size()));
	}
	public static double emitGpa() {
		double gpa = Math.random()*4;
		return Math.round(gpa*10.0)/10.0;
	}
	
	public static void importInstructors(PersonBag theBag) {
		String [] ranks = {"Professor","Instructor","Assistant Professor"+ "Associate Professor"};
		for(int i=0;i<500;i++) {
			Name name = Utilities.emitName();
			Double salary = Utilities.emitSalary();
			String rank = ranks[((int) (ranks.length*Math.random()))];
			theBag.insert(new Instructor(name,rank,salary));
		}
	}
	public static double emitSalary() {
		double salary = Math.random()*90000 +10000;
		return Math.round(salary*100.0)/100.0;
	}
	
	
	public static void backUpPersonBag() {
		try {
			FileOutputStream fos = new FileOutputStream("BackupData/Personbag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(College.getPersonBag());
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void restorePersonBag() {
		File file = new File("BackupData/Personbag.dat");
		if(!file.exists()) {
			College.setPersonBag(new PersonBag(2000));
		}
		else {
			try {
				FileInputStream fis = new FileInputStream("BackupData/Personbag.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				PersonBag pBag = (PersonBag) ois.readObject();
				College.setPersonBag(pBag);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}


