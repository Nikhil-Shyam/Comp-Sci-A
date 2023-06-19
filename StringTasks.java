import java.util.Scanner;

public class StringTasks
{
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){
		StringTasks app = new StringTasks();
	}

	public StringTasks(){
		String str1 = "I love Computer Science!";
		System.out.println(str1.substring(0,1));
		System.out.println(str1.substring(str1.length()-1,str1.length()));
		System.out.println(str1.toLowerCase() + "\n");

		System.out.print("Enter a word: ");
		String inp = reader.nextLine();
		System.out.println(inp.substring(1,inp.length()) + inp.substring(0,1) + "ay");
	}
}