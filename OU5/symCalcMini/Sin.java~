/**
 * Represents an sine operation
 */
import java.util.Map;

public class Sin extends Function {
  
  public Sin(Sexpr operand) {
    super(operand);
  }
  
  public String getName() {
    return "sin";
  }
  
  public Sexpr eval(Map<String,Sexpr> map) {
    return Symbolic.sin(operand.eval(map));
  }  
  
  public Sexpr diff(Sexpr variable){
    return Symbolic.mul(operand.diff(variable), new Cos(operand));
  }
  
}