/**
 * Parser
 * See syntax diagrams for documentation
 */
import java.util.Map;
import java.util.TreeSet;
public class Parser {
  
  private Stokenizer tokenizer;
  private TreeSet<String> functions;  // Names of recognized functions
  
  /**
   * Constructs a parser
   * @param tokenizer an initialized tokenizer
   */
  public Parser(Stokenizer tokenizer) {  
    this.tokenizer = tokenizer; 
    // Create a set with the names of the recognized functions
    functions = new TreeSet<String>();
    functions.add("sin");
    functions.add("cos");
    functions.add("exp");
    functions.add("log");
  }
  
  /**
   * Handles an assignment
   */
  public Sexpr assignment() {
    Sexpr value = expression();
    while (tokenizer.getChar() == '=') {
      tokenizer.nextToken();
      if (tokenizer.isWord()) {
        value = new Assignment(value, new Variable(tokenizer.getWord()));
        tokenizer.nextToken();
      } else {
        throw new SyntaxException("Expected variable after '='");
      }
    }
    return value;
  }
  
  /**
   * Handles a sum of terms 
   */
  public Sexpr expression() {
    Sexpr sum = term();
    int c;
    while ((c=tokenizer.getChar()) == '+' || (c=tokenizer.getChar()) == '-') {
      tokenizer.nextToken();
      if (c == '+') {
        sum = new Addition(sum, term());
      } else {
        sum = new Subtraction(sum, term());
      }
    }
    return sum;
  }
  
  /**
   * Handles a product of factors
   */
  public Sexpr term() {
    int c;
    Sexpr prod = factor();
    while ((c = tokenizer.getChar()) == '*' || (c = tokenizer.getChar()) == '/') {
      tokenizer.nextToken();
      if (c == '*') {
        prod = new Multiplication(prod, factor());
      } else {
        prod = new Division(prod, factor());
      }
    }
    return prod;
  }
    
  /**
   * Handles a differentiation
   */
  public Sexpr factor() {
    Sexpr result = primary();
    while (tokenizer.getChar() == '\'') {
      tokenizer.nextToken();
      if (tokenizer.isWord()) {
        result = new Differentiation(result, new Variable(tokenizer.getWord()));
        tokenizer.nextToken();
      } else {
        throw new SyntaxException("' must be followed by a variable");
      }
    }    
    return result;
  }
  
  /**
   * Handles a primary
   */
  public Sexpr primary() {
    Sexpr result = null;
    if (tokenizer.getChar() == '(') {          // Parentheses
      tokenizer.nextToken(); 
      result = assignment();
      if (tokenizer.getChar() == ')') {
        tokenizer.nextToken();
      } else {
        throw new SyntaxException("Expected ')'");
      }
    } else if (tokenizer.getChar() == '-') {
      tokenizer.nextToken();
      result = new Negation(primary());  
    }  else if (tokenizer.getChar() == '"') {
      tokenizer.nextToken();
      result = new Quotation(primary());  
    } else if (tokenizer.getChar() == '&') {
      tokenizer.nextToken();
      result = new Evaluation(primary());
    } else if (tokenizer.isNumber()) {
      result = new Constant(tokenizer.getNumber());
      tokenizer.nextToken();
    } else if (functions.contains(tokenizer.getToken())) {
      result = function(tokenizer.getToken());
    } else if (tokenizer.isWord()) {
      result = new Variable(tokenizer.getWord());
      tokenizer.nextToken();
    } else {
      throw new SyntaxException("Expected number, word, '-', " + 
                                "'\"', '&' or '('");
    }
    return result;
  }
  
  public Sexpr function(String functionName) {
    String foo = tokenizer.getToken();
    Sexpr arg;
    tokenizer.nextToken();
    if (tokenizer.getChar() == '(') {
      arg = primary();
    } else {
      throw new SyntaxException("'(' expected after function '"
                                  + foo + "'");
    }
    if (foo.equals("exp")) {
      return new Exp(arg);
    } else if (foo.equals("log")) {
      return new Log(arg);
    } else if (foo.equals("sin")) {
      return new Sin(arg);
    } else if (foo.equals("cos")) {
      return new Cos(arg);
    } else {
      throw new RuntimeException("Internal error! Unknown function "
                                   + foo);
    }
  }
  
}


