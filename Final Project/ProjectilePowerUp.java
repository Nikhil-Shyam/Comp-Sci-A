import javax.swing.JComponent;

public class ProjectilePowerUp {
    private int projectilePowerUpX = (int)(Math.random()*351);
	private int projectilePowerUpY = 0;
	private boolean isCollected = false;
	private boolean offScreen = false;
	private JComponent component;
	private int count = 0;
	private int velX = 2;

	public ProjectilePowerUp(JComponent component){
		this.component = component;
	}

	public int getProjectilePowerUpX(){
		return projectilePowerUpX;
	}

	public int getProjectilePowerUpY(){
		return projectilePowerUpY;
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

	public void setProjectilePowerUpY(int newProjectilePowerUpY){
		projectilePowerUpY = newProjectilePowerUpY;
	}

	public void updateProjectilePowerUp(){
		if (!isCollected){
			count++;
			projectilePowerUpY += (int)(Math.random()*5)+2;
			projectilePowerUpX += velX;
			if (projectilePowerUpX > component.getWidth()-50 || projectilePowerUpX < 0 || count == (int)(Math.random()*41)+30){
				velX = -velX;
				count = 0;
			}
			if (projectilePowerUpY > component.getHeight())
				offScreen = true;
		}
	}
}
