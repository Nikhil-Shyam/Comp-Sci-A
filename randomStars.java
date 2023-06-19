public class randomStars
{
	public static void main (String[] args)
	{
		randomStars app=new randomStars();
	}

	public randomStars(){
		for (int i = 0; i < 15; i++){
			int ran = (int)(Math.random()*11)+10;
			for (int j = 0; j < ran; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}