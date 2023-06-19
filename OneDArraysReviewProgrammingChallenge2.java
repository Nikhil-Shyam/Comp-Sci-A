public class OneDArraysReviewProgrammingChallenge2
{
	static int[] arr;

	public OneDArraysReviewProgrammingChallenge2(){
		arr = new int[50];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*100)+1;
		}

		problem1();

		problem2();

		problem3();

		System.out.println("Array contains the number 27: " + problem4());

		System.out.println("All numbers are greater than 10 in the array: " + problem5() + "\n");

		for (int i = 0; i < arr.length-1; i++){
			System.out.print(arr[i] + " ");
		} System.out.println("\n");

		problem6(); System.out.println("\n");

		problem7(); System.out.println("\n");

		problem8();
	}

	public void problem1(){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i: arr){
			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}
		System.out.println("Max: " + max + "\nMin: " + min);
	}

	public void problem2(){
		int sum = 0;
		int mode = 0;
		int highCount = 0;
		for (int i: arr){
			int count = 0;
			sum += i;
			for (int j: arr){
				if (j == i)
					count++;
			}
			if (count > highCount){
				highCount = count;
				mode = i;
			}
		}
		double avg = sum / (double)arr.length;
		System.out.println("Sum: " + sum + "\nAverage: " + avg + "\nMode: " + mode);
	}

	public void problem3(){
		int ran = (int)(Math.random()*100)+1;
		int count = 0;
		for (int i: arr){
			if (i == ran)
				count++;
		}
		System.out.println("The number " + ran + " appears " + count + " times in the array");
	}

	public boolean problem4(){
		for (int i: arr){
			if (i == 27)
				return true;
		}
		return false;
	}

	public boolean problem5(){
		for (int i: arr){
			if (i < 10)
				return false;
		}
		return true;
	}

	public void problem6(){
		for (int i = 0; i < 3; i++) {
			int temp = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 0; j--)
				arr[j] = arr[j - 1];
			arr[0] = temp;
		}
		for (int i = 0; i < arr.length-1; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public void problem7(){
		for (int i = 0; i < 5; i++) {
			int temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++)
				arr[j] = arr[j + 1];
			arr[arr.length - 1] = temp;
		}
		for (int i = 0; i < arr.length-1; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public void problem8(){
		for (int i = 0; i < arr.length/2; i++){
			int temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
		for (int i = 0; i < arr.length-1; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args){
		OneDArraysReviewProgrammingChallenge2 app = new OneDArraysReviewProgrammingChallenge2();
	}
}
