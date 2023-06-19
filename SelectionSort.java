import java.util.ArrayList;

public class SelectionSort
{
	public SelectionSort(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(105); list.add(8); list.add(2); list.add(16); list.add(1); list.add(18); list.add(27); list.add(-10); list.add(12);
		int[] arr = {105, 8, 2, 16, 1, 18, 27, -10, 12};
		int swapIndex = 0;


		//Array

		//print unsorted
		for (int i = 0; i < arr.length-1; i++)
			System.out.print(arr[i] + ", ");
		System.out.println(arr[arr.length-1]);
		//sort
		for (int j = 0; j < arr.length; j++){
			int min = Integer.MAX_VALUE;
			for (int i = j; i < arr.length; i++){
				if (arr[i] < min){
					min = arr[i];
					swapIndex = i;
				}
			}
			int temp = arr[j];
			arr[j] = arr[swapIndex];
			arr[swapIndex] = temp;
		}
		//print sorted
		for (int i = 0; i < arr.length-1; i++)
			System.out.print(arr[i] + ", ");
		System.out.println(arr[arr.length-1] + "\n");


		//ArrayList

		//print unsorted
		System.out.println(list);
		//sort
		for (int j = 0; j < list.size(); j++){
			int min = Integer.MAX_VALUE;
			for (int i = j; i < list.size(); i++){
				if (list.get(i) < min){
					min = list.get(i);
					swapIndex = i;
				}
			}
			int temp = list.get(j);
			list.set(j, list.get(swapIndex));
			list.set(swapIndex, temp);
		}
		//print sorted
		System.out.println(list);
	}

	public static void main(String[] args){
		SelectionSort app = new SelectionSort();
	}
}