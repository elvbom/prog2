
import junit.framework.TestCase;

/**
 * J-Unit tests for the SpecialStack and StackPlay classes.
 * @author Johan Öfverstedt
 */
public class StackTest extends TestCase {
  @Override
  public void setUp() {
  }
  
  public void testConstructors() {
    SpecialStack s = new SpecialStack(5);
    assertEquals(1, s.pop());
    assertEquals(2, s.pop());
    assertEquals(3, s.pop());
    assertEquals(4, s.pop());
    assertEquals(5, s.pop());
    
    boolean threw = false;
    try {
      s.pop();
    } catch(RuntimeException e) {
      threw = true;
    }
    
    assertEquals(true, threw);
  }
  
  public void testPushAndPop() {
    SpecialStack s = new SpecialStack();
    
    s.push(7);
    s.push(5);
    s.push(3);
    s.push(2);
    
    assertEquals(2, s.pop());
    assertEquals(3, s.pop());
    assertEquals(5, s.pop());
    assertEquals(7, s.pop());
  }
  
  public void testExceptions() {
    boolean threw = false;
    SpecialStack s = new SpecialStack();
    try {
      s.push(1);
      s.push(2);
    } catch(RuntimeException e) {
      threw = true;
    }
    assertEquals(true, threw);
    
    threw = false;
          
    s = new SpecialStack();

    try {
      s.push(1);
      s.push(0);
      s.pop();
      s.pop();
    } catch(RuntimeException e) {
      threw = true;
    }
    
    assertEquals(false, threw);
    
    threw = false;
    
    s = new SpecialStack();
    
    try {
      s.push(1);
      s.pop();
      s.pop();
    } catch(RuntimeException e) {
      threw = true;
    }
    
    assertEquals(true, threw);
  }
  
  public void testToString() {
    SpecialStack s = new SpecialStack(5);
    
    assertEquals("[5, 4, 3, 2, 1]", s.toString());
  }
  
  public void testStackPlayMove() {
    int n = 7;
    
    SpecialStack from = new SpecialStack(n);
    SpecialStack to = new SpecialStack();
    SpecialStack help = new SpecialStack();
    
    long initialNumberOfCalls = StackPlay.getNumberOfCalls();
    StackPlay.move(from, to, help, n);
    
    long endNumberOfCalls = StackPlay.getNumberOfCalls();
    
    boolean threw = false;
    
    try {
      from.pop();
    } catch(RuntimeException e) {
      threw = true;
    }
    
    assertEquals(true, threw);
    
    threw = false;
    
     try {
      help.pop();
    } catch(RuntimeException e) {
      threw = true;
    }   
    
    assertEquals(true, threw);
    
    for(int i = 1; i < n; ++i) {
      assertEquals(i, to.pop());
    }
    
    assertEquals(255, endNumberOfCalls - initialNumberOfCalls);
  }
}