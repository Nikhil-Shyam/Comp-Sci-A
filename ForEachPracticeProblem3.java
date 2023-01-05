import java.util.Scanner;

public class ForEachPracticeProblem3
{
	static Scanner reader = new Scanner(System.in);

	public ForEachPracticeProblem3(){
		String[] items = new String[10];

		System.out.println("Enter 10 item you need at the store: ");
		for (int i = 0; i < items.length; i++)
			items[i] = reader.nextLine();
		System.out.println();
		for (String item: items)
			System.out.print(item.toUpperCase() + " ");
	}

	public static void main(String[] args){
		ForEachPracticeProblem3 app = new ForEachPracticeProblem3();
	}
}