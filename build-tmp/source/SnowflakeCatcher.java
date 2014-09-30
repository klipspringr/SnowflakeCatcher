import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] billy;
public void setup()
{
  size(600,600);
  frameRate(200);
  background(0);
  billy = new SnowFlake[130];
  for (int i = 0; i < billy.length; i++)
 	{
 		billy[i] = new SnowFlake();
 	}
}
public void draw()
{

	
	for (int i = 0; i < billy.length; i++)
 	{
	 	billy[i].base();
	 	billy[i].lookDown();
	 	billy[i].move();
	 	billy[i].wrap();
	 	//background(0, 240, 64);
	 	billy[i].show();
 	}

}
public void mouseDragged()
{
	
	if (mouseButton == RIGHT)
	{
		fill(0);
		stroke(0);
    	ellipse(pmouseX, pmouseY, 25, 25);
	}
	else {
		int touchX = pmouseX;
		int touchY = pmouseY;
		boolean redC = true;
		stroke(28, 176, 40);
		fill(28, 176, 40);
		redC = true;
		ellipse(touchX,touchY,15,15);
		stroke(0);
	}
}

class SnowFlake
{
  int x, y, opacity;
  boolean isMoving;
  SnowFlake()
  {
    x = ((int)(random(0, 600)));
    y = ((int)(random(0, 600)));
    isMoving = true;
    opacity = 255;
  }
  public void show()
  {

    fill(255,opacity);
    stroke(0);
    ellipse(x, y, 7, 7) ;
    stroke(255, opacity);
    line(x - 4, y - 4, x + 4, y + 4); //diagonal top left
	line(x, y + 5, x, y - 5); //perpendicular
	line(x + 5, y, x - 5, y); //horizontal
	line(x - 4, y +4, x+4, y-4);
	stroke(0);
}
  public void lookDown()
  {
    if (get(x, y+7) != color(0)&& y > 0 && y < 593)
    {
    	isMoving = false;
    }else
    {
    	isMoving = true;
    }
  }
  public void base()
  {
    fill(0);
    ellipse(x, y, 12, 12);
  }
  public void move()
  {
    if (isMoving == true)
    {
    	y++;
    }else
    {
    	if (opacity > 0)
    	{
    		opacity --;
    	}
	
    }
  }
  public void wrap()
  {
    if(y >= 600)
    {
    	y = 0;
    	x = ((int)(random(0, 600)));
    	opacity = 255;
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
