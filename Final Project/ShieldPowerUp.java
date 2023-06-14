import javax.swing.JComponent;

public class ShieldPowerUp{
    
    private int shieldPowerUpX = (int)(Math.random()*351);
	private int shieldPowerUpY = 0;
	private boolean isCollected = false;
    private boolean offScreen = false;
	private JComponent component;
	private int count = 0;
	private int velX = 2;

	public ShieldPowerUp(JComponent component){
		this.component = component;
	}

	public int getShieldPowerUpX(){
		return shieldPowerUpX;
	}

	public int getShieldPowerUpY(){
		return shieldPowerUpY;
	}

	public boolean isCollected(){
		return isCollected;
	}

	public boolean isOffScreen(){
		return offScreen;
	}

	public void setOffScreen(boolean offScreen){
		this.offScreen = offScreen;
	}

	public void setCollected(boolean isCollected){
		this.isCollected = isCollected;
	}

	public void setShieldPowerUpY(int newProjectilePowerUpY){
		shieldPowerUpY = newProjectilePowerUpY;
	}

    public void updateShieldPowerUp(){
		if (!isCollected){
			count++;
			shieldPowerUpY += (int)(Math.random()*5)+2;
			shieldPowerUpX += velX;
			if (shieldPowerUpX > component.getWidth()-50 || shieldPowerUpX < 0 || count == (int)(Math.random()*41)+30){
				velX = -velX;
				count = 0;
			}
			if (shieldPowerUpY > component.getHeight())
				offScreen = true;
		}
	}
}
