public class SuperCitizen extends Person
{
	private String superName;
	private String superPower;
	private boolean cape;
	private int powerLevel;

	public SuperCitizen(String name, String job, int hitPoints, int maxDamage, int defenseAbility, String superName, String superPower, boolean cape, int powerLevel){
		super(name, job, hitPoints, maxDamage, defenseAbility);
		this.superName = superName;
		this.superPower = superPower;
		this.cape = cape;
		this.powerLevel = powerLevel;
	}

	public void powerLevelModification(int newLevel){
		powerLevel = newLevel;
	}

	public String getSuperPower(){
		return superPower;
	}

	public boolean hasCape(){
		return cape;
	}

	public int getPowerLevel(){
		return powerLevel;
	}

	public String getSuperName(){
		return superName;
	}

	public String toString(){
		return super.toString() + ",superName:\"" + superName + ",superPower:\"" + superPower + "\",cape:" + cape + ",powerLevel:" + powerLevel;
	}
}