public class NumberPatterns2
{
	public static void main (String[] args)
	{
		NumberPatterns2 app=new NumberPatterns2();
	}

	public NumberPatterns2(){
		int mid = 1;
		int x = 1;
		for (int i = 1; i <= 5; i++){
			x = 1;
			for (int j = 1; j < i*2; j++){
				if (j+1 <= mid){
					System.out.print(x + " ");
					if (j != mid)
						x*=2;
				}else{
					System.out.print(x + " ");
					x/=2;
				}
			}
			mid++;
			System.out.println();
		}
	}
}