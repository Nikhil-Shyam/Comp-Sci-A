public class AuthorRunner{
	public static void main(String[] args){
		Author a1 = new Author("James Patterson", "JamesP@gmail.com", 'm');
		Author a2 = new Author("Nora Roberts", "NoraR@gmail.com", 'f');
		Author a3 = new Author("J R Ward", "JWard@yahoo.com", 'o');

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3.getGender());
		a3.setEmail("JW@gmail.com");
		System.out.println(a3);

		Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm'); // Test the constructor
		System.out.println(ahTeck);  // Test toString()
		ahTeck.setEmail("paulTan@nowhere.com");  // Test setter
		System.out.println("name is: " + ahTeck.getName());     // Test getter
		System.out.println("email is: " + ahTeck.getEmail());   // Test getter
		System.out.println("gender is: " + ahTeck.getGender()); // Test getter
	}
}