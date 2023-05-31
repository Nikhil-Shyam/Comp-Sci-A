import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.Rectangle;
import javax.swing.JFrame;
//import java.awt.event.KeyEvent;
import java.awt.Graphics;
//import java.awt.event.KeyAdapter;
//import java.awt.event.ActionEvent;
//import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame{
	private int shipX;
	private int shipY;
	private int time;
	private int lives;
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
        asteroids = new ArrayList<>();
        projectiles = new ArrayList<>();
        enemyRectangles = new ArrayList<>();
        shipX = 100;
        shipY = 200;
        playerRectangle = new Rectangle(100, 200, 30, 30);

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
					repaint();
				}
            }
        });
        timer.start();
    }

    public void updateEnemyRectangles(){

	}

	public void handleKeyPress(KeyEvent event){

	}

	public void shoot(){

	}

	public void checkForAsteroidCollisions(){

	}

	public void generateNewAsteroid(){

	}

	public void updateAsteroidLocation(){

	}

	public void checkProjectileCollisions(){

	}

	public void updateProjectiles(){

	}

	public void updateScreen(){

	}

	public void removeAsteroid(int index){

	}

	public void drawShip(Graphics graphics){

	}

	public void drawAsteroids(Graphics graphics){

	}

	public void drawProjectiles(Graphics graphics){

	}

	public void setEndScreenText(Graphics graphics, String str){

	}

	public void setGameOver(Graphics graphics){

	}

	public void paintComponent(Graphics graphics){

	}
}
