import java.io.FileReader;
import java.io.IOException;

public class StokenizerTest {
  
  /**
   * Small test and demo program for Stokenizer
   */
  public static void main(String[] args) throws IOException {
    Stokenizer st = new Stokenizer();
    System.out.println("Write lines on the keyboard. End with 'quit': ");
    while (true) {
      st.nextToken();
      System.out.println("\tTok: " + st.getToken() + "  \t toString(): " + st);
      if (st.getToken().equals("quit")) {
        break;
      }
    }
    
    System.out.println("Next test: tokenize a string");
    Stokenizer rt = new Stokenizer("hej hopp \n du glade!");
    while (true) {
      rt.nextToken();
      System.out.println("\tTok: " + rt.getToken());
      if (rt.isEOS())
        break;
    }
    
    System.out.println("Next text: tokenize a file");
    System.out.print("Give a file name: ");
    java.util.Scanner sc = new java.util.Scanner(System.in);  
    rt = new Stokenizer(new FileReader(sc.nextLine()));
    while (true) {
      rt.nextToken();
      System.out.println(rt);
      if(rt.isEOS())
        break;
    }
    
    System.out.println("An erroneous call follows. Will cause a StokenizerException.");
    st.getNumber();
  }
  
}