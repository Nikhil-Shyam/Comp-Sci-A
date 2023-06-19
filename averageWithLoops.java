public class averageWithLoops
{
	public static void main (String[] args)
	{
		averageWithLoops app=new averageWithLoops();
	}

	public averageWithLoops(){
		int sum = 0;
		double x = 0.0;
		for (int i = 1; i <= 1000; i++){
			if (i % 5 == 3){
				sum+=i;
				x++;
			}
		}
		double avg = sum/x;
		System.out.println("The average is: " + avg);
	}
}