import java.util.ArrayList;

public class GothamLikeAdventureTown
{
	public static ArrayList<String> firstNames = new ArrayList<String>();
	public static ArrayList<String> lastNames = new ArrayList<String>();
	public static ArrayList<String> occupations = new ArrayList<String>();
	public static ArrayList<Person> dailyPlanetStreet = new ArrayList<Person>();

	public GothamLikeAdventureTown(){
		firstNames.add("Liam"); firstNames.add("Noah"); firstNames.add("Oliver"); firstNames.add("Elijah"); firstNames.add("James"); firstNames.add("Olivia"); firstNames.add("Emma"); firstNames.add("Charlotte"); firstNames.add("Amelia"); firstNames.add("Ava");
		lastNames.add("Smith"); lastNames.add("Johnson"); lastNames.add("Williams"); lastNames.add("Brown"); lastNames.add("Garcia"); lastNames.add("Jones"); lastNames.add("Miller"); lastNames.add("Davis"); lastNames.add("Rodriguez"); lastNames.add("Martinez");
		occupations.add("Waiter"); occupations.add("Paramedic"); occupations.add("Dentist"); occupations.add("Nurse"); occupations.add("Electrition"); occupations.add("Doctor"); occupations.add("Surgeon"); occupations.add("Doorman"); occupations.add("Actor"); occupations.add("Accountant");

		SuperHero flash = new SuperHero("Barry Allen", "Forensic Chemist", 100, 20, 30, "Flash", "Super Speed", false, 10, "I'm The Fastest Man Alive");
		SuperVillain reverseFlash = new SuperVillain("Eobard Thawne", "Scientist", 99, 19, 29, "Reverse Flash", "Super Speed", false, 10, "Change the Timeline");
		dailyPlanetStreet.add(flash);
		dailyPlanetStreet.add(reverseFlash);
		for (int i = 0; i < 48; i++){
			int firstNameRan = random(10, 0);
			int lastNameRan = random(10, 0);
			int occupationRan = random(10, 0);
			int hitPointsRan = random(16, 20);
			int maxDamageRan = random(5, 1);
			int defenseAbilityRan = random(10, 3);
			dailyPlanetStreet.add(new NormalCitizen(firstNames.get(firstNameRan) + " " + lastNames.get(lastNameRan), occupations.get(occupationRan), hitPointsRan, maxDamageRan, defenseAbilityRan));
		}

		System.out.println(dailyPlanetStreet);
	}

	public int random(int range, int start){
		return (int)(Math.random()*range)+start;
	}

	public static void main(String[] args){
		GothamLikeAdventureTown app = new GothamLikeAdventureTown();
	}
}