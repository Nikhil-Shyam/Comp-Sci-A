public class numberPattern4
{
	public static void main (String[] args)
	{
		numberPattern4 app=new numberPattern4();
	}

	public numberPattern4(){
		int x = 2;
		int pre = 1;
		int temp = 0;
		for (int i = 1; i <= 20; i++){
			System.out.print(x + " ");
			temp = x;
			x+=pre;
			pre = temp;
			if (i%5==0)
				System.out.println();
		}
	}
}