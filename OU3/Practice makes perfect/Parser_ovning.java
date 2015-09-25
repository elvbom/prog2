/***
  * Skriv ett program som läser in aritmetiska uttryck, 
  * beräknar värdet och skriver ut värdet enligt pseudokoden ovan. 
  * Börja kopiera koden till klassen Stokenizer Skriv sedan en klass Parser med de 
  * metoder som enligt pseudokoden ovan (uttryck, term, faktor). 
  * Använd metoderna i klassen Stokenizer i stället för primitiverna nextToRead, readNextChar... 
  ***/

public class Parser_ovning {
   
   private static Stokenizer tokenizer = new Stokenizer();
   
   // uttryck ar en term med plustecken kring
   public static double uttryck() {
     double sum = term();
     while (tokenizer.getChar() == '+') {
       tokenizer.nextToken();
       sum += term();
     }
     return sum;
   }
   
   // term ar en faktor med gangertecken kring 
   public static double term() {
    double prod = faktor();
    while (tokenizer.getChar() == '*' ) {
      tokenizer.nextToken();
      prod *= faktor();
    }
    return prod;
  }
   
   // faktor ar ett tal eller uttryck med paranteser kring
   public static double faktor() {
    if (tokenizer.getChar() == '(' ) {
      tokenizer.nextToken();
      double result = uttryck();
      if (tokenizer.getChar() == ')') {
        tokenizer.nextToken();
        return result;
      } else {
      }
    } else if (tokenizer.nextToken().isNumber()) {
      return tokenizer.nextToken().toString();
    } else {
    }
  }
   
   public static void main(String[] args) {
      tokenizer.nextToken();          // Read the first token
      while (true) {
         System.out.println(uttryck());
         tokenizer.nextToken();       // Skip end-of-line. Should be checked!
      }
   }
}
      
   
  