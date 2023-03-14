public class SuperHero extends SuperCitizen
{
	private String catchPhrase;

	public SuperHero(String name, String job, int hitPoints, int maxDamage, int defenseAbility, String superName, String superPower, boolean cape, int powerLevel, String catchPhrase){
		super(name, job, hitPoints, maxDamage, defenseAbility, superName, superPower, cape, powerLevel);
		this.catchPhrase = catchPhrase;
	}

	public int getPowerLevel(){
		return (int)(Math.random()*10)+1;
	}

	public String getCatchphrase(){
		return catchPhrase;
	}

	public String toString(){
		return super.toString() + ",catchphrase:\"" + catchPhrase + "\"";
	}
}