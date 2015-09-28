import static java.lang.System.*;
import java.util.Scanner;

public class Recursion {
  
  public static double power(double x, int n) {
    if (n == 0) {
      return 1.;
    } else if (n > 0) {
      double p = power(x, n/2);
      if (n % 2 == 0) {
        return p*p;
      } else {
        return x*p*p;
      }
    } else {
      return (1/power(x, -n));
    }
  }
  
  public static int multiply(int m, int n) {
    if (n == 1) {
      return m;
    }
    else if (n > 1) {
      return m + multiply(n-1, m);
    } else {    
      return 0;
    }
  }
  
  public static int divide(int t, int n) {
    if (n < 0) {
      return -divide(-t, n);
    } else if (t < 0) { 
      return -divide(t, -n);
    } else if (t < n) {
      return 0;
    } else {
      return 1 + divide(t - n, n);
    }
  }
  
  public static double harmonic(int n) {
    if(n == 1) {
      return 1.0;
    } else {
      return (1.0 / n) + harmonic(n - 1);
    }
  }
  
  public static int largest(int[] a, int i) {
    if (i == 0) {
      return a[0];
    } else {
      return Math.max(a[i], largest(a, i-1));
    }
  }
  
  public static String reverse(String s) {
    char c = s.charAt(s.length()-1);
    if(s.length() == 1) {
      return Character.toString(c);
    }
    return c + reverse(s.substring(0, s.length()-1));
  }
  
  public static void bricklek(char from, char to, char help, int n) {
    if (n == 1) {
      System.out.println(from +"->"+to);
    } else {
      bricklek(from, help, to, n-1);
      System.out.println(from + "->" + to);
      bricklek(help, to, from, n-1);
    }
  }
  
  public static long fib(int n) {
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else
      return fib(n-1) + fib(n-2);
  }
  
  public static void fibTime(int n) {
    long startTime = System.currentTimeMillis();
    fib(n);
    long endTime = System.currentTimeMillis();
    long timeDiff = (endTime- startTime)/1000;
    System.out.println("Fib took " + timeDiff +"s");
    
  }  
  
  public static void sort(double [] a, int n) {
    if (n > 1) {
      sort( a, n-1 );
      double x = a[n-1];
      int i = n-2;
      while (i >= 0 && a[i] > x) {
        a[i+1] = a[i];
        i--;
      }
      a[i+1] = x;
    }
  }
  
  // FIXME ovning 12!
  
  static String reverseInt(int x) {
    String xstr = "" + x;
    String xrev = "";
    if (x < 0) 
      return xstr;
    else
      xrev = String.valueOf(Math.abs((long)x)).charAt(0) + xrev;
    return reverseInt(x%10);
  }
  
//FIXME?
  public static void reversDigits(long number) {
    if (number < 10) {
      System.out.println(number);
      return;
    }
    else {
      System.out.println(number % 10);
      reversDigits(number/10);
    }
  }
  
//  FIXME
//  static String longToString(long x, int b) {
//    //returnera representation av talet x i basen b. b ar lika med eller mindre an 16
//  }
  
  
//FIXME
  public static String reverseNumbers(Scanner scan) {
    if (scan.hasNextInt() != true )
      return "";   
    else {
      String rev = "\n";
      int i = scan.nextInt();
      rev = " " + i + rev;
      //reverse();
      return rev;
    }
  }
  
  
}