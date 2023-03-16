import java.util.ArrayList;

public class GothamLikeAdventureTown
{
	public static ArrayList<String> firstNames = new ArrayList<String>();
	public static ArrayList<String> lastNames = new ArrayList<String>();
	public static ArrayList<String> occupations = new ArrayList<String>();
	public static ArrayList<Person> dailyPlanetStreet = new ArrayList<Person>();
	public static ArrayList<Person> safetyLand = new ArrayList<Person>();
	public static ArrayList<Person> unfortunatelyFatallyWoundedPeople = new ArrayList<Person>();

	public GothamLikeAdventureTown(){
		//initializing firstNames, lastNames, and occupations arrays
		firstNames.add("Liam"); firstNames.add("Noah"); firstNames.add("Oliver"); firstNames.add("Elijah"); firstNames.add("James"); firstNames.add("Olivia"); firstNames.add("Emma"); firstNames.add("Charlotte"); firstNames.add("Amelia"); firstNames.add("Ava");
		lastNames.add("Smith"); lastNames.add("Johnson"); lastNames.add("Williams"); lastNames.add("Brown"); lastNames.add("Garcia"); lastNames.add("Jones"); lastNames.add("Miller"); lastNames.add("Davis"); lastNames.add("Rodriguez"); lastNames.add("Martinez");
		occupations.add("Waiter"); occupations.add("Paramedic"); occupations.add("Dentist"); occupations.add("Nurse"); occupations.add("Electrition"); occupations.add("Doctor"); occupations.add("Surgeon"); occupations.add("Doorman"); occupations.add("Actor"); occupations.add("Accountant");

		//initializing superhero and supervillain
		SuperHero flash = new SuperHero("Barry Allen", "Forensic Chemist", 100, 20, 30, "Flash", "Super Speed", false, 10, "I'm The Fastest Man Alive");
		SuperVillain reverseFlash = new SuperVillain("Eobard Thawne", "Scientist", 99, 19, 29, "Reverse Flash", "Super Speed", false, 10, "Change the Timeline");

		//initalizing dailyPlanetStreet array with randomly generated NormalCitizens
		for (int i = 0; i < 48; i++){
			int firstNameRan = random(10, 0);
			int lastNameRan = random(10, 0);
			int occupationRan = random(10, 0);
			int hitPointsRan = random(16, 20);
			int maxDamageRan = random(5, 1);
			int defenseAbilityRan = random(10, 3);
			dailyPlanetStreet.add(new NormalCitizen(firstNames.get(firstNameRan) + " " + lastNames.get(lastNameRan), occupations.get(occupationRan), hitPointsRan, maxDamageRan, defenseAbilityRan));
		}

		//adding superhero and supervillain at random spots in dailyPlanetStreet array
		dailyPlanetStreet.add(random(48, 0), flash);
		dailyPlanetStreet.add(random(49, 0), reverseFlash);

		//index used for superhero and supervillain
		int index;

		//while loop to keep happening until only villain and hero left
		while (dailyPlanetStreet.size() >= 3){
			//index of villain
			index = dailyPlanetStreet.indexOf(reverseFlash);

			if (index - 1 == -1 && dailyPlanetStreet.get(index + 1) instanceof NormalCitizen){ //if villain is first index
				unfortunatelyFatallyWoundedPeople.add(dailyPlanetStreet.get(index + 1));
				dailyPlanetStreet.remove(index + 1);
			}else if (index + 1 == dailyPlanetStreet.size() && dailyPlanetStreet.get(index - 1) instanceof NormalCitizen){ //if villain is last index
				unfortunatelyFatallyWoundedPeople.add(dailyPlanetStreet.get(index - 1));
				dailyPlanetStreet.remove(index - 1);
			}else if(index - 1 != -1 && index + 1 != dailyPlanetStreet.size()){ //if villain is in the middle
				if (dailyPlanetStreet.get(index - 1) instanceof SuperHero){ //if hero is behind villain then remove person in front
					unfortunatelyFatallyWoundedPeople.add(dailyPlanetStreet.get(index + 1));
					dailyPlanetStreet.remove(index + 1);
				}else if (dailyPlanetStreet.get(index + 1) instanceof SuperHero){ //if hero is in front of villain then remove person behind
					unfortunatelyFatallyWoundedPeople.add(dailyPlanetStreet.get(index - 1));
					dailyPlanetStreet.remove(index - 1);
				}else{ //if hero isn't close
					int ran = random(2, 0); //choosing random person
					if (ran == 0){ //remove person in front
						unfortunatelyFatallyWoundedPeople.add(dailyPlanetStreet.get(index + 1));
						dailyPlanetStreet.remove(index + 1);
					}else{ //remove person behind
						unfortunatelyFatallyWoundedPeople.add(dailyPlanetStreet.get(index - 1));
						dailyPlanetStreet.remove(index - 1);
					}
				}
			}
			//moving random person to safetyland that isn't hero or villain
			int ran;
			if (dailyPlanetStreet.size() >= 3){ //stopping while loop from running infinitely if hero and villain are the only people left (happens if hero "protects" someone)
				do
					ran = random(dailyPlanetStreet.size(), 0);
				while (ran == dailyPlanetStreet.indexOf(flash) || ran == dailyPlanetStreet.indexOf(reverseFlash));
				safetyLand.add(dailyPlanetStreet.get(ran));
				dailyPlanetStreet.remove(ran);
			}

			//getting index of hero and moving them to a random position
			index = dailyPlanetStreet.indexOf(flash);
			ran = random(dailyPlanetStreet.size(), 0);
			dailyPlanetStreet.remove(index);
			dailyPlanetStreet.add(ran, flash);

		}
		System.out.println(dailyPlanetStreet);
		System.out.println("# of safetyLand people: " + safetyLand.size());
		System.out.println("# of unfortunatelyFatallyWoundedPeople people: " + unfortunatelyFatallyWoundedPeople.size());
		System.out.println(reverseFlash.getEvilPlan());
		System.out.println(flash.getCatchphrase());
	}

	public int random(int range, int start){
		return (int)(Math.random()*range)+start;
	}

	public static void main(String[] args){
		GothamLikeAdventureTown app = new GothamLikeAdventureTown();
	}
}