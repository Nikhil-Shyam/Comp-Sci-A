public class SuperHero extends SuperCitizen
{
	private String catchPhrase;

	public SuperHero(String name, String job, int hitPoints, int maxDamage, int defenseAbility, String superName, String superPower, boolean cape, int powerLevel, String catchPhrase){
		super(name, job, hitPoints, maxDamage, defenseAbility, superName, superPower, cape, powerLevel);
		this.catchPhrase = catchPhrase;
	}

	public int getPowerLevel(int x){
		return (int)(Math.random()*10)+1;
	}

	public boolean equals(SuperHero hero){
		if (!this.getName().equals(hero.getName()))
			return false;
		if (!this.getJob().equals(hero.getJob()))
			return false;
		if (this.getHitPoints() != hero.getHitPoints())
			return false;
		if (this.getMaxDamage() != hero.getMaxDamage())
			return false;
		if (this.getDefenseAbility() != hero.getDefenseAbility())
			return false;
		if (!this.getSuperName().equals(hero.getSuperName()))
			return false;
		if (!this.getSuperPower().equals(hero.getSuperPower()))
			return false;
		if (this.hasCape() != hero.hasCape())
			return false;
		if (this.getPowerLevel() != hero.getPowerLevel())
			return false;
		if (!this.getCatchphrase().equals(hero.getCatchphrase()))
			return false;
		return true;
	}

	public String getCatchphrase(){
		return catchPhrase;
	}

	public String toString(){
		return super.toString() + ",catchphrase:\"" + catchPhrase + "\"";
	}

	public static void main(String[] args){
		SuperHero flash = new SuperHero("Barry Allen", "Forensic Chemist", 100, 20, 30, "Flash", "Super Speed", false, 10, "I'm The Fastest Man Alive");
		SuperHero test = new SuperHero("Barry Allen", "Forensic Chemist", 100, 20, 30, "Flash", "Super Speed", false, 10, "I'm The Fastest Man Alive");
		System.out.println(flash.equals(test));
	}
}