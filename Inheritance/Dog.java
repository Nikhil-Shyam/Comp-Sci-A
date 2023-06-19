public class Dog extends Animal
{
	public Dog(){
		super("dog", "woof");
	}

	public Dog (String name, String noise){
		super(name, noise);
	}

	public String attackMove(){
		return "BYTE!";
	}
}