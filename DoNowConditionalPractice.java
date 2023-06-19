import java.util.Scanner;

public class DoNowConditionalPractice
{
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){
		DoNowConditionalPractice app = new DoNowConditionalPractice();
	}

	public DoNowConditionalPractice(){
		System.out.println(problemOne()); //problem 1
		problemTwo(); //problem 2
	}

	public static double problemOne(){
		double[] inp = new double [5];
		double sum = 0;

		System.out.print("Enter 5 numbers: ");
		for (int i = 0; i < 5; i++){
			inp[i] = reader.nextDouble();
			sum += inp[i];
		}
		return sum/5.0;
	}

	public static void problemTwo(){
		System.out.print("Enter a number: ");
		int inp = reader.nextInt();

		System.out.println("Divisible by 2: " + div(inp, 2));
		System.out.println("Divisible by 3: " + div(inp, 3));
		System.out.println("Divisible by 5: " + div(inp, 5));
		System.out.println("Divisible by 7: " + div(inp, 7));
		System.out.println("Divisible by 11: " + div(inp, 11));
	}

	public static boolean div(int inp, int x){
		return inp%x==0;
	}
}