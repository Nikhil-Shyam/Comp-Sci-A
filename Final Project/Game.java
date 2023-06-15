import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
// import javax.swing.JComponent;
import java.awt.Color;
// import java.awt.event.KeyEvent;
import java.awt.Graphics;
// import java.awt.event.KeyAdapter;
// import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel{
	private int shipX;
	private int shipY;
	private int time = 6000;
	private int lives = 3;
	private int asteroidsHit;
	private boolean gameOver;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Rectangle> enemyRectangles;
	private Rectangle playerRectangle;
	private Timer timer;
	private JFrame frame;

	private int velX = 0;
	private int velY = 0;
	private int shootCount = 0;
	private ProjectilePowerUp projectilePowerUp;
	private Rectangle projectilePowerUpRectangle;
	private int projectilePowerUpTime = 0;
	private ShieldPowerUp shieldPowerUp;
	private Rectangle shieldPowerUpRectangle;
	private Rectangle shield;
	private int shieldPowerUpTime = 0;

	public Game(JFrame frame){
		this.frame = frame;
		asteroids = new ArrayList<Asteroid>();
		projectiles = new ArrayList<Projectile>();
		enemyRectangles = new ArrayList<Rectangle>();
		shipX = 200;
		shipY = 500;
		playerRectangle = new Rectangle(shipX, shipY, 30, 30);
		projectilePowerUp = new ProjectilePowerUp(this);
		projectilePowerUp.setProjectilePowerUpY(700);
		projectilePowerUp.setOffScreen(true);
		projectilePowerUpRectangle = new Rectangle(frame.getWidth(), projectilePowerUp.getProjectilePowerUpY(), 10, 10);
		shieldPowerUp = new ShieldPowerUp(this);
		shieldPowerUp.setShieldPowerUpY(700);
		shieldPowerUp.setOffScreen(true);
		shieldPowerUpRectangle = new Rectangle(shieldPowerUp.getShieldPowerUpX(), shieldPowerUp.getShieldPowerUpY());
		shield = new Rectangle(500, 700, 50, 50);

		setFocusable(true);
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent event){
				handleKeyPress(event);
			}
			@Override
			public void keyReleased(KeyEvent event){
				handleKeyRelease(event);
			}
		});

		timer = new Timer(10, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				if (!gameOver){
					time--;
					updateScreen();
					frame.repaint();
				}
			}
		});
		timer.start();
	}

	public void updateEnemyRectangles(){
		for (int i = 0; i < asteroids.size(); i++){
			enemyRectangles.get(i).setLocation(asteroids.get(i).getAsteroidX(), asteroids.get(i).getAsteroidY());
		}
	}

	public void updateProjectilePowerUpRectangle(){
		projectilePowerUpRectangle.setLocation(projectilePowerUp.getProjectilePowerUpX(), projectilePowerUp.getProjectilePowerUpY());
	}

	public void updateShieldPowerUpRectangle(){
		shieldPowerUpRectangle.setLocation(shieldPowerUp.getShieldPowerUpX(), shieldPowerUp.getShieldPowerUpY());
	}

	private void handleKeyPress(KeyEvent event){
		if(event.getKeyCode() == 38)
			velY = -3;

		if (event.getKeyCode() == 40)
			velY = 3;

		if (event.getKeyCode() == 37)
			velX = -3;

		if (event.getKeyCode() == 39)
			velX = 3;

		if (event.getKeyCode() == 32){
			if (shootCount % 3 == 0)
				shoot();
			shootCount++;
		}
	}

	private void handleKeyRelease(KeyEvent event){
		if(event.getKeyCode() == 38)
			velY = 0;

		if (event.getKeyCode() == 40)
			velY = 0;

		if (event.getKeyCode() == 37)
			velX = 0;

		if (event.getKeyCode() == 39)
			velX = 0;

		if (event.getKeyCode() == 32)
			shootCount = 0;
	}

	private void shoot(){
		projectiles.add(new Projectile(shipX+12, shipY));
	}

	private void checkForAsteroidCollisions(){
		for (int i = 0; i < enemyRectangles.size(); i++){
			if (enemyRectangles.get(i).intersects(playerRectangle)){
				enemyRectangles.remove(i);
				asteroids.remove(i);
				lives--;
			}
		}
	}

	private void checkForProjectilePowerUpCollision(){
		if (projectilePowerUpRectangle.intersects(playerRectangle)){
			removeProjectilePowerUp();
		}
	}

	private void checkForShieldPowerUpCollision(){
		if (shieldPowerUpRectangle.intersects(playerRectangle)){
			removeShieldPowerUp();
			shieldPowerUp();
		}
	}

	private void projectilePowerUp(){
		if (projectilePowerUpTime % 12 == 0){
			projectiles.add(new Projectile(shipX, shipY));
			projectiles.add(new Projectile(shipX+12, shipY));
			projectiles.add(new Projectile(shipX+24, shipY));
		}
		projectilePowerUpTime++;
		if (projectilePowerUpTime >= 200){
			projectilePowerUp.setCollected(false);
			projectilePowerUpTime = 0;
		}
	}

	private void shieldPowerUp(){
		if (time/100 < 59){
			shield = new Rectangle(shipX-10, shipY-10, 50, 50);
			shieldPowerUpTime++;
			for (int i = 0; i < asteroids.size(); i++){
				if (enemyRectangles.get(i).intersects(shield)){
					removeAsteroid(i);
					shieldPowerUp.setCollected(false);
					shield = new Rectangle(500, 700, 50, 50);
					shieldPowerUpTime = 0;
				}
			}
			if (shieldPowerUpTime > 850){
				shieldPowerUp.setCollected(false);
				shield = new Rectangle(500, 700, 50, 50);
				shieldPowerUpTime = 0;
			}
		}
	}

	private void generateNewAsteroid(){
		int random = (int)(Math.random()*65)+1;
		int value = 1;
		if (random == value){
			asteroids.add(new Asteroid(this));
			enemyRectangles.add(new Rectangle(asteroids.get(asteroids.size()-1).getAsteroidX(), asteroids.get(asteroids.size()-1).getAsteroidY(), 30, 30));
		}
	}

	private void updateAsteroidLocation(){
		for (int i = 0; i < asteroids.size(); i++){
			asteroids.get(i).updateAsteroid();
		}
	}

	private void generateProjectilePowerUp(){
		int random = (int)(Math.random()*230)+1;
		int value = 1;
		if (random == value && projectilePowerUp.isOffScreen() == true && projectilePowerUp.isCollected() == false){
			projectilePowerUp = new ProjectilePowerUp(this);
			projectilePowerUpRectangle = new Rectangle(projectilePowerUp.getProjectilePowerUpX(), projectilePowerUp.getProjectilePowerUpY(), 10, 10);
		}
	}
	private void updateProjectilePowerUpLocation(){
		projectilePowerUp.updateProjectilePowerUp();
	}

	private void generateShieldPowerUp(){
		int random = (int)(Math.random()*230)+1;
		int value = 1;
		if (random == value && shieldPowerUp.isOffScreen() == true && shieldPowerUp.isCollected() == false){
			shieldPowerUp = new ShieldPowerUp(this);
			shieldPowerUpRectangle = new Rectangle(shieldPowerUp.getShieldPowerUpX(), shieldPowerUp.getShieldPowerUpY(), 10, 10);
		}
	}

	private void updateShieldPowerUpLocation(){
		shieldPowerUp.updateShieldPowerUp();
	}

	private void checkProjectileCollisions(){
		for (int i = 0; i < asteroids.size(); i++){
			for (int j = 0; j < projectiles.size(); j++){
				if (projectiles.get(j).getYPosition() < 0){
					projectiles.remove(j);
				}else if (asteroids.size() != i && new Rectangle(projectiles.get(j).getXPosition(), projectiles.get(j).getYPosition(), 6, 6).intersects(enemyRectangles.get(i))){
					projectiles.remove(j);
					removeAsteroid(i);
					asteroidsHit++;
					frame.repaint();
				}
			}
		}
	}

	private void updateProjectiles(){
		if (projectiles.size() > 0){
			for (int i = 0; i < projectiles.size(); i++){
				projectiles.get(i).updateProjectilePosition();
			}
		}
	}

	private void updateScreen(){
		checkForAsteroidCollisions();
		updateAsteroidLocation();
		generateNewAsteroid();
		checkProjectileCollisions();
		updateProjectiles();
		checkForProjectilePowerUpCollision();
		updateProjectilePowerUpLocation();
		generateProjectilePowerUp();
		if(projectilePowerUp.isCollected() == true)
			projectilePowerUp();
		checkForShieldPowerUpCollision();
		updateShieldPowerUpLocation();
		generateShieldPowerUp();
		if (shieldPowerUp.isCollected() == true)
			shieldPowerUp();
		movement();
	}

	private void movement(){
		playerRectangle = new Rectangle(shipX, shipY, 30, 30);
		if (shipX >= frame.getWidth()-45)
			shipX = 354;
		else if (shipX <= 0)
			shipX = 1;
		else
			shipX += velX;

		if (shipY >= frame.getHeight()-70)
			shipY = 529;
		else if (shipY <= 0)
			shipY = 1;
		else
			shipY += velY;
	}

	private void removeAsteroid(int index){
		asteroids.get(index).setDestroyed(true);
		asteroids.remove(index);
		enemyRectangles.remove(index);
	}

	private void removeProjectilePowerUp(){
		projectilePowerUp.setCollected(true);
		projectilePowerUp.setProjectilePowerUpY(frame.getHeight()+1);
		projectilePowerUp.setOffScreen(true);
	}

	private void removeShieldPowerUp(){
		shieldPowerUp.setCollected(true);
		shieldPowerUp.setShieldPowerUpY(frame.getHeight()+1);
		shieldPowerUp.setOffScreen(true);
	}

	private void drawShip(Graphics graphics){
		int[] x = {shipX, shipX+2, shipX+2, shipX+12, shipX+13, shipX+14, shipX+15, shipX+16, shipX+17, shipX+18, shipX+28, shipX+28, shipX+30, shipX+30, shipX+28, shipX+28, shipX+18, shipX+17, shipX+16, shipX+15, shipX+14, shipX+13, shipX+12, shipX+2, shipX+2, shipX};
		int[] y = {shipY, shipY, shipY+13, shipY+7, shipY+5, shipY+3, shipY+3, shipY+3, shipY+5, shipY+7, shipY+13, shipY, shipY, shipY+30, shipY+30, shipY+17, shipY+23, shipY+25, shipY+27, shipY+27, shipY+27, shipY+25, shipY+23, shipY+17, shipY+30, shipY+30};
		if (lives == 3)
			graphics.setColor(Color.GREEN);
		else if (lives == 2)
			graphics.setColor(Color.YELLOW);
		else
			graphics.setColor(Color.RED);
		graphics.fillPolygon(x, y, 26);
	}

	private void drawAsteroids(Graphics graphics){
		for (int i = 0; i < asteroids.size(); i++){
			if (!asteroids.get(i).isDestroyed()){
				graphics.setColor(Color.GRAY);
				graphics.fillOval(asteroids.get(i).getAsteroidX(), asteroids.get(i).getAsteroidY(), 30, 30);
				updateEnemyRectangles();
			}
		}
	}

	private void drawProjectilePowerUp(Graphics graphics){
		if (!projectilePowerUp.isCollected()){
			graphics.setColor(Color.YELLOW);
			graphics.fillOval(projectilePowerUp.getProjectilePowerUpX(), projectilePowerUp.getProjectilePowerUpY(), 10, 10);
			updateProjectilePowerUpRectangle();
		}
	}

	private void drawShieldPowerUp(Graphics graphics){
		if (!shieldPowerUp.isCollected()){
			graphics.setColor(Color.BLUE);
			graphics.fillOval(shieldPowerUp.getShieldPowerUpX(), shieldPowerUp.getShieldPowerUpY(), 10, 10);
			updateShieldPowerUpRectangle();
		}
	}

	private void drawShield(Graphics graphics){
		if(shieldPowerUp.isCollected()){
			graphics.setColor(Color.CYAN);
			graphics.drawOval((int)shield.getX(), (int)shield.getY(), 50, 50);
		}
	}

	private void drawProjectiles(Graphics graphics){
		graphics.setColor(Color.CYAN);
		for (int i = 0; i < projectiles.size(); i++){
			graphics.fillRect(projectiles.get(i).getXPosition(), projectiles.get(i).getYPosition(), 6, 6);
		}
	}

	private void setEndScreenText(Graphics graphics, String str){
		graphics.setColor(Color.PINK);
		graphics.drawString(str, 100, 300);
	}

	private void setGameOver(Graphics graphics){
		if (lives <= 0)
			setEndScreenText(graphics, "ALL LIVES, LOST, YOU LOSE!");
		else if (time >= 0 && asteroids.size() == 0)
			setEndScreenText(graphics, "ALL ASTEROIDS DESTROYED, YOU WIN!");
		else if (time <= 0 && asteroids.size() > 0)
			setEndScreenText(graphics, "OUT OF TIME, YOU LOSE!");
	}

	protected void paintComponent(Graphics graphics){
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		graphics.setColor(Color.WHITE);
		//for (int i = 0; i < 100; i++)
		//	graphics.fillRect((int)(Math.random()*401), (int)(Math.random()*601), 1, 1);

		graphics.drawString("Asteroids Hit: " + Integer.toString(asteroidsHit), 5, 30);

		graphics.drawString("Time Left: " + Integer.toString(time/100), 5, 15);

		if (!gameOver){
			drawShip(graphics);
			drawAsteroids(graphics);
			drawProjectiles(graphics);
			drawProjectilePowerUp(graphics);
			drawShieldPowerUp(graphics);
			drawShield(graphics);
		}

		if (time == 0 || lives == 0 || (time/100 < 10 && asteroids.size() == 0)){
			gameOver = true;
			setGameOver(graphics);
		}
	}
}
