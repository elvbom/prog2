/**
 * Represents an exponential function
 */
import java.util.Map;

public class Exp extends Function {
  
  public Exp(Sexpr operand) {
    super(operand);
  }
  
  public String getName() {
    return "exp";
  }
  
  public Sexpr eval(Map<String,Sexpr> map) {
    return Symbolic.exp(operand.eval(map));
  }
  
  public Sexpr diff(Sexpr v) {
    //operanden skickas till variable dar derivatan tas?
    return Symbolic.mul(operand.diff(v), new Exp(operand));
  }
}
