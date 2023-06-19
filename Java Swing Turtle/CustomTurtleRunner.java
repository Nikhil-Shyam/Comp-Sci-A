import java.util.*;
import java.awt.*;

public class CustomTurtleRunner
{
  public static void main(String[] args)
  {
      World world1 = new World(400,400);

      // 1. Change the constructor call below to create a large
      // 150x200 CustomTurtle with a green body (Color.green)
      // and a blue shell (Color.blue) at position (150,300).
      // Move it forward to see it.
      CustomTurtle turtle1 = new CustomTurtle(world1);
      turtle1.forward();


      // 2. Create a small 25x50 CustomTurtle with a red body
      // and a yellow shell at position (350,200)
      // Move it forward to see it.


      // 3. Create a CustomTurtle of your own design

      world1.show(true);
  }
}
