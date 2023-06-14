import javax.swing.JComponent;

public class Asteroid
{
	private int asteroidX = (int)(Math.random()*351);
	private int asteroidY = 0;
	private boolean isDestroyed = false;
	private JComponent component;
	private int count = 0;
	private int velX = 2;
	private int value = 1;

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
			if (value == (int)(Math.random()*25)+1){
				count++;
				asteroidX += velX;
				if (asteroidX > component.getWidth()-50 || asteroidX < 0 || count == 50){
					velX = -velX;
					count = 0;
				}
			}
			if (asteroidY > component.getHeight()){
				asteroidY = 0;
				asteroidX = (int)(Math.random()*(component.getWidth()+1-50));
			}
		}
	}
}
