public class DoNow{
	public static void main (String[]args){
		DoNow doNow = new DoNow();
	}


	public DoNow(){
		int[][] arr = { {1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 10, 11, 12},
						{13, 14, 15, 16} };

		for (int[] i: arr){
			for (int j: i)
				System.out.print(j + " ");
			System.out.println();
		}
	}
}