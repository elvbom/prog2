import java.util.*;

/**
 * A template for the parser class. Most of the methods are included
 * but they do nothing but a call to the next metod.
 * 
 * How to use:
 * 1. Copy the class to your own map
 * 2. Rename the file and the class to Parser (don't forget the constructor!)
 * 3. Create the exception classes SyntaxException and EvaluationException (or
 *    comment all references to the exception classes in both 
 *    Calculator and Parser)
 * 4. Compile!
 * 5. Run and see that the calcultar is just able to handle numbers.
 * 6. Add addition handling in the method expression.
 * 7. Add handling of subtractions also in the method expression
 * 8. Add everything else...
 */
public class Parser {
  Stokenizer tokenizer;
  Map<String,Double> variables = new TreeMap<String,Double>();
  String synExc = "*** Syntax error. ";
  String synExc1 = "\nThe error occured at token";
  String synExc2 = "just after token";
  
  public Parser(Stokenizer tokenizer, Map<String,Double> variables) {
    this.tokenizer = tokenizer;
    this.variables = variables;
  }
  
  public double assignment() {
    double result = expression();
    while (tokenizer.getChar() == '=') {
      tokenizer.nextToken();
      if (tokenizer.isWord()) {
        variables.put(tokenizer.getWord(), result);
      } else {
        throw new SyntaxException(synExc + "'=' should be followed by variable" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
      }
      tokenizer.nextToken();
    }
    variables.put("ans", result);
    return result;  
  }
  
  public double expression() {
    double sum = term();
    while ((tokenizer.getChar() == '+') || (tokenizer.getChar() == '-')) {
      if (tokenizer.getChar() == '+') {
        tokenizer.nextToken();
        if (tokenizer.isEOL()){
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '+' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '*' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '/' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else {
          sum += term();
        }
      } else if (tokenizer.getChar() == '-') {
        tokenizer.nextToken();
        if (tokenizer.isEOL()){
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '+' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '*' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '/' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else {
          sum -= term();
        }
      }
    }
    return sum;
  }
  
  public double term() {
    double prod = factor();
    while ((tokenizer.getChar() == '*') || (tokenizer.getChar() == '/')) {
      if (tokenizer.getChar() == '*') {
        tokenizer.nextToken();
        if (tokenizer.isEOL()){
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '+' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '*' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '/' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else {
          prod *= factor();
        }
      } else if (tokenizer.getChar() == '/') {
        tokenizer.nextToken();
        if (tokenizer.isEOL()) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '+' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '*' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        } else if (tokenizer.getChar() == '/' ) {
          throw new SyntaxException(synExc + "Expected number or bracket" + 
                                    synExc1 + tokenizer.getToken() + 
                                    synExc2 + tokenizer.getPreviousToken());
        } else {
          double d = factor();
          if (d == 0) {
            throw new EvaluationException("Division with zero not permitted");
          } else {
            prod /= d;
          }
        }
      }
    }
    return prod;
  } 
  
  public double factor() {
    return primary();
  }
  
  public double primary() {
    if (tokenizer.getChar() == '(' ) {
      tokenizer.nextToken();
      double result = assignment();        
      if (tokenizer.getChar() == ')' ) {
        tokenizer.nextToken();
        return result;
      } else {
        throw new SyntaxException(synExc + "Expected closing bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
      }
    } else if (tokenizer.isWord() == true) {
      if (variables.containsKey(tokenizer.getWord()) == true) {
        double word = variables.get(tokenizer.getWord());
        tokenizer.nextToken();
        return word;
      } else if (tokenizer.getWord().equals("exp")) {
        tokenizer.nextToken();
        if (tokenizer.getChar() == '(') {
          tokenizer.nextToken();
          double result = Math.exp(assignment());
          if (tokenizer.getChar() == ')') {
            tokenizer.nextToken();
            return result;
          } else {
            throw new SyntaxException(synExc + "Expected closing bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
          }
        } else {
          throw new SyntaxException(synExc + "Expected bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        }
      } else if (tokenizer.getWord().equals("log")) {
        tokenizer.nextToken();
        if (tokenizer.getChar() == '(') {
          tokenizer.nextToken();
          double result = Math.log(this.assignment());
          if (tokenizer.getChar() == ')') {
            tokenizer.nextToken();
            return result;
          } else {
            throw new SyntaxException(synExc + "Expected closing bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
          }
        } else {
          throw new SyntaxException(synExc + "Expected bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        }
      } else if (tokenizer.getWord().equals("sin")) {
        tokenizer.nextToken();
        if (tokenizer.getChar() == '(') {
          tokenizer.nextToken();
          double result = Math.sin(assignment());
          if (tokenizer.getChar() == ')') {
            tokenizer.nextToken();
            return result;
          } else {
            throw new SyntaxException(synExc + "Expected closing bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
          }
        } else {
          throw new SyntaxException(synExc + "Expected bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        }
      } else if (tokenizer.getWord().equals("cos")) {
        tokenizer.nextToken();
        if (tokenizer.getChar() == '(') {
          tokenizer.nextToken();
          double result = Math.cos(this.assignment());
          if (tokenizer.getChar() == ')') {
            tokenizer.nextToken();
            return result;
          } else {
            throw new SyntaxException(synExc + "Expected closing bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
          }
        } else {
          throw new SyntaxException(synExc + "Expected bracket" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
        }
      } else {
        throw new EvaluationException("Not valid input: " + tokenizer.getToken());
      }
    } else if (tokenizer.isNumber() == true) {
      double result=tokenizer.getNumber();
      tokenizer.nextToken();
      return result;      
    } else if (tokenizer.getChar() == '-') {
      tokenizer.nextToken();
      double result = (-1)*this.primary();
      return result;
    }
    throw new SyntaxException(synExc + "Unexpected input" + 
                                  synExc1 + tokenizer.getToken() + 
                                  synExc2 + tokenizer.getPreviousToken());
  }
  
} 
