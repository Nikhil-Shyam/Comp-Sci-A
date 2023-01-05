public class OneDArraysReviewProgrammingChallenge2
{
	public OneDArraysReviewProgrammingChallenge2(){
		int[] arr = new int[50];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*100)+1;
		}

		//1
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i: arr){
			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}
		System.out.println("Max: " + max + "\nMin: " + min);

		//2
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

		//3
	}

	public static void main(String[] args){
		OneDArraysReviewProgrammingChallenge2 app = new OneDArraysReviewProgrammingChallenge2();
	}
}