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
import java.awt.event.ActionEvent;
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

    public Game(JFrame frame){
        this.frame = frame;
        asteroids = new ArrayList<Asteroid>();
        projectiles = new ArrayList<Projectile>();
        enemyRectangles = new ArrayList<Rectangle>();
        shipX = 200;
        shipY = 500;
        playerRectangle = new Rectangle(shipX, shipY, 30, 30);

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
                time--;
                if (!gameOver){
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

	private void handleKeyPress(KeyEvent event){
        if(event.getKeyCode() == 38)
			velY = -2;

        if (event.getKeyCode() == 40)
			velY = 2;

        if (event.getKeyCode() == 37)
			velX = -2;

        if (event.getKeyCode() == 39)
			velX = 2;

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

	private void generateNewAsteroid(){
		int random = (int)(Math.random()*76)+1;
		int value = 5;
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
		if (time >= 0 && asteroids.size() == 0)
			setEndScreenText(graphics, "ALL ASTEROIDS DESTROYED, YOU WIN!");
		else if (lives <= 0)
			setEndScreenText(graphics, "ALL LIVES, LOST, YOU LOSE!");
		else if (time <= 0 && asteroids.size() > 0)
			setEndScreenText(graphics, "OUT OF TIME, YOU LOSE!");
	}

	protected void paintComponent(Graphics graphics){
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		graphics.setColor(Color.WHITE);
		for (int i = 0; i < 100; i++)
			graphics.fillRect((int)(Math.random()*356), (int)(Math.random()*526)+5, 1, 1);

		graphics.drawString("Asteroids Hit: " + Integer.toString(asteroidsHit), 5, 30);

		graphics.drawString("Time Left: " + Integer.toString(time/100), 5, 15);

		if (!gameOver){
			drawShip(graphics);
			drawAsteroids(graphics);
			drawProjectiles(graphics);
		}

		if (time == 0 || lives == 0 || (time/100 < 15 && asteroids.size() == 0)){
			gameOver = true;
			setGameOver(graphics);
		}
	}
}
