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
    String result;
    if (left.priority() < priority()) {
      result = "(" + left + ")";
    } else {
      result = left.toString();
    }
    if (right.priority() <= priority()) {
      result = result + getName() + 
      "(" + right + ")";
    } else {
      result = result + getName() + right;
    }
    return result;
  }

}
  