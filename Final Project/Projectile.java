public class Projectile
{
	private int xPosition;
	private int yPosition;
	static final int SPEED = 6;

	public Projectile(int xPosition, int yPosition){
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public int getXPosition(){
		return xPosition;
	}

	public int getYPosition(){
		return yPosition;
	}

	public void updateProjectilePosition(){
		yPosition -= SPEED;
	}
}
