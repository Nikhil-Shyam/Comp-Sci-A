//ThanksgivingDinnerRunner Starter Code
public class ThanksgivingDinnerRunner{
	public static void main(String[]args){

		// you should write arrays for the other courses here below. Feel free to adjust the one above!
		String[] drinks = {"Water", "Apple juice", "Orange Juice", "Soda"};
		String[] appetizers = {"Sausage Rolls", "Fried Mac and Cheese Balls", "Shrimp Cocktail", "Cocktail Meatballs"};
		String[] soup = {"Pumpkin Soup", "Broccoli Cheddar Soup", "Carrot Ginger Soup", "Cream of Mushroom Soup"};
		String[] salad = {"Shaved Brussels Sprouts Salad", "Green Bean Salad", "Carrot Salad", "Broccoli Salad"};
		String[] entree = {"Turkey", "Roasted Lamb Chops", "Crackling Coppa Roast", "King Oyster Mushroom Steaks"};
		String[] side1 = {"Fondue Mashed Potatoes", "Green Bean Casserole", "Thanksgiving Rolls", "Mashed Potato Casserole"};
		String[] side2 = {"Southern Baked Mac & Cheese", "Classic Stuffing", "Sweet Potato Gratin", "Skillet Cornbread"};
		String[] dessert = {"Pumpkin Trifle", "Mini Apple Pies", "Mississippi Mud Pie", "Apple Cobbler"};

		/*Declare and Instantiate your dinner here by calling random values fro each array.
		 Your other random array elements should be included here to populate the values to instantiate your Thanksgiving Dinner.
		 Make sure you match the order of your constructor's parameter list! */

		ThanksgivingDinner dinner = new ThanksgivingDinner(drinks[(int)(Math.random()*drinks.length)],appetizers[(int)(Math.random()*appetizers.length)],soup[(int)(Math.random()*soup.length)],salad[(int)(Math.random()*salad.length)],entree[(int)(Math.random()*entree.length)],side1[(int)(Math.random()*side1.length)],side2[(int)(Math.random()*side2.length)],dessert[(int)(Math.random()*dessert.length)]);

		System.out.println(dinner); // This line will print the menu for your dinner if everything else is correct

	}

}