public class Animal
{
	private String animalName;
	private String animalNoise;

	public Animal(){
		animalName = "animalName";
		animalNoise = "animalNoise";
	}

	public Animal(String animalName, String animalNoise){
		this.animalName = animalName;
		this.animalNoise = animalNoise;
	}

	public String getName(){
		return animalName;
	}

	public String speak(){
		return animalNoise;
	}

	public String toString(){
		return animalName + " says " + animalNoise;
	}
}