import java.util.ArrayList;

public class InsertionSort
{
	public InsertionSort(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(105); list.add(8); list.add(2); list.add(16); list.add(1); list.add(18); list.add(27); list.add(-10); list.add(12);
		int[] arr = {105, 8, 2, 16, 1, 18, 27, -10, 12};


		//Array

		//print unsorted
		for (int i = 0; i < arr.length-1; i++)
			System.out.print(arr[i] + ", ");
		System.out.println(arr[arr.length-1]);
		//sort
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < i+1; j++){
				if (arr[i] < arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		//print sorted
		for (int i = 0; i < arr.length-1; i++)
			System.out.print(arr[i] + ", ");
		System.out.println(arr[arr.length-1] + "\n");



		//ArrayList

		//print unsorted
		System.out.println(list);
		//sort
		for (int i = 0; i < list.size(); i++){
			for (int j = 0; j < i+1; j++){
				if (list.get(i) < list.get(j)){
					int temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		//print sorted
		System.out.println(list);
	}

	public static void main (String[] args){
		InsertionSort app = new InsertionSort();
	}
}