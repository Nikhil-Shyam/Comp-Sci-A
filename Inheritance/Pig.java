public class Pig extends Animal
{
	public Pig(){
		super("pig", "oink");
	}

	public Pig(String name, String noise){
		super(name, noise);
	}

	public String attackMove(){
		return "EAT!!";
	}
}