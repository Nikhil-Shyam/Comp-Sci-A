import java.util.Scanner;

public class LoopsPractice
{
	static Scanner reader = new Scanner(System.in);
	static int x;

	public static void main(String[] args){
		LoopsPractice app = new LoopsPractice();
	}

	public LoopsPractice(){
		Program1();
		System.out.println(Program2() + "\n");
		Program3();
	}

	public void Program1(){
		System.out.print("Enter a positive number: ");
		x = reader.nextInt();
		for (int i = 1; i < x; i++)
			System.out.print(i + ", ");
		System.out.println(x + "\n");
	}

	public static String Program2(){
		System.out.print("Enter a positive number: ");
		x = reader.nextInt();
		String y = String.valueOf(x);
		String temp = "";
		for (int i = y.length(); i > 0; i--)
			temp += y.substring(i-1, i);
		return temp;
	}

	public void Program3(){
		System.out.print("Enter a height: ");
		int h = reader.nextInt();
		System.out.println("\ntime\theight");
		x = 0;
		int y = 0;
		while(y >= 0){
			y = h - (16*x*x);
			if (y > 0)
				System.out.println(x +"\t" + y);
			else
				System.out.println(x +"\t0");
			x++;
		}

	}
}