public class ForEachPracticeProblem1
{
	static int[] arr;

	public ForEachPracticeProblem1(){
		arr = new int[100];
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int)(Math.random()*1000)+1;
		System.out.print("part a: ");
		partA();
		System.out.print("\npart b: ");
		partB();
		System.out.print("part c: ");
		partC();
	}

	public static void main(String[] args){
		ForEachPracticeProblem1 app = new ForEachPracticeProblem1();
	}

	public void partA(){
		for (int num: arr){
			if (num % 2 == 1)
				System.out.print(num + " ");
		}
	}

	public void partB(){
		int sum = 0;
		for (int num: arr)
			sum += num;
		System.out.println("Sum: " + sum + "\tAverage: " + (sum/(double)arr.length));
	}

	public void partC(){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num: arr){
			if (num < min)
				min = num;
			if (num > max)
				max = num;
		}
		System.out.println("Max: " + max + "\tMin: " + min);
	}
}