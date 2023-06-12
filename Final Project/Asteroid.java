import javax.swing.JComponent;

public class Asteroid
{
	private int asteroidX = (int)(Math.random()*351);
	private int asteroidY = 0;
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
			asteroidY += (int)(Math.random()*9)+2;
			if (asteroidY > component.getHeight()){
				asteroidY = 0;
				asteroidX = (int)(Math.random()*(component.getWidth()+1-50));
			}
		}
	}
}
