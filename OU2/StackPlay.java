import java.util.*;

public class StackPlay {
   private long move;
   private ArrayList<Integer> stack;
   
   /**
    * Returns the current number of times the method move
    * has been called
    * @return the number of calls
    */
   public static long getNumberOfCalls() {
     return 0;
     //return move;
   }
   
   /**
    * Moves numbers from one stack to another using
    * the push and pop methods and a third help stack.
    * @param from the source stack
    * @param to the destination stack
    * @param help the help stack
    * @param n the number of integers to be moved
    */
   
   public static void move(SpecialStack from, 
                           SpecialStack to, 
                           SpecialStack help, 
                           int n) 
   {
      //move = move + 1; 
   }
   
   
   public static void main(String[] args) 
   {
      int size = 3;
      SpecialStack from = new SpecialStack(size);
      SpecialStack to = new SpecialStack();
      SpecialStack help = new SpecialStack();
      System.out.println("Start state");
      System.out.println("   From: " + from);
      System.out.println("   To:   " + to);
      System.out.println("   Help: " + help);
      //System.out.println("   Number of calls: " + getNumberOfCalls());
      //move(from, to, help, size);
      System.out.println("End state");
      System.out.println("   From: " + from);
      System.out.println("   To:   " + to);
      System.out.println("   Help: " + help);
      //System.out.println("   Number of calls: " + getNumberOfCalls());
   }
}