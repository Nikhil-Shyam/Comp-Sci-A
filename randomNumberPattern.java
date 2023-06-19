public class randomNumberPattern
{
	public static void main (String[] args)
	{
		randomNumberPattern app=new randomNumberPattern();
	}

	public randomNumberPattern(){
		int pre = 0;
		for (int i = 0; i < 20; i++){
			pre = (int)(Math.random()*5)+(pre+1);
			System.out.print(pre+ " ");
		}
	}
}