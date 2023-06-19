import java.util.*;
import java.awt.*;

public class DancingTurtles
{
	public static void main(String[] args)
	{

		World world = new World(500,400);
		Turtle yertle = new Turtle(world);
		Thread thread = new Thread();

		// This is a loop that runs 10 times (you will learn to write loops in Unit 4)
		for(int i=Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++)
		{
			// We want our turtle to move throughout our World which has a width of 500px.
			// Since the turtle has a width of 20 pxs, we will need to account for this
			// so it doesn't get cut off at the edges. We do this by adjusting the range
			// from 0-500 to 20-480.
			int randomX = (int)(Math.random()*461)+20;
			// Create a random range for the y coordinate of the turtle.
			// Adjust for the 20 pixel height of the turtle
			// so it doesn't get cut off at the edges!
			int randomY = (int)(Math.random()*461)+20;

			yertle.moveTo(randomX, randomY);
			yertle.turnRight();

			// Can you choose a random red, green, and blue value between 0-255?
			int randomR = (int)(Math.random()*256);
			int randomG = (int)(Math.random()*256);
			int randomB = (int)(Math.random()*256);

			yertle.setColor(new Color(randomR, randomG, randomB));

			//CS Topic concept [try/catch], not required in AP CSA
			try{
				thread.sleep(0);
			}catch(InterruptedException e){}

		} // end of loop
		world.show(true);
	}
}
