import java.awt.Color;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////

  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture)
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }

  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y,
                 ModelDisplay modelDisplayer)
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }

  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay)
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }

  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }

  /////////////////// methods ///////////////////////


  public static void main(String[] args)
  {
    World earth = new World(800, 800);

	/*
    Turtle t1 = new Turtle(earth);
    t1.penUp();
    t1.backward();

    Turtle t2 = new Turtle(earth);

    Turtle t3 = new Turtle(earth);
    //put in position
    t3.penUp();
    t3.turnLeft();
    t3.forward();
    t3.turnRight();
    //big square
    t3.penDown();
    t3.forward(200);
    t3.turnLeft();
    t3.forward(200);
    t3.turnLeft();
    t3.forward(200);
    t3.turnLeft();
    t3.forward(200);
    ///put in position
    t3.penUp();
    t3.forward(200);
    //small square
    t3.penDown();
    t3.forward();
    t3.turnLeft();
    t3.forward();
    t3.turnLeft();
    t3.forward();
    t3.turnLeft();
    t3.forward();
    //put in position
    t3.penUp();
    t3.turnRight();
    t3.forward();
    t3.turnRight();
    t3.forward();

	Turtle t4 = null; //placeholder
	t4 = new Turtle(200, 200, earth);
	t4.forward();


	CustomTurtle t5 = new CustomTurtle(earth, Color.RED, Color.MAGENTA, 100, 100);
	CustomTurtle t6 = new CustomTurtle(150, 300, earth, Color.green, Color.blue, 150, 300);
	CustomTurtle t7 = new CustomTurtle(350, 200, earth, Color.red, Color.yellow, 25, 50);
	CustomTurtle t8 = new CustomTurtle(600, 600, earth, Color.lightGray, Color.darkGray, 25, 35);
	*/

	Turtle t9 = new Turtle(earth);
	t9.setColor(Color.BLACK);
	t9.forward();
	t9.turnRight();
	t9.forward();
	t9.turnRight();
	t9.forward();
	t9.turnRight();
	t9.forward();
	t9.turnRight();
	t9.turnRight();
	t9.penUp();

	t9.setColor(Color.MAGENTA);
	t9.forward(35);
	t9.turnLeft();
	t9.penDown();
	t9.forward(45);
	t9.turnRight();
	t9.forward(30);
	t9.turnRight();
	t9.forward(45);
	t9.turnRight();
	t9.penUp();
	t9.forward(30);

	t9.setColor(Color.BLUE);
	t9.turnRight();
	t9.forward(60);
	t9.penDown();
	t9.forward(20);
	t9.turnLeft();
	t9.forward(20);
	t9.turnLeft();
	t9.forward(20);
	t9.turnLeft();
	t9.forward(20);
	t9.penUp();
	t9.forward(30);
	t9.penDown();
	t9.forward(20);
	t9.turnLeft();
	t9.forward(20);
	t9.turnLeft();
	t9.forward(20);
	t9.turnLeft();
	t9.forward(20);
	t9.penUp();

	t9.setColor(Color.RED);
	t9.turnRight();
	t9.turnRight();
	t9.forward(40);
	t9.turnRight();
	t9.forward(35);
	t9.turnLeft();
	t9.turn(-45.0);
	t9.penDown();
	t9.forward(71);
	t9.turn(-90.0);
	t9.forward(71);
	t9.turn(45.0);
	t9.penUp();
	t9.forward();

	t9.moveTo((int)(Math.random()*801), (int)(Math.random()*801));
	System.out.println("Red turtle distance from (0, 0): " + (int)(t9.getDistance(0,0)));

	Turtle t10 = new Turtle(earth);
	t10.penUp();
	t10.moveTo((int)(Math.random()*801), (int)(Math.random()*801));
	System.out.println("Red turtle distance from Blue turtle distance: " + (int)(t9.getDistance(t10.getXPos(),t10.getYPos())));

  }

} // this } is the end of class Turtle, put all new methods before this