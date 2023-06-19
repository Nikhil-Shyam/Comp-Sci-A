public class TwoDArraysReviewTask3
{
	public TwoDArraysReviewTask3(){
		int[][] arr = new int[5][5];
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++){
				arr[i][j] = i + j;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		for (int j = 0; j < 5; j++){
			int temp = arr[j][0];
			arr[j][0] = arr[j][arr.length-1];
			arr[j][arr.length-1] = temp;
		}

		for (int[] i: arr){
			for (int j: i)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	public static void main(String[] args){
		TwoDArraysReviewTask3 app = new TwoDArraysReviewTask3();
	}
}