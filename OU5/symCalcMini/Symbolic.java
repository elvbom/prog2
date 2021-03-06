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
    if (left.isConstant() && right.isConstant()) {
      return new Constant(left.getValue() + right.getValue());
    }
    else {
      if(left.equals(right))
        return new Multiplication(new Constant(2), left);
      else if(left.isConstant() || right.isConstant()) {
        if(left.isConstant()) {
          if(left.getValue() == 0)
            return right;      
        }
        if(right.isConstant()) {
          if(right.getValue() == 0)
            return left;
        }
      }
      else
        return new Addition(left, right);
    }
    return new Addition(left, right);
  }
  
  
  
  /**
   * Perform a symbolic/numeric addition
   * Note: The method should be elaborated to handle
   * handle several special cases (e.g addititon of zero)
   */
  public static Sexpr sub(Sexpr left, Sexpr right) {
    if (left.isConstant() && right.isConstant())
      return new Constant(left.getValue()- right.getValue());
    else
      return new Subtraction(left, right);
  }
  
  
  /**
   * Perform a symbolic/numeric multiplication
   * Note: The method should be elaborated to handle several
   * special cases (e.g multiplication with zero or one)
   */
  public static Sexpr mul(Sexpr left, Sexpr right) {
    if (left.isConstant() || right.isConstant()) {
      if (left.isConstant()) {
        if (left.getValue() == 0)
          return new Constant(0);
        if (left.getValue() == 1)
          return right;
      }
      if (right.isConstant()) {
        if (right.getValue() == 0)
          return new Constant(0);
        if (right.getValue() == 1)
          return left;
      }
      if (left.isConstant() && right.isConstant()) {
        return new Constant(left.getValue() * right.getValue());
      }
    } else {
      return new Multiplication(left, right);
    }
    return new Multiplication(left, right);
  }
  
  
  
  /**
   * Perform a symbolic/numeric division
   * Note: The method should be elaborated to handle several
   * special cases (e.g division with zero)
   //   */
  public static Sexpr div(Sexpr left, Sexpr right) {
    if (right.getValue() == 0) {
      throw new SyntaxException("Division with 0 not permitted");
    } else if (right.getValue() == 1) {
      return left;
    } else if (left.isConstant() && right.isConstant()) {
      return new Constant(left.getValue() / right.getValue());
    } else {
      return new Division(left, right);
    }
  }
  
  /**
   * Perform a symbolic/numeric negation
   */  
  public static Sexpr negate(Sexpr argument) {
    if (argument.isConstant())
      return new Constant(-argument.getValue());
    else
      return new Negation(argument);
  }
  
  public static Sexpr exp(Sexpr arg) {
    if (arg.isConstant())
      return new Constant(Math.exp(arg.getValue()));
    else
      return new Exp(arg);
  }
  
  public static Sexpr log(Sexpr arg) {
    if (arg.isConstant())
      if (arg.getValue()<0)
      throw new SyntaxException("Log of negative number not permitted");
    else
      return new Constant(Math.log(arg.getValue()));
    else
      return new Log(arg);
  }
  
  public static Sexpr sin(Sexpr arg) {
    if (arg.isConstant())
      return new Constant(Math.sin(arg.getValue()));
    else
      return new Sin(arg);
  }
  
  public static Sexpr cos(Sexpr arg) {
    if (arg.isConstant())
      return new Constant(Math.cos(arg.getValue()));
    else
      return new Cos(arg);
  }
}



