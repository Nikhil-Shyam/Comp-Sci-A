import java.util.ArrayList;
import java.util.Random;

public class GothamLikeAdventureTown
{
	static ArrayList<String> firstNames = new ArrayList<String>();
	static ArrayList<String> lastNames = new ArrayList<String>();
	static ArrayList<String> occupations = new ArrayList<String>();
	static ArrayList<Person> dailyPlanetStreet = new ArrayList<Person>();
	static ArrayList<Person> safetyLand = new ArrayList<Person>();
	static ArrayList<Person> unfortunatelyFatallyWoundedPeople = new ArrayList<Person>();
	static Random random = new Random();

	public GothamLikeAdventureTown(){
		//initializing firstNames, lastNames, and occupations arrays
		firstNames.add("Liam"); firstNames.add("Noah"); firstNames.add("Oliver"); firstNames.add("Elijah"); firstNames.add("James"); firstNames.add("Olivia"); firstNames.add("Emma"); firstNames.add("Charlotte"); firstNames.add("Amelia"); firstNames.add("Ava");
		lastNames.add("Smith"); lastNames.add("Johnson"); lastNames.add("Williams"); lastNames.add("Brown"); lastNames.add("Garcia"); lastNames.add("Jones"); lastNames.add("Miller"); lastNames.add("Davis"); lastNames.add("Rodriguez"); lastNames.add("Martinez");
		occupations.add("Waiter"); occupations.add("Paramedic"); occupations.add("Dentist"); occupations.add("Nurse"); occupations.add("Electrition"); occupations.add("Doctor"); occupations.add("Surgeon"); occupations.add("Doorman"); occupations.add("Actor"); occupations.add("Accountant");

		//initializing superhero and supervillain
		SuperHero flash = new SuperHero("Barry Allen", "Forensic Chemist", 100, 20, 30, "Flash", "Super Speed", false, 10, "I'm The Fastest Man Alive");
		SuperVillain reverseFlash = new SuperVillain("Eobard Thawne", "Scientist", 99, 19, 29, "Reverse Flash", "Super Speed", false, 9, "Change the Timeline");

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
		//debugging
		System.out.println(dailyPlanetStreet + "\n");
		System.out.println("# of safetyLand people: " + safetyLand.size());
		System.out.println("# of unfortunatelyFatallyWoundedPeople people: " + unfortunatelyFatallyWoundedPeople.size() + "\n");
		//prinitng catch phrase and evil plan
		System.out.println(reverseFlash.getEvilPlan());
		System.out.println(flash.getCatchphrase() + "\n");

		//print starting health
		System.out.println("Hero starting health: " + flash.getHitPoints());
		System.out.println("Villain starting health: " + reverseFlash.getHitPoints() + "\n");

		int roundNum = 1;

		while (flash.getHitPoints() > 0 && reverseFlash.getHitPoints() > 0){ //loops until one has 0 hitPoints
			System.out.println("Round #" + roundNum);
			boolean heroAttacks = random.nextBoolean(); //randomly choosing who attacks first (true = hero attacks first)
			int heroAttack = random(flash.getMaxDamage(), 1); //hero damage
			int villainAttack = random(reverseFlash.getMaxDamage(), 1); //villain damage
			int heroDefend = random(flash.getDefenseAbility(), 1); //hero defense
			int villainDefend = random(reverseFlash.getDefenseAbility(), 1); //villain defense

			System.out.println("Hero Damage: " + heroAttack + " | Hero Defense: " + heroDefend);
			System.out.println("Villain Damage: " + villainAttack + " | Villain Defense: " + villainDefend);

			if (heroAttacks){ //hero attacks first
				System.out.println("Hero Attacks First!");
				if (heroAttack >= villainDefend){
					reverseFlash.damageHitPoints(heroAttack);
					System.out.println("Hero lands an attack!");
					ifLessThanZero(reverseFlash);
				}
				if (villainAttack >= heroDefend){
					flash.damageHitPoints(villainAttack);
					System.out.println("Villain lands an attack!");
					ifLessThanZero(flash);
				}
			}else{ //villain attacks first
				System.out.println("Villain Attacks First!");
				if (villainAttack >= heroDefend){
					flash.damageHitPoints(villainAttack);
					System.out.println("Villain lands an attack!");
					ifLessThanZero(flash);
				}
				if (heroAttack >= villainDefend){
					reverseFlash.damageHitPoints(heroAttack);
					System.out.println("Hero lands an attack!");
					ifLessThanZero(reverseFlash);
				}
			}
			System.out.println("Hero Health: " + flash.getHitPoints());
			System.out.println("Villain Health: " + reverseFlash.getHitPoints() + "\n");
			roundNum++;
		}

		if (reverseFlash.getHitPoints() == 0)
			System.out.println("Hero Wins!");
		else
			System.out.println("Villain Wins!");
	}

	public int random(int range, int start){
		return (int)(Math.random()*range)+start;
	}

	public void ifLessThanZero(SuperCitizen h){ //no negative numbers
		if (h.getHitPoints() < 0)
			h.zeroHitPoints();
	}

	public static void main(String[] args){
		GothamLikeAdventureTown app = new GothamLikeAdventureTown();
	}
}