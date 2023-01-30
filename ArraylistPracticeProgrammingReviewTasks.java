import java.util.ArrayList;

public class ArraylistPracticeProgrammingReviewTasks
{
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private double mean;

	public ArraylistPracticeProgrammingReviewTasks(){
		task2();
		task3();
		task4();
		task5();
		task6();
		task7();
		task8();
		task9();
		task10();
		task11();
		task12();
		task13();
	}

	public void task2(){
		for (int i = 0; i < 40; i++)
			list.add((int)(Math.random()*100)+1);
		System.out.println(list);
	}

	public void task3(){
		list.set(0, list.remove(list.size()-1));
		System.out.println(list);
	}

	public void task4(){
		for (int i = list.size()-1; i >= 0; i--){
			if(list.get(i) % 2 == 0)
				list.remove(i);
		}
		System.out.println(list);
	}

	public void task5(){
		for (int i = list.size()-1; i >= 0; i--){
			if (i % 2 == 1)
				list.remove(i);
		}
		System.out.println(list);
	}

	public void task6(){
		for (int i = 0; i < list.size(); i+=2)
			list.set(i, list.get(i)*1000);
		System.out.println(list);
	}

	public void task7(){
		for (int i = 1; i < list.size(); i+=2)
			list.set(i, list.get(i)%10);
		System.out.println(list);
	}

	public void task8(){
		for (int i = list.size()-1; i >= 0; i--){
			if(list.get(i) % 2 == 0)
				list.add(list.get(i));
		}
		System.out.println(list);
	}

	public void task9(){
		for (int i = list.size()-1; i >= 0; i--){
			if (list.get(i)%2 == 0){
				list.add(0, list.remove(i));
			}
		}
		System.out.println(list);
	}

	public void task10(){
		for (int i = list.size()-1; i >= 0; i-=2)
			list.remove(i);
		System.out.println(list);
	}

	public void task11(){
		for (int i = 1; i < list.size(); i+=2){
			int diff = Math.max(list.get(i), list.get(i-1)) - Math.min(list.get(i), list.get(i-1));
			System.out.println("The difference between " + list.get(i-1) + " and " + list.get(i) + " is " + diff);
		}
	}

	public void task12(){
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += list.get(i);
		mean = sum / (double)list.size();
		System.out.println("Mean: " + mean);
	}

	public void task13(){
		double deviationSum = 0;
		for (int i = 0; i < list.size(); i++){
			deviationSum += Math.pow(list.get(i)-mean, 2);
		}
		System.out.println("Standard Deviation: " + Math.sqrt(deviationSum/list.size()));
	}

	public static void main(String[] args){
		ArraylistPracticeProgrammingReviewTasks app = new ArraylistPracticeProgrammingReviewTasks();
	}
}