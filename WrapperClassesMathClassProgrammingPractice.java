import java.util.Scanner;

public class WrapperClassesMathClassProgrammingPractice
{
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){
		WrapperClassesMathClassProgrammingPractice app = new WrapperClassesMathClassProgrammingPractice();
	}

	public WrapperClassesMathClassProgrammingPractice(){
		System.out.println(problemOne() + "\n"); //Problem 1
		System.out.println(problemTwo() + "\n"); //Problem 2
		System.out.println(problemThree() + "\n"); //Problem 3
		System.out.println(problemFour() + "\n"); //Problem 4
		System.out.println(problemFive() + "\n"); //Problem 5
		System.out.println(problemSix() + "\n"); //Problem 6
	}

	public static Integer problemOne(){ //Problem 1
		System.out.print("Problem 1\nRandom Integer: ");
		return (int)(Math.random()*8)+56;
	}

	public static Integer problemTwo(){ //Problem 2
		Integer i = (int)(Math.random()*963)+45;
		System.out.print("Problem 2\nRandom Integer: " + i + "\nSquare Integer: ");
		return (int)(Math.pow(i, 2));
	}

	public static Double problemThree(){ //Problem 3
		Integer i = (int)(Math.random()*119)+632;
		System.out.print("Problem 3\nRandom Integer: " + i + "\nSquare Root: ");
		return Math.sqrt(i);
	}

	public static Double problemFour(){ //Problem 4
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

	public static Integer problemFive(){ //Problem 5
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

	public static Integer problemSix(){ //Problem 6
		Integer min = 0;
		Integer max = 0;
		Integer count = -1;

		System.out.print("Problem 6\nEnter 2 Positive Numbers: ");
		String num = reader.nextLine();
		for (int i = 0; i < num.length(); i++){
			if (num.substring(i,i+1).equals(" "))
				count = i;
		}
		Integer s1 = Integer.parseInt(num.substring(0, count));
		Integer s2 = Integer.parseInt(num.substring(count+1));

		while (s1 < 0 || s2 < 0){
			System.out.print("Please Reenter 2 Positive Numbers: ");
			num = reader.nextLine();
			for (int i = 0; i < num.length(); i++){
				if (num.substring(i,i+1).equals(" "))
					count = i;
			}
			s1 = Integer.parseInt(num.substring(0, count));
			s2 = Integer.parseInt(num.substring(count+1));
		}

		if (s1 < s2){
				min = s1;
				max = s2;
			}else{
				min = s2;
				max = s1;
			}

		Integer diffI = Math.abs(s2-s1)+1;
		Integer ran = (int)(Math.random()*diffI)+min;

		System.out.print("Random Integer Between " + min + " and " + max + ": ");
		return ran;
	}
}
