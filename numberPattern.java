public class numberPattern
{
	public static void main (String[] args)
	{
		numberPattern app=new numberPattern();
	}

	public numberPattern(){
		for (int i = 4; i > 0; i--){
			for (int j = 5; j > i; j--){
				System.out.print(j);
			}
			if (i%2==1)
				System.out.print("*");
			System.out.println();
		}
	}
}