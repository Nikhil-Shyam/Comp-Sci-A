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
	private int time = Integer.MAX_VALUE;
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
        if(event.getKeyCode() == 38 && shipY > 0)
			velY = -2;

        if (event.getKeyCode() == 40 && shipY < frame.getHeight()-75)
			velY = 2;

        if (event.getKeyCode() == 37 && shipX > 0)
			velX = -2;

        if (event.getKeyCode() == 39 && shipX < frame.getWidth()-45)
			//velX = 2;

        if (event.getKeyCode() == 32){
			shoot();
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT){
			velX = 2;
			System.out.println("hi");
		}else{
			System.out.println("bye");
			velX = 0;
		}
	}

	private void shoot(){
        projectiles.add(new Projectile(shipX+15, shipY));
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
		int random = (int)(Math.random()*50)+1;
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
				}else if (new Rectangle(projectiles.get(j).getXPosition(), projectiles.get(j).getYPosition(), 6, 6).intersects(enemyRectangles.get(i))){
					projectiles.remove(j);
					removeAsteroid(i);
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
		shipX += velX;
		shipY += velY;
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
