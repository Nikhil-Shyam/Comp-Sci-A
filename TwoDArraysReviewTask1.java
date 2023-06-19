public class TwoDArraysReviewTask1
{
	private int[][] arr = new int[10][10];

	public TwoDArraysReviewTask1(){
		partA();
		partB();
		partC();
		partD();
		partE();
		partF();
		partG();
	}

	public void partA(){
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++)
				arr[i][j] = (int)(Math.random()*41) + 10;
		}
		print();
	}

	public void partB(){
		for (int i = 0; i < arr.length; i++){
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++)
				sum+=arr[j][i];
			System.out.println("Sum of column " + (i+1) + ": " + sum);
		}
		System.out.println();
	}

	public void partC(){
		for (int i = 0; i < arr.length; i++){
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++)
				sum+=arr[i][j];
			System.out.println("Sum of row " + (i+1) + ": " + sum);
		}
		System.out.println();
	}

	public void partD(){
		for (int i = 0; i < arr.length; i++){
			int sumRow = 0;
			int sumCol = 0;
			for (int j = 0; j < arr[i].length; j++){
				sumRow+=arr[i][j];
				sumCol+=arr[j][i];
			}
			System.out.println("Sum of row " + (i+1) + ": " + sumRow + "\nSum of col " + (i+1) + ": " + sumCol);
		}
		System.out.println();
	}

	public void partE(){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++){
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}
		System.out.println("Largest value: " + max + "\n");
	}

	public void partF(){
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++){
				if (arr[i][j] < min)
					min = arr[i][j];
			}
		}
		System.out.println("Smallest value: " + min + "\n");
	}

	public void partG(){
		for (int i = 0; i < arr.length; i++){
			int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
			int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;
			for (int j = 0; j < arr[i].length; j++){
				if (arr[i][j] < minRow)
					minRow = arr[i][j];
				if (arr[i][j] > maxRow)
					maxRow = arr[i][j];
				if (arr[j][i] < minCol)
					minCol = arr[j][i];
				if (arr[j][i] > maxCol)
					maxCol = arr[j][i];
			}System.out.println("Smallest and largest value in row " + (i+1) + ": " + minRow + " and " + maxRow + "\nSmallest and largest value in col " + (i+1) + ": " + minCol + " and " + maxCol);
		}
		System.out.println();
	}

	public void print(){
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args){
		TwoDArraysReviewTask1 app = new TwoDArraysReviewTask1();
	}
}