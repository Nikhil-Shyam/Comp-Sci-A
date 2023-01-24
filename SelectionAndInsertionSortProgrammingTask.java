import java.util.ArrayList;

public class SelectionAndInsertionSortProgrammingTask
{
	public SelectionAndInsertionSortProgrammingTask(){
		ArrayList<Integer> original = new ArrayList<Integer>();
		fill(original);

		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < original.size(); i++)
			temp.add(original.get(i));

		System.out.println("Contains the value 27: " + search(original));
		System.out.println();

		System.out.println(original);
		selectionSort(original);
		System.out.println(original);
		System.out.println();

		for (int i = 0; i < original.size(); i++)
			original.set(i, temp.get(i));

		int countInsertionSort = 0;
		System.out.println(original);
		insertionSort(original);
		System.out.println(original);
	}

	public void fill(ArrayList<Integer> original){
		for (int i = 0; i < 50; i++)
			original.add((int)(Math.random()*100)+1);
	}

	public void selectionSort(ArrayList<Integer> original){
		int countSelectionSort = 0;
		for (int j = 0; j < original.size()-1; j++)
		{
			int minIndex = j;
			for (int k = j + 1; k < original.size(); k++) {
				if (original.get(k) < original.get(minIndex)){
					minIndex = k;
					countSelectionSort++;
				}
			}
			int temp = original.get(j);
			original.set(j, original.get(minIndex));
			original.set(minIndex, temp);
			countSelectionSort++;
		}
		System.out.println("Number of steps: " + countSelectionSort);
	}

	public void insertionSort(ArrayList<Integer> original){
		int countInsertionSort = 0;
		for (int j = 1; j < original.size(); j++){
			int temp = original.get(j);
			int possibleIndex = j;
			while (possibleIndex > 0 && temp < original.get(possibleIndex - 1)){
				original.set(possibleIndex, original.get(possibleIndex - 1));
				possibleIndex--;
				countInsertionSort++;
			}
			original.set(possibleIndex, temp);
			countInsertionSort++;
		}
		System.out.println("Number of steps: " + countInsertionSort);
	}

	public boolean search(ArrayList<Integer> original){
		for (int i = 0; i < original.size(); i++){
			if (original.get(i) == 27)
				return true;
		}
		return false;
	}

	public static void main(String[] args){
		SelectionAndInsertionSortProgrammingTask app = new SelectionAndInsertionSortProgrammingTask();
	}
}