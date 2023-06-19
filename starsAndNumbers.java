public class starsAndNumbers
{
	public static void main (String[] args)
	{
		starsAndNumbers app=new starsAndNumbers();
	}

	public starsAndNumbers(){
		int x = 0;
		for (int i = 0; i < 10; i++){
			for (int j = x; j < i; j++){
				System.out.print("*");
			}
			System.out.println(x);
			if (i%2==0)
				x++;
		}
	}
}