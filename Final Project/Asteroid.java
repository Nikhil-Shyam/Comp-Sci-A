import javax.swing.JComponent;

public class Asteroid
{
	private int asteroidX = 100;
	private int asteroidY = 25;
	private boolean isDestroyed = false;
	private JComponent component;

	public Asteroid(JComponent component){
		this.component = component;
	}

	public int getAsteroidX(){
		return asteroidX;
	}

	public int getAsteroidY(){
		return asteroidY;
	}

	public boolean isDestroyed(){
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed){
		this.isDestroyed = isDestroyed;
	}

	public void updateAsteroid(){
		if (!isDestroyed){
			asteroidY += (int)(Math.random()*5)+2;
			if (asteroidY > component.getHeight()){
				asteroidY = 0;
				asteroidX = (int)(Math.random()*(component.getWidth()+1));
			}
		}
	}
}
