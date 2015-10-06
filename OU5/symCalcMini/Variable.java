/**
 * Represents a variable
 */
import java.util.Map;

public class Variable extends Atom {
  private String name;
  
  public Variable(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public Sexpr eval(Map<String,Sexpr>map) {
    if (map.containsKey(name)) {
      return map.get(name);
    } else {
      throw new EvaluationException("Undefined varible: " + name);
    }
  }
  
  public boolean equals(Sexpr x) {
    return this.getName().equals(x.getName());
  }
  
  public Sexpr diff(Sexpr x){
    if (this.getName().equals(x.getName())) {
      return new Constant(1);
    } else {
      return new Constant(0);
    
    
    
    }
  }
}
