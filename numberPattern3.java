public class numberPattern3
{
	public static void main (String[] args)
	{
		numberPattern3 app=new numberPattern3();
	}

	public numberPattern3(){
		int x = 8;
		for (int i = 0; i < 5; i++){
			System.out.println(x + "12" + x + "4");
			x-=2;
		}
	}
}