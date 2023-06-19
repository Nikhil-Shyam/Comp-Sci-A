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
		int row = (int)(Math.random()*size);
		int col = (int)(Math.random()*size);

		while (containsZero(arr) && min <= max){
			if (arr[row][col] == 0){
				arr[row][col] = min;
				x++;
			}
			if (x == count){
				min++;
				x = 0;
			}
			row = (int)(Math.random()*size);
			col = (int)(Math.random()*size);
		}

		for (int[] i: arr){
			for (int j: i){
				if (j < 10)
					System.out.print(j + "   ");
				else
					System.out.print(j + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean containsZero(int[][] arr){
		for(int[] i: arr){
			for (int j: i){
				if (j == 0)
					return true;
			}
		}
		return false;
	}

	public static void main (String[] args){
		TwoDArraysReviewTask2 app = new TwoDArraysReviewTask2();
	}
}