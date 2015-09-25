import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/***
  * Contains the box that the bouncing balls excist in.
  * BoxOfFrame has the timer that is controlling the movements
  * of the balls.
***/

public class BoxOfFrame extends JFrame implements ActionListener {
  private Box theBox;
  private Timer timer;
  
  public BoxOfFrame(int winSize, int numBalls, int delay) {
    theBox = new Box(winSize, numBalls);
    timer = new Timer(delay, this);
    add(theBox);
    pack();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    timer.start();
  }
  
  public void actionPerformed(ActionEvent e) {
    theBox.step();
  }
  
  public void stopTimer() {
    timer.stop();
  }
  
  public void startTimer() {
    timer.start();
  }
  
  public static void main(String[] args) { 
    BoxOfFrame hf = new BoxOfFrame(500, 5, 30);
  }
  
}