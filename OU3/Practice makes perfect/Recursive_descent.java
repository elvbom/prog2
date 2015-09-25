public class Recursive_descent {
  
  double uttryck_sub() {
    double sum = uttryck();
    while (nextToRead() == '-') {
      readNextChar();
      sum += uttyck();
    }
    return sum;
  }
  
  double uttryck() {
    double sum = term();              // Forst kommer en term
    while ( nextToRead() == '+' ) {   // darefter kan det komma ett plustecken
      readNextChar();                 // och sedan en term till som skall
      sum += term();                  // adderas till summan
    }
    return sum;
  }
  
  double term() {
    double prod = faktor();
    while ( nextToRead() == '*' ) {
      readNextChar();
      prod *= faktor();
    }
    return prod;
  }
  
  double term_div() {
    double kvot = term();
    while (nextToRead() == '/') {
      readNextChar();
      kvot /= term();
    }
    return kvot;
  }

  double faktor() {
    if ( nextToRead() == '(' ) {       // Om vansterparentes
      readNextChar();                 // las forbi '('
      double result = uttryck();
      if (nextToRead()==')') {        // kontrollera att det kommer en avslutande ')'
        readNextChar();          // las forbi ')'
        return result;
      } else {
// Fel! Hogerparentes forvantades
      }
    } else if (nextIsNumber()) {
      return readNextNumber();
    } else {
// Fel! Forvantade vansterparentes eller tal
    }
  }
  
}