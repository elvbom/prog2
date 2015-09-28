/**
 * Base class for all binary operators
 */
public abstract class Binary 
  extends Sexpr
{
  protected Sexpr left;
  protected Sexpr right;
  
  public Binary(Sexpr left, Sexpr right) {
    this.left = left;
    this.right = right;
  }
  
  /* 
   * The toString-method should be refined so that parentheses are used only when needed
   */
  public String toString() {
    return "(" + left + ")" + getName() + "(" + right + ")"; 
  }
}
  