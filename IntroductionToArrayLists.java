import java.util.ArrayList;

public class IntroductionToArrayLists
{
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public IntroductionToArrayLists(){
		Task1();
		Task2();
		Task3();
		Task4();
		Task5();
		Task6();
		Task7();
		Task8();
	}

	public void Task1(){
		for(int i = 0; i < 20; i++){
			list.add((int)(Math.random()*50)+1);
		}
		System.out.println(list + "\n");
	}

	public void Task2(){
		for (int i = list.size()-1; i >= 0; i--){
			if (i % 2 == 0)
				list.remove(i);
		}
		System.out.println(list + "\n");
	}

	public void Task3(){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) > max)
				max = list.get(i);
		}
		for (int i = 0; i < 100; i++){
			list.add(i, (int)(Math.random()*50)+(100+max));
		}
		System.out.println(list + "\n");
	}

	public void Task4(){
		for(int i = list.size()-1; i >= 0; i--){
			if (i % 2 != 0)
				list.remove(i);
		}
		System.out.println(list + "\n");
	}

	public void Task5(){
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) % 2 == 0)
				list.set(i, list.get(i)*list.get(i));
		}
		System.out.println(list + "\n");
	}

	public void Task6(){
		for (int i = list.size()-1; i >= 0; i--){
			if (list.get(i) % 2 == 0){
				list.remove(i);
			}
		}
		System.out.println(list + "\n");
	}

	public void Task7(){
		for (int i = 1; i < list.size(); i+=2){
			list.set(i, list.get(i)-list.size());
		}
		System.out.println(list + "\n");
	}

	public void Task8(){
		for (int i = 0; i < list.size()/2; i++){
			int temp = list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1, temp);
		}
		System.out.println(list);
	}

	public static void main(String[] args){
		IntroductionToArrayLists app = new IntroductionToArrayLists();
	}
}