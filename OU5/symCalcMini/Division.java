/** 
 * Represents a division operation
 */
import java.util.Map;

public class Division extends Binary {
  
  public Division(Sexpr left, Sexpr right) {
    super(left, right);
  }
  
  public String getName() {
    return "/";
  }
  
  public int priority() {
    return 30;
  }
  
  public Sexpr eval(Map<String, Sexpr>map) {
    return Symbolic.div(left.eval(map), right.eval(map));
  }
  
  public Sexpr diff(Sexpr variable){
    return Symbolic.div(Symbolic.add(Symbolic.mul(left.diff(variable), right), 
                                     Symbolic.negate(Symbolic.mul(left, right.diff(variable)))), right);
  }
  
}