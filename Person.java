public class Person
{
	private String name;
	private String job;
	private int hitPoints;
	private int maxDamage;
	private int defenseAbility;

	public Person(String name, String job, int hitPoints, int maxDamage, int defenseAbility){
		this.name = name;
		this.job = job;
		this.hitPoints = hitPoints;
		this.maxDamage = maxDamage;
		this.defenseAbility = defenseAbility;
	}

	public String getName(){
		return name;
	}

	public String getJob(){
		return job;
	}

	public int getHitPoints(){
		return hitPoints;
	}

	public int getMaxDamage(){
		return maxDamage;
	}

	public int getDefenseAbility(){
		return defenseAbility;
	}

	public String toString(){
		return "name:\"" + name + "\",job:\"" + job + "\",hitPoints:" + hitPoints + ",maxDamage:" + maxDamage + ",defenseAbility:" + defenseAbility;
	}
}