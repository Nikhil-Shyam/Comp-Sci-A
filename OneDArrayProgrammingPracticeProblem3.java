public class OneDArrayProgrammingPracticeProblem3
{
	public OneDArrayProgrammingPracticeProblem3(){
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.print("part a: ");
		partA(arr);
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.print("\n\npart b: ");
		partB(arr2);
		System.out.println();
	}

	public void partA(int[] arr){
		for (int i = 0; i < arr.length; i++){
			if (i%2==1)
				arr[i] = arr[i-1];
			System.out.print(arr[i] + " ");
		}
	}

	public void partB(int[] arr){
		for (int i = 0; i < arr.length; i++){
			if (i%2==0)
				arr[i] = arr[i+1];
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args){
		OneDArrayProgrammingPracticeProblem3 app = new OneDArrayProgrammingPracticeProblem3();
	}
}