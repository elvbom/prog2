import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

/*** 
  * Represents a box object. 
  * The box creates and contains the bouncing balls, which moves are orchestrated
  * by the step-method. When two balls collide one is annihilated and the other one's
  * radius is increased by the annihilated balls radius.
***/

public class Box extends JPanel {
  private ArrayList<Ball> balls;
  
  public Box(int winSize, int numBalls) { 
    balls = new ArrayList<Ball>();
    int i;
    for (i = 0; i < numBalls; i++) {
      balls.add(new Ball(this, winSize));
    }
    this.setPreferredSize(new Dimension(winSize, winSize));  
    this.setBackground(Color.white);
  }
  
   public void paintComponent(Graphics g) {
    int i;
    super.paintComponent(g);
    for (i = 0; i < balls.size(); i++) {
      Ball b = balls.get(i);
      b.paint(g);
    }
  }
  
  public void step() {
    int i;
    for (i = 0; i < balls.size(); i++) {
      Ball b = balls.get(i);
      b.move();
    }
    repaint();
    for (i = 0; i < balls.size(); i++) {
      Ball b = balls.get(i);
      int j;
      for (j = i + 1; j < balls.size(); j++) {
        Ball b2 = balls.get(j);
        double xDist = b.getX() - b2.getX();
        double yDist = b.getY() - b2.getY();
        double distSquared = xDist*xDist + yDist*yDist;
          if (b != b2 && distSquared <= ((b.getRadius() + b2.getRadius())*(b.getRadius() + b2.getRadius()))) {
            b.setRadius(b.getRadius() + b2.getRadius());
            balls.remove(b2);
        }
      }
    }
  }     
}
