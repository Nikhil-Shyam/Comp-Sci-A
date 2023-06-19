public class Person
{
	// instance variables - attributes or characteristics of my object
	// AP EXAM requires us to use the private modifier for all instance variables
	private String name;
	private String birthday;
	private int age;

	public static int count = 0;

	// constructor - initialize all my instance variables
	/*public Person(String initName, String initBirth, int initAge){
		name = initName;
		birthday = initBirth;
		age = initAge;
	}*/
	public Person(String name, String birth, int age){
		this.name = name;
		this.birthday = birth;
		this.age = age;
		count++;
	}

	// default constructor - initialize instance variables to default values
	public Person(){
		name = "";
		birthday = "";
		age = -1;
		count++;
	}

	// Mutator Methods - Setter Methods that allow us to change/set the values of our instance variables
	// always void method, should have a paratmeter value
	public void setName(String newName){
		name = newName;
	}
	public void setBirth(String newBirth){
		birthday = newBirth;
	}
	public void setAge(int newAge){
		age = newAge;
	}

	// Accessir Methods - or Getters Method to retrieve values from the instance variables
	public String getName(){
		return name;
	}
	public String getBirth(){
		return birthday;
	}
	public int getAge(){
		return age;
	}

	// return formatted Object if objects is called upon as a String
	public String toString(){
		return "Name: " + name + ", Birthday: " + birthday + ", Age: " + age;
	}

	public static void increment(){
		count++;
	}

	public static void main(String[] args){
		System.out.println(Person.count);

		Person p1 = new Person("Ms. Robles", "Jan. 27", 30);
		System.out.println(p1);

		Person p2 = new Person();
		System.out.println(p2);
		p2.setName("Rishabh");
		p2.setBirth("Jan. 16");
		p2.setAge(15);
		System.out.println(p2);

		System.out.println(Person.count);

		System.out.println(p1.name);
	}
}