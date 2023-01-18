import java.util.ArrayList;

public class ArrayListsTraversalAlgorithmsPractice
{
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayListsTraversalAlgorithmsPractice(){
		for (int i = 0; i < 50; i++)
			list.add((int)(Math.random()*100)+1);

		System.out.println(list + "\n");
		task1();
		task2();
		task3();
		System.out.println("The array list contains the number 27: " + task4());
		System.out.println("All numbers in the array list are greater than 10: " + task5());
		System.out.println(); task6();
		System.out.println(); task7();
		System.out.println(); task8();
	}

	//the minimum and maximum value
	public void task1(){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) < min)
				min = list.get(i);
			if (list.get(i) > max)
				max = list.get(i);
		}
		System.out.println("Max: " + max + "\nMin: " + min);
	}

	//the sum, average, and mode
	public void task2(){
		int sum = 0;
		double avg;
		int mode = 0;
		int highCount = 0;
		for (int i = 0; i < list.size(); i++){
			int count = 0;
			sum += list.get(i);
			for (int j = i+1; j < list.size(); j++){
				if (list.get(i) == list.get(j))
					count++;
			}
			if (count > highCount){
				highCount = count;
				mode = list.get(i);
			}
		}
		avg = sum / (double) list.size();
		if (highCount == 0)
			System.out.println("Sum: " + sum + "\nAverage: " + avg + "\nMode: N/A");
		else
			System.out.println("Sum: " + sum + "\nAverage: " + avg + "\nMode: " + mode);
	}

	//how many times a randomly generated number (between 1-100) appears in the array.
	public void task3(){
		int ran = (int)(Math.random()*100)+1;
		int count = 0;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) == ran)
				count++;
		}
		System.out.println("The number " + ran + " appears " + count + " times in the array list");
	}

	//determine if at least one number is equal to 27
	public boolean task4(){
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) == 27)
				return true;
		}
		return false;
	}

	//determine whether all numbers are greater than 10
	public boolean task5(){
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) <= 10)
				return false;
		}
		return true;
	}

	//shift all numbers up 3 index values
	public void task6(){
		for (int i = 0; i < 3; i++){
			int permTemp = list.get(list.size()-4);
			int temp = list.get(list.size()-1);
			for (int j = list.size()-4; j > 0; j--){
				list.set(j, list.get(j-1));
			}
			list.remove(list.size()-1);
			list.remove(0);
			list.add(0, temp);
			list.add(list.size()-2, permTemp);
		}
		System.out.println(list);
	}

	//shift all numbers down 5 index values
	public void task7(){
		for (int i = 0; i < 5; i++){
			for (int j = 5; j < list.size(); j++){
				list.set(j-1, list.get(j));
			}
		}
		System.out.println(list);
	}

	//reverse all the elements stored in the ArrayList
	public void task8(){
		for (int i = 0; i < list.size()/2; i++){
			int temp = list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1, temp);
		}
		System.out.println(list);
	}

	public static void main(String[] args){
		ArrayListsTraversalAlgorithmsPractice app = new ArrayListsTraversalAlgorithmsPractice();
	}
}