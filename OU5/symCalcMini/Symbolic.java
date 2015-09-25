/**
 * Methods for symbolic arithmetic.
 */
public class Symbolic {
 
  /**
   * Perform a symbolic/numeric addition
   * Note: The method should be elaborated to handle
   * handle several special cases (e.g addititon of zero)
   */
  public static Sexpr add(Sexpr left, Sexpr right) {
    if (left.isConstant() && right.isConstant())
      return new Constant(left.getValue()+ right.getValue());
    else
      return new Addition(left, right);
  }
  
  /**
   * Perform a symbolic/numeric multiplication
   * Note: The method should be elaborated to handle several
   * special cases (e.g multiplication with zero or one)
   */
  public static Sexpr mul(Sexpr left, Sexpr right) {
    if (left.isConstant() && right.isConstant())
      return new Constant(left.getValue() * right.getValue());
    else
      return new Multiplication(left, right);
  }
  
  /**
   * Perform a symbolic/numeric negation
   */  
  public static Sexpr negate(Sexpr operand) {
   if (operand.isConstant())
     return new Constant(-operand.getValue());
   else
     return new Negation(operand);
  }
   
}