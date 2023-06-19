public class Sphere extends Solid
{
	private double radius;

	public Sphere(String name, double radius){
		super(name);
		this.radius = radius;
	}

	public double volume(){
		return (4.0/3.0)*Math.PI*radius*radius*radius;
	}

	public double surfaceArea(){
		return 4*Math.PI*radius*radius;
	}
}