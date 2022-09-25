package p1;
import java.io.Serializable;


public abstract class Person implements Serializable {
	private Name name;
	private String id;
	private static int idCount = 0;
	
	public Person(Name name) {
		this.name = name;
		id = String.valueOf(idCount);
		idCount++;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	public Person(Name name, String id) {
		this.name=name;
		this.id=id;
	}

}
