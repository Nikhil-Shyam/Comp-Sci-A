public class OneDArrayProgrammingPracticeProblem2
{
	public OneDArrayProgrammingPracticeProblem2(){
		int[] arr = new int[30];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*50)+1;
		}
		System.out.print("part a: ");
		partA(arr);
		System.out.print("\n\npart b: ");
		partB(arr);
		System.out.print("\n\npart c: ");
		partC(arr);
		System.out.print("\n\npart d: ");
		partD(arr);
		System.out.println();
	}

	public void partA(int[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public void partB(int[] arr){
		int temp;
		for (int i = 0; i < arr.length/2; i++){
			temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
		partA(arr);
	}

	public void partC(int[] arr){
		for (int i = 0; i < arr.length; i+=2)
			arr[i] = 5;
		partA(arr);
	}

	public void partD(int[] arr){
		int hold = arr[0];
		for (int i = 1; i < arr.length; i++){
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = hold;
		partA(arr);
	}

	public static void main(String[] args){
		OneDArrayProgrammingPracticeProblem2 app = new OneDArrayProgrammingPracticeProblem2();
	}
}