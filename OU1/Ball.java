import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*** 
  * Represents a ball object. 
  * The object has get-methods and a move-method.
  * The position and speed of the ball is represented
  * by two vectors.
***/

public class Ball {
  private Vector posVec;
  private Vector speedVec;
  private int r;
  private Color c;
  private Box h;
  
  public Ball(Box h, int winSize) {
    this.h = h;
    posVec = new Vector((double)(Math.random()*winSize), 
                        (double)(Math.random()*winSize));
    speedVec = new Vector((double)(Math.random()*100), 
                          (double)(Math.random()*100));
    r = 10;
    c = new Color((float)Math.random(),
                  (float)Math.random(),
                  (float)Math.random());
  }
  
  public void move() {
    posVec = posVec.add(speedVec);
    if (posVec.getY() > h.getHeight()) {
      posVec = new Vector(posVec.getX(), (double)h.getHeight());
    }
    speedVec = new Vector(speedVec.getX(), speedVec.getY() + 1);
    if (posVec.getY() > h.getHeight()-r && speedVec.getY() > 0) {
      speedVec = speedVec.flipSignY();
      speedVec = speedVec.add(new Vector(0, 3));
    }
    if (posVec.getY() < r && speedVec.getY() < 0) {
      speedVec = speedVec.flipSignY();
    }
    if (posVec.getX() < r && speedVec.getX() < 0 ||
        posVec.getX() > h.getWidth()-r && speedVec.getX() > 0) {
      speedVec = speedVec.flipSignX();
    }
  }
  
  public int getRadius() {
    return r;
  }
  
  public void setRadius(int r) {
    this.r = r;
  }
  
  public double getX() {
    return posVec.getX();
  }
  
  public double getY() {
    return posVec.getY();
  }
  
  public void paint(Graphics g) {
    g.setColor(c);
    g.fillOval((int)posVec.getX()-r, (int)posVec.getY()-r, 2*r, 2*r);
  }
}
