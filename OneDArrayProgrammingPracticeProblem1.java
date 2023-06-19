public class OneDArrayProgrammingPracticeProblem1
{
	public OneDArrayProgrammingPracticeProblem1(){
		int[] arr = new int[40];
		System.out.print("orignl: ");
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*50)+1;
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n\npart a: ");
		partA(arr);
		System.out.print("\n\npart b: ");
		partB(arr);
		System.out.print("\n\npart c: ");
		partC(arr);
		System.out.print("\n\npart d: ");
		partD(arr);
		System.out.print("\n\npart e: ");
		partE(arr);
		System.out.print("\n\npart f: ");
		partF(arr);
		System.out.println();
	}

	public void partA(int[] arr){
		for (int i = 0; i < arr.length; i++){
			if (arr[i] % 2 == 0)
				arr[i] -= 2;
			System.out.print(arr[i] + " ");
		}
	}

	public void partB(int[] arr){
		for (int i = 0; i < arr.length; i++){
			if (i%2==1)
				arr[i] += 5;
			System.out.print(arr[i] + " ");
		}
	}

	public void partC(int[] arr){
		for (int i = 0; i < arr.length; i++){
			if (i%2==0 && arr[i]%3==1)
				arr[i] = 8;
			System.out.print(arr[i] + " ");
		}
	}

	public void partD(int[] arr){
		for (int i = 0; i < arr.length; i++){
			if (i%2==1 && arr[i]%4==3)
				arr[i] = 400;
			System.out.print(arr[i] + " ");
		}
	}

	public void partE(int[] arr){
		boolean eo = true;
		for (int i = 0; i < arr.length; i++){
			if (arr[i]%2 == 0){
				eo = !eo;
				if (eo)
					arr[i] += 500;
			}
			System.out.print(arr[i] + " ");
		}
	}

	public void partF(int[] arr){
		boolean alt = false;
		for (int i = 0; i < arr.length; i++){
			if (i % 5 == 0){
				alt = !alt;
				if (alt)
					arr[i] = 7;
				else
					arr[i] = 8;
			}
			System.out.print(arr[i] + " ");
		}
	}

	public static void main (String[] args){
		OneDArrayProgrammingPracticeProblem1 app = new OneDArrayProgrammingPracticeProblem1();
	}
}