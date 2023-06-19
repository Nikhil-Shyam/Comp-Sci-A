public class Animal
{
	private String name;
	private int age;
	private double weight;
	private String type;

	public Animal(String initName, int initAge, double initWeight, String initType){
		name = initName;
		age = initAge;
		weight = initWeight;
		type = initType;
	}

	public Animal(){
		name = "";
		age = -1;
		weight = -1.0;
		type = "";
	}

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public double getWeight(){
		return weight;
	}
	public String getType(){
		return type;
	}

	public void setName(String newName){
		name = newName;
	}
	public void setAge(int newAge){
		age = newAge;
	}
	public void setWeigth(double newWeigth){
		weight = newWeigth;
	}
	public void setType(String newType){
		type = newType;
	}

	public String toString(){
		return "Name: "+name+", Age: "+age+", Weight: "+weight+", Type: "+type;
	}
}