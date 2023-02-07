public class TwoDArraysReviewTask2
{
	public TwoDArraysReviewTask2(){
		fill(2, 1, 2, 2);
	}

	public void fill(int size, int min, int max, int count){
		int[][] arr = new int[size][size];
		while (min <= max){
			int x = 0;
			for (int i = 0; i < arr.length; i++){
				for (int j = 0; j < arr[i].length; j++){
					arr[i][j] = min;
					x++;
					if (x == count)
						break;
				}
			}
			min++;
		}

		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}

	}

	public static void main (String[] args){
		TwoDArraysReviewTask2 app = new TwoDArraysReviewTask2();
	}
}