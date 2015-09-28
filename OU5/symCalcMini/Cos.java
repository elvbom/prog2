/**
 * Represents an cosine operation
 */
import java.util.Map;

public class Cos extends Function {
  
  public Cos(Sexpr operand) {
    super(operand);
  }
  
  public String getName() {
    return "cos";
  }
  
  public Sexpr eval(Map<String,Sexpr> map) {
    return Symbolic.cos(operand.eval(map));
  }
  
  public Sexpr diff(Sexpr variable){
    return Symbolic.negate(Symbolic.mul(operand.diff(variable), new Sin(operand)));
  }
  
}