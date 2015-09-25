import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

/*** 
  * Sets the variables (window size, number of balls and delay) 
  * through gui and creates a BoxOfFrame-object for the bouncing balls to exist in.
  * The user can start, stop, run and quit the bouncing balls via the SetVariables-gui
  ***/

class SetVariables extends JFrame implements ActionListener {
  private JLabel winSizeL = new JLabel();
  private JLabel numBallsL = new JLabel();
  private JLabel delayL = new JLabel();
  JTextField winSizeT = new JTextField("500");
  JTextField numBallsT = new JTextField("5");
  JTextField delayT = new JTextField("30");
  private JButton startB = new JButton("Start");
  private JButton stopB = new JButton("Stop");
  private JButton quitB = new JButton("Quit");
  private JButton runB = new JButton("Run");
  BoxOfFrame hf = null;
  
  public SetVariables() {
    startB.addActionListener(this);
    stopB.addActionListener(this);
    quitB.addActionListener(this);
    runB.addActionListener(this);
    
    winSizeL.setFont(new Font("Sans Serif", Font.BOLD, 12));
    winSizeL.setText("Window size");
    numBallsL.setFont(new Font("Sans Serif", Font.BOLD, 12));
    numBallsL.setText("Number of balls");
    delayL.setFont(new Font("Sans Serif", Font.BOLD, 12));
    delayL.setText("Delay");
    
    JPanel varPart = new JPanel(new GridLayout(3, 2));
    varPart.add(winSizeL);
    varPart.add(winSizeT);
    varPart.add(numBallsL);
    varPart.add(numBallsT);
    varPart.add(delayL);
    varPart.add(delayT);
    
    JPanel buttonsPart = new JPanel(new GridLayout(2, 2));
    buttonsPart.add(startB);
    buttonsPart.add(runB);
    buttonsPart.add(stopB);
    buttonsPart.add(quitB);
    
    JPanel winPart = new JPanel(new GridLayout(2, 1));
    winPart.add(varPart);
    winPart.add(buttonsPart);
    
    this.setLayout(new FlowLayout());
    this.add(winPart);
    this.setPreferredSize(new Dimension(400,200));
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    Scanner winSizeS = new Scanner(winSizeT.getText());
    Scanner numBallsS = new Scanner(numBallsT.getText());
    Scanner delayS = new Scanner(delayT.getText());
    if (winSizeS.hasNextInt() && numBallsS.hasNextInt() && delayS.hasNextInt()) {
      if (e.getSource() == startB) {
        if (hf == null) {
          int winSize = winSizeS.nextInt();
          int numBalls = numBallsS.nextInt();
          int delay = delayS.nextInt();
          hf = new BoxOfFrame(winSize, numBalls, delay);
        } else {
          JOptionPane.showMessageDialog(null, "Bouncing balls already started"); 
        }
      } else if (e.getSource() == stopB) {
        hf.stopTimer();
      } else if (e.getSource() == runB) {
        hf.startTimer();
      } else if (e.getSource() == quitB) {
        JOptionPane.showMessageDialog(null, "Quitting program"); 
        System.exit(0);
      } else {
        JOptionPane.showMessageDialog(null, "Error!"); 
      }
    }
  }
  
  public static void main(String[] args) {
    SetVariables sv = new SetVariables(); 
  }
  
}