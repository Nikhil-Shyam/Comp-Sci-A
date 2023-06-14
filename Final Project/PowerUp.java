import javax.swing.JComponent;

public class PowerUp {
    private int powerUpX = (int)(Math.random()*351);
	private int powerUpY = 0;
	private boolean isCollected = false;
	private boolean offScreen = false;
	private JComponent component;

	public PowerUp(JComponent component){
		this.component = component;
	}

	public int getPowerUpX(){
		return powerUpX;
	}

	public int getPowerUpY(){
		return powerUpY;
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

	public void setPowerUpY(int newPowerUpY){
		powerUpY = newPowerUpY;
	}

	public void updatePowerUp(){
		if (!isCollected){
			powerUpY += (int)(Math.random()*9)+2;
			if (powerUpY > component.getHeight())
				offScreen = true;
		}
	}
}
