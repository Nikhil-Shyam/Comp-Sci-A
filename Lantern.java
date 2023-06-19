//Nikhil Shyam

public class Lantern
{
	public static void main(String[] args)
	{
		Lantern app = new Lantern();
	}

	public Lantern(){
		s(6);
		a(1);
		ln();

		s(5);
		a(3);
		ln();

		s(4);
		a(5);
		ln();

		s(2);
		a(9);
		ln();
// ^^ triangle ^^
		al();

		tri();

		box();

		tri();

		al();

		tri();

		box();
// vv triangle vv
		s(4);
		a(5);
		ln();

		s(2);
		a(9);
		ln();

		s(4);
		a(5);
		ln();

		s(5);
		a(3);
		ln();

		s(6);
		a(1);
		ln();

	}

	public static void a(int x){
		for (int i = 0; i < x; i++)
			System.out.print("*");
	}

	public static void l(){
		for (int i = 0; i < 5; i++)
			System.out.print(" |");
	}

	public static void s(int x){
		for (int i = 0; i < x; i++)
			System.out.print(" ");
	}

	public static void ln(){
		System.out.println();
	}


	/*
		* | | | | | *
	*/
	public static void al(){
		a(1);
		l();
		s(1);
		a(1);
		ln();
	}


	/*
	  *********
		*****
	  *********
	*/
	public static void tri(){
		s(2);
		a(9);
		ln();
		s(4);
		a(5);
		ln();
		s(2);
		a(9);
		ln();
	}


	/*
		*************
		* | | | | | *
		* | | | | | *
		*************
	*/
	public static void box(){
		a(13);
		ln();
		al();
		al();
		a(13);
		ln();
	}
}