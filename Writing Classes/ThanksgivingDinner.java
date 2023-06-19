public class ThanksgivingDinner
{
	static String drinks, appetizers, soup, salad, entree, side1, side2, dessert;

	public ThanksgivingDinner(String initdrinks, String initappetizers, String initsoup, String initsalad, String initentree, String initside1, String initside2, String initdessert){
		drinks = initdrinks;
		appetizers = initappetizers;
		soup = initsoup;
		salad = initsalad;
		entree = initentree;
		side1 = initside1;
		side2 = initside2;
		dessert = initdessert;
	}

	public void setDrinks(String newDrinks){
		drinks = newDrinks;
	}
	public void setAppetizers(String newAppetizers){
		appetizers = newAppetizers;
	}
	public void setSoup(String newSoup){
		soup = newSoup;
	}
	public void setSalad(String newSalad){
		salad = newSalad;
	}
	public void setEntree(String newEntree){
		entree = newEntree;
	}
	public void setSide1(String newSide1){
		side1 = newSide1;
	}
	public void setSide2(String newSide2){
		side2 = newSide2;
	}
	public void setDessert(String newDessert){
		dessert = newDessert;
	}

	public String getDrinks(){
		return drinks;
	}
	public String getAppetizers(){
		return appetizers;
	}
	public String getSoup(){
		return soup;
	}
	public String getSalad(){
		return salad;
	}
	public String getEntree(){
		return entree;
	}
	public String getSide1(){
		return side1;
	}
	public String getSide2(){
		return side2;
	}
	public String getDessert(){
		return dessert;
	}

	public String toString(){
		return "Drinks: "+drinks+"\nAppetizers: "+appetizers+"\nSoup: "+soup+"\nSalad: "+salad+"\nEntree: "+entree+"\nSide 1: "+side1+"\nSide 2: "+side2+"\nDessert: "+dessert;
	}
}