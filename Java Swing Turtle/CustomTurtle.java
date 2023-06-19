import java.util.*;
import java.awt.*;
public class CustomTurtle extends Turtle
{
   private int x;
   private int y;
   private World w;
   private Color bodycolor;
   private Color shellcolor;
   private int width;
   private int height;

 /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model or world
   */
  public CustomTurtle(ModelDisplay modelDisplay)
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }

  /** Constructor that takes the model
   * display to draw it on and custom colors and size
   * @param m the world
   * @param body : the body color
   * @param shell : the shell color
   * @param w: width
   * @param h: height
   */
  public CustomTurtle(ModelDisplay m, Color body, Color shell, int w, int h)
  {
    // let the parent constructor handle it
    super(m);
    bodycolor = body;
    setBodyColor(body);
    shellcolor = shell;
    setShellColor(shell);
    height = h;
    width = w;
    setHeight(h);
    setWidth(w);
  }

/** Constructor that takes the x and y and a model
   * display to draw it on and custom colors and size
   * @param x the starting x position
   * @param y the starting y position
   * @param m the world
   * @param body : the body color
   * @param shell : the shell color
   * @param w: width
   * @param h: height
   */
  public CustomTurtle(int x, int y, ModelDisplay m,  Color body, Color shell, int w, int h)
  {
    // let the parent constructor handle it
    super(x,y,m);
    bodycolor = body;
    setBodyColor(body);
    shellcolor = shell;
    setShellColor(shell);
    height = h;
    width = w;
    setHeight(h);
    setWidth(w);
  }
}
