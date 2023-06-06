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
	private int time = 60;
	private int lives = 3;
	private int asteroidsHit;
	private boolean gameOver;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Rectangle> enemyRectangles;
	private Rectangle playerRectangle;
	private Timer timer;
	private JFrame frame;

    public Game(JFrame frame){
        this.frame = frame;
        asteroids = new ArrayList<Asteroid>();
        projectiles = new ArrayList<Projectile>();
        enemyRectangles = new ArrayList<Rectangle>();
        shipX = 100;
        shipY = 100;
        playerRectangle = new Rectangle(shipX, shipY, 30, 30);

        setFocusable(true);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent event){
                handleKeyPress(event);
            }
        });

        timer = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
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
        if(event.getKeyCode() == 38 && shipY > frame.getHeight())
            shipY--;
        if (event.getKeyCode() == 40 && shipY < frame.getHeight())
            shipY++;
        if (event.getKeyCode() == 37 && shipX > frame.getWidth())
            shipX--;
        if (event.getKeyCode() == 39 && shipX < frame.getWidth())
            shipX++;
        if (event.getKeyCode() == 32)
            shoot();

	}

	private void shoot(){
        projectiles.add(new Projectile(shipX/2, shipY/2));
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
		int random = (int)(Math.random()*10)+1;
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

	}

	private void updateProjectiles(){
		for (int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).updateProjectilePosition();
		}
	}

	private void updateScreen(){
		checkForAsteroidCollisions();
		updateAsteroidLocation();
		generateNewAsteroid();
		checkProjectileCollisions();
		updateProjectiles();
	}

	private void removeAsteroid(int index){
		asteroids.get(index).setDestroyed(true);
		asteroids.remove(index);
		enemyRectangles.remove(index);
	}

	private void drawShip(Graphics graphics){
		int[] x = {shipX, shipX+30, shipX+30, shipX};
		int[] y = {shipY, shipY, shipY+30, shipY+30};
		if (lives == 3)
			graphics.setColor(Color.GREEN);
		else if (lives == 2)
			graphics.setColor(Color.YELLOW);
		else
			graphics.setColor(Color.RED);
		graphics.fillPolygon(x, y, 4);
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
		graphics.drawString(str, 100, 100);
	}

	private void setGameOver(Graphics graphics){
		if (time <= 0 && asteroids.size() == 0)
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
		graphics.drawString(Integer.toString(asteroidsHit), 100, 200);

		graphics.setColor(Color.BLACK);
		graphics.drawString(Integer.toString(time), 100, 250);

		if (!gameOver){
			drawShip(graphics);
			drawAsteroids(graphics);
			drawProjectiles(graphics);
			time--;
		}

		if (time == 0 || lives == 0){
			gameOver = true;
			setGameOver(graphics);
		}
	}
}
