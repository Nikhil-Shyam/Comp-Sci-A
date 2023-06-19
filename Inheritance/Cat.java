public class Cat extends Animal
{
	public Cat(){
		super("cat", "meow"); //explicit call to the super constructor
	}
	
	public Cat(String name, String noise){
		super(name, noise); //this should always be the first line of your constructor, any other code goes after
	}
	
	public String attackMove(){
		return "SCRATCH!!!";
	}
}