import java.util.ArrayList;
public class ArrayListExamples{

	public static void main(String[]args){
		//Task 1
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i = 0; i < 20; i++){
			list.add((int)(Math.random()*50)+1);
		}
		System.out.println(list);
		//Task 2
		//don't remove starting from 0!
		//for(int i = 0; i < list.size(); i++){
		// have to start from the end of the list!
		for(int i = list.size()-1; i >= 0; i--){
			if(i % 2 == 0)
				list.remove(i);
		}
		System.out.println(list);
		//Task 3
		for(int i = 0; i < 100; i++)
			list.add((int)(Math.random()*100)+150);

		//Task 4
		for(int i = list.size()-1; i >= 0; i--){
			if(i % 2 != 0)
				list.remove(i);
		}
		System.out.println(list);
		//Task 5
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) % 2 == 0)
				list.set(i, list.get(i)*list.get(i));
		}
		System.out.println(list);
		//Task 6
		for(int i = list.size()-1; i >= 0; i--){
			if(list.get(i) % 2 == 0)
				list.remove(i);
		}
		System.out.println(list);
		//Task 7
		for(int i = 1; i < list.size(); i+=2){
			list.set(i, list.get(i) - list.size());
		}
		//Task 8
		for(int i = 0; i < list.size()/2; i++){
			//int temp = list[i]; // array equivalent
			int temp = list.get(i);
			//list[i] = list[list.length-1-i];
			list.set(i, list.get(list.size()-1-i));
			//list[list.length-1-i] = temp;
			list.set(list.size()-1-i, temp);
		}
	}
}