import java.util.Scanner;

public class StringObjectsProgrammingTasks
{
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){
		StringObjectsProgrammingTasks app = new StringObjectsProgrammingTasks();
	}

	public StringObjectsProgrammingTasks(){
		System.out.println(reverseOrder() + "\n");
		System.out.println(replaceVowels() + "\n");
		System.out.println(extraCredit() + "\n"); //does NOT work if a word in a phrase or a word in general contains only 1 letter
	}

	public static String reverseOrder(){
		System.out.print("Enter a word: ");
		String inp = reader.nextLine();
		String temp = "";

		for (int i = inp.length(); i > 0; i--){
			temp += inp.substring(i-1, i);
		}
		return temp;
	}

	public static String replaceVowels(){
		System.out.print("Enter a word: ");
		String inp = reader.nextLine();
		String temp = "";

		for (int i = 0; i < inp.length(); i++){
			if (inp.substring(i, i+1).equals("a") || inp.substring(i, i+1).equals("e") || inp.substring(i, i+1).equals("i") || inp.substring(i, i+1).equals("o") || inp.substring(i, i+1).equals("u")){
				int ran = (int)(Math.random()*42)+80;
				temp = inp.substring(0, i) + (char)ran + inp.substring(i+1, inp.length());
				inp = inp.substring(0, i) + (char)ran + inp.substring(i+1, inp.length());
				i--;
			}
		}
		if (temp.equals(""))
			return inp;
		return temp;
	}

	public static String extraCredit(){
		System.out.print("Enter a phrase: ");
		String inp = reader.nextLine();
		String temp = "";
		int count = -1;
		boolean space = false;
		inp += " ";

		for (int i = 0; i < inp.length(); i++){
			if (inp.substring(i, i+1).equals(" "))
				space = true;
		}

		if (space){
			for (int i = 0; i < inp.length(); i ++){
				count++;
				if (inp.substring(i, i+1).equals(" ")){
					temp += inp.substring(i-count+1, i-1) + " ";
					inp = inp.substring(i);
					i = 0;
					count = -1;
				}
			}
		}else{
			if (inp.length() == 2)
				temp = inp.substring(1,inp.length()-1) + " ";
			else
				temp = " ";
		}
		return temp;
	}

}