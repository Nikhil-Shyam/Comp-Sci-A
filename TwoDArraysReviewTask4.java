public class TwoDArraysReviewTask4
{
	public TwoDArraysReviewTask4(){
		fill(12);
	}

	public void fill(int num){
		int size = 0;
		int s = 1;
		while (num > s*s){
			s++;
		}

		int[][] arr = new int[s][s];

		boolean right = true;
		int change = 0;
		int count = 1;
		while (change < s && count <= num && change > -1){
			if (right)
				arr[0][change] = count;
			else
				arr[change][s-1] = count;
			if (change == s){
				right = !right;
				change = 0;
			}
			change++;
			count++;
		}

		for (int[] a: arr){
			for (int j: a)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	public static void main(String[] args){
		TwoDArraysReviewTask4 app = new TwoDArraysReviewTask4();
	}
}