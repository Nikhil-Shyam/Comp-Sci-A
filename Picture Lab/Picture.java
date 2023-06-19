import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods //////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();

    for (Pixel[] rowArray : pixels)
     {
       for (Pixel p: rowArray)
       {
              p.setBlue(0);
       }
    }
  }

	public void keepOnlyBlue(){
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels)
		{
			for (Pixel p: rowArray)
			{
				p.setRed(0);
				p.setGreen(0);
			}
		}
	}

	public void switchColors(){
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels)
		{
			for (Pixel p: rowArray)
			{
				int temp = p.getRed();
				p.setRed(p.getGreen());
				p.setGreen(temp);
			}
		}
	}

	public void negate(){
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels)
		{
			for (Pixel p: rowArray)
			{
				p.setRed(255-p.getRed());
				p.setBlue(255-p.getBlue());
				p.setGreen(255-p.getGreen());
			}
		}
	}

	public void grayscale(){
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels)
		{
			for (Pixel p: rowArray)
			{
				int avg = (p.getRed()+p.getBlue()+p.getGreen())/3;
				p.setRed(avg);
				p.setBlue(avg);
				p.setGreen(avg);
			}
		}
	}

	public void mirrorVertical(){
		Pixel[][] pixels = this.getPixels2D();

		for (int i = 0; i < pixels.length; i++)
		{
			for (int j = pixels[i].length-1; j >= pixels[i].length/2; j--)
			{
				pixels[i][j].setRed(pixels[i][pixels[i].length-1-j].getRed());
				pixels[i][j].setGreen(pixels[i][pixels[i].length-1-j].getGreen());
				pixels[i][j].setBlue(pixels[i][pixels[i].length-1-j].getBlue());
			}
		}
	}

	public void mirrorVerticalRightToLeft(){
		Pixel[][] pixels = this.getPixels2D();

		for (int i = 0; i < pixels.length; i++)
		{
			for (int j = 0; j < pixels[i].length/2; j++)
			{
				pixels[i][j].setRed(pixels[i][pixels[i].length-1-j].getRed());
				pixels[i][j].setGreen(pixels[i][pixels[i].length-1-j].getGreen());
				pixels[i][j].setBlue(pixels[i][pixels[i].length-1-j].getBlue());
			}
		}
	}

	public void mirrorHorizontal(){
		Pixel[][] pixels = this.getPixels2D();

		for (int j = 0; j < pixels[0].length; j++)
		{
			int count = 0;
			for (int i = pixels.length-1; i >= pixels.length/2; i--)
			{
				pixels[i][j].setRed(pixels[count][j].getRed());
				pixels[i][j].setGreen(pixels[count][j].getGreen());
				pixels[i][j].setBlue(pixels[count][j].getBlue());
				count++;
			}
		}
	}

	public void mirrorHorizontalBotToTop(){
		Pixel[][] pixels = this.getPixels2D();

		for (int j = 0; j < pixels[0].length; j++)
		{
			int count = pixels.length-1;
			for (int i = 0; i < pixels.length/2; i++)
			{
				pixels[i][j].setRed(pixels[count][j].getRed());
				pixels[i][j].setGreen(pixels[count][j].getGreen());
				pixels[i][j].setBlue(pixels[count][j].getBlue());
				count--;
			}
		}
	}

	public void mirrorDiagonal(){
		Pixel[][] pixels = this.getPixels2D();

		for (int i = 0; i < pixels.length; i++)
		{
			for (int j = i; j < pixels[i].length; j++)
			{
				pixels[i][j].setRed(pixels[j][i].getRed());
				pixels[i][j].setGreen(pixels[j][i].getGreen());
				pixels[i][j].setBlue(pixels[j][i].getBlue());
			}
		}
	}

} // this } is the end of class Picture, put all new methods before this
