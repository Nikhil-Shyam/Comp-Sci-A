import java.util.ArrayList;

public class ArrayListsProgrammingTasks
{
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayListsProgrammingTasks(){
		for (int i = 0; i < 50; i++){
			list.add((int)(Math.random()*100)+1);
		}
		System.out.println(list + "\n");

		Problem1();
		Problem2();
		Problem3();
		Problem4();
		Problem5();
		Problem6();
	}

	public void Problem1(){
		for (int i = list.size()-1; i >= 0; i--){
			if (list.get(i) % 3 == 0)
				list.remove(i);
		}
		System.out.println(list + "\n");
	}

	public void Problem2(){
		int count = 0;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) % 2 == 0)
				count++;
		}
		System.out.println(count + "\n");
	}

	public void Problem3(){
		for(int i = 0; i < list.size()-1; i++){
			if (list.get(i) % 2 != 0)
				list.set(i, list.get(i+1));
		}
		System.out.println(list + "\n");
	}

	public void Problem4(){
		if (list.size() % 2 != 0){
			for (int i = 0; i < 5; i++){
				list.add(i, (int)(Math.random()*100)+101);
			}
		}
		System.out.println(list + "\n");
	}

	public void Problem5(){
		if (list.size() % 2 == 0){
			for (int i = 0; i <10; i++){
				int ranI = -1;
				while (ranI % 2 != 0)
					ranI = (int)(Math.random()*list.size());
				list.add(ranI, (int)(Math.random()*100)+101);
			}
		}
		System.out.println(list + "\n");
	}

	public void Problem6(){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) > max)
				max = list.get(i);
		}
		System.out.println(max);
	}

	public static void main(String[] args){
		ArrayListsProgrammingTasks app = new ArrayListsProgrammingTasks();
	}
}