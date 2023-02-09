public class TwoDArraysReviewTask2
{
	public TwoDArraysReviewTask2(){
		fill(2, 1, 2, 2);
		fill(4, 1, 2, 8);
		fill(6, 1, 18, 2);
		fill(6, 1, 9, 4);
	}

	public void fill(int size, int min, int max, int count){
		int[][] arr = new int[size][size];
		int x = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++){
				arr[i][j] = min;
				x++;
				if (x == count){
					min++;
					x = 0;
				}
			}
		}

		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static void main (String[] args){
		TwoDArraysReviewTask2 app = new TwoDArraysReviewTask2();
	}
}