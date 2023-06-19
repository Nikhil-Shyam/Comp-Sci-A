import java.util.Scanner;

public class WrapperClassesMathClassProgrammingPractice
{
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){
		WrapperClassesMathClassProgrammingPractice app = new WrapperClassesMathClassProgrammingPractice();
	}

	public WrapperClassesMathClassProgrammingPractice(){
		//System.out.println(problemOne() + "\n"); //Problem 1
		//System.out.println(problemTwo() + "\n"); //Problem 2
		//System.out.println(problemThree() + "\n"); //Problem 3
		//System.out.println(problemFour() + "\n"); //Problem 4
		//System.out.println(problemFive() + "\n"); //Problem 5
		System.out.println(problemSix() + "\n"); //Problem 6
	}

	public static Integer problemOne(){
		System.out.print("Problem 1\nRandom Integer: ");
		return (int)(Math.random()*8)+56;
	}

	public static Integer problemTwo(){
		Integer i = (int)(Math.random()*963)+45;
		System.out.print("Problem 2\nRandom Integer: " + i + "\nSquare Integer: ");
		return (int)(Math.pow(i, 2));
	}

	public static Double problemThree(){
		Integer i = (int)(Math.random()*119)+632;
		System.out.print("Problem 3\nRandom Integer: " + i + "\nSquare Root: ");
		return Math.sqrt(i);
	}

	public static Double problemFour(){
		Integer x = 0;
		System.out.print("Problem 4\nRandom Integers: ");
		for (int i = 0; i < 10; i++){
			Integer j = (int)(Math.random()*68)+6;
			System.out.print(j + " ");
			x += j;
		}
		System.out.print("\nAverage: ");
		return x/10.0;
	}

	public static Integer problemFive(){
		Integer min = Integer.MAX_VALUE;
		System.out.print("Problem 5\nRandom Integers: ");
		for (int i = 0; i < 20; i++){
			Integer j = (int)(Math.random()*86)+85;
			System.out.print(j + " ");
			if (j < min)
				min = j;
		}
		System.out.print("\nSmallest Value: ");
		return min;
	}

	public static Double problemSix(){
		Double min = 0.0;
		Double max = 0.0;
		System.out.print("Problem 5\nEnter 2 Positive Numbers: ");
		Double[] x = new Double[2];
		for (int i = 0; i < 2; i++){
			x[i] = reader.nextDouble();
		}
		while (x[0] < 0 || x[1] < 0){
			System.out.print("Please Reenter 2 Positive Numbers: ");
			for (int i = 0; i < 2; i++){
				x[i] = reader.nextDouble();
			}
		}
		System.out.print("Do you want to return a Double or Integer? ");
		//put stuff here
		Double diff = Math.abs(x[0]-x[1]);
		if (x[0] < x[1]){
			min = x[0];
			max = x[1];
		}else{
			min = x[1];
			max = x[0];
		}
		double ran = min + diff * Math.random();
		System.out.print("Random Double Between " + min + " and " + max + ": ");
		return ran;
	}
}