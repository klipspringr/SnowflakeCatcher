SnowFlake [] billy;
void setup()
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
void draw()
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
void mouseDragged()
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
		stroke(177, 232, 242);
		fill(177,232, 242);
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
  void show()
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
  void lookDown()
  {
    if (get(x, y+7) != color(0)&& y > 0 && y < 593)
    {
    	isMoving = false;
    }else
    {
    	isMoving = true;
    }
  }
  void base()
  {
    fill(0);
    ellipse(x, y, 12, 12);
  }
  void move()
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
  void wrap()
  {
    if(y >= 600)
    {
    	y = 0;
    	x = ((int)(random(0, 600)));
    	opacity = 255;
    }
  }
}


