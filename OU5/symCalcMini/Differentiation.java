/**
 * Represents a dervivative
 */
import java.util.Map;

class Differentiation extends Binary {
  
  public Differentiation(Sexpr left, Sexpr right) {
    super(left, right);
  }
  
  public String getName() {
    return "";
  }
  
  public int priority() {
    return 60;
  }
  
  public Sexpr eval(Map<String, Sexpr> v) {
    Sexpr e = left.eval(v);
    return e.diff(right);
  }
  
}