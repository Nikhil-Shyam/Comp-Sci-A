public class AnimalRunner
{
	public static void main(String[] args){
		Animal a1 = new Animal("Rudo", 2, 66.8, "dog");
		Animal a2 = new Animal();

		System.out.println(a1);
		System.out.println(a2);

		a2.setName("Cookie");
		a2.setAge(7);
		a2.setWeigth(74.3);
		a2.setType("dog");

		System.out.println(a2);
		System.out.println(a2.getName());
	}
}