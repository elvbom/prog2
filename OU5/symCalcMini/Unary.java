/**
 * Base class for unaries (i.e. functions and unary operators)
 */
public abstract class Unary 
  extends Sexpr
{
  protected Sexpr operand;
  
  public Unary(Sexpr operand) {
    this.operand = operand;
  }
  
  public int priority() {
    return 80;
  }
  
  public String toString() {
    return getName() + "(" + operand + ")";
  }
  
}
  