import java.util.ArrayList;

public class AnimalDriver
{
	public AnimalDriver(){
		ArrayList<Animal> petShop = new ArrayList<Animal>();
		petShop.add(new Animal());
		petShop.add(new Dog());
		petShop.add(new Dog("Frankie", "bark"));
		petShop.add(new Cat());
		petShop.add(new Cat("DAWG", "HISS")); //index 4
		petShop.add(new Pig("Morris", "hi"));
		System.out.println(petShop);

		System.out.println(((Cat)petShop.get(4)).attackMove());
		System.out.println(((Pig)petShop.get(5)).attackMove());

		if (petShop.get(1) instanceof Dog)
			System.out.println("Youre a dog");
	}

	public static void main(String[] args){
		AnimalDriver app = new AnimalDriver();
	}
}