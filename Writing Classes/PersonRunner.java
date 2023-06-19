public class PersonRunner
{
	public static void main(String[] args){
		Person p1 = new Person("Ms. Robles", "Jan. 27", 30);
		System.out.println(p1);

		Person p2 = new Person();
		System.out.println(p2);
		p2.setName("Rishabh");
		p2.setBirth("Jan. 16");
		p2.setAge(15);
		System.out.println(p2);
		// can't retrieve name this way since value is priate in a seperate class
		//System.out.println(p1.name);
		System.out.println(p1.getName());
	}
}