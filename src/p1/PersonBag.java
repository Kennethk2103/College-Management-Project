package p1;

import java.io.Serializable;

public class PersonBag implements Serializable {
	private Person[] arr;
	private int nElms;
	public PersonBag(int maxSize) {
		arr=new Person[maxSize];
		nElms=0;
	}
	
	public void insert(Person person) {
		arr[nElms++]=person;
	}
	public void display() {
//		String output="";
		for(int i =0; i<nElms;i++) {
			System.out.println(arr[i]);
//			output+=arr[i]+ "\n";
		}
		
	}
	public Person searchById(String id) {
		for(int i =0;i<nElms;i++) {
			if(arr[i].getId().equals(id)) {
				return arr[i];
			}
		}
		System.out.println("No id found");
		return null;
	}
	public Person[] update(Person person) {
		
		for(int i=0;i<nElms;i++) {
			if(arr[i].getId().equals(person.getId())) {
				arr[i]=person;
			}
		}
		return arr;
	}
	
	public Person[] deleteById(String id) {
		int i=0;
		for(i =0; i<nElms;i++) {
			if(arr[i].getId().equals(id)) {
				break;
			}
		}
		if(i!=nElms) {
			for(int j=i;j<nElms--;j++) {
				arr[j]=arr[j+1];
			}
			nElms--;
			return arr;
			
		}
		else {
			System.out.println("No such id found");
			return null;
		}
	
	}
	




	
	
	
}



