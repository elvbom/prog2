/**
 * This program reads a file and produces a frequence table for the 
 * words in the file.
 * Purpose: To demonstrate the usage of a TreeMap
 */
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.*;
import java.nio.charset.*;

public class TreeMapDemo {

  public static void main(String[] args) throws IOException {

    String filename = "vandrare.utf8";
    File input = new File(filename);
    Scanner sc = new Scanner(input, "UTF-8"); // Specify the character coding used in the file 

    Map<String,Integer> f = new TreeMap<String,Integer>();
    while(sc.hasNext()) {
      String w = sc.next();
      if (f.containsKey(w)) {       // if w already is stored in f
        int i = f.get(w);           //   get its frequence
        f.put(w, new Integer(i+1)); //   and store an increased frequence
      } else {                      // else
        f.put(w, new Integer(1));   //   store a new word with frequence 1
      }
    }
    System.out.println(f);          // Primitive output (toString())
    
    /* If a more elaborated printout is requested you can produce a
     * Set of the entries and then use an iterator over that set.
     * The entries in the Set will be of type Map.Entry<String,Integer> from
     * which you can get the key and the value using the getKey()- and 
     * getValue-methods.
     */
    Set<Map.Entry<String,Integer>> s = f.entrySet(); // Make a set of all entries
    System.out.println(s);         // To see what the Set toString method gives
    
    Iterator<Map.Entry<String,Integer>> i= s.iterator(); // Gives an iterator for the Set
    while(i.hasNext()) {
      Map.Entry<String,Integer> e = i.next();  
      System.out.printf("%-15s \t %3d\n", e.getKey(), e.getValue());
    }

    /* A more compact way to produce the same output is to use the iterator
     * version of the for statement:
     */
    System.out.println("\n The same result:\n");
    for( Map.Entry<String,Integer> entry : f.entrySet() ) {
      System.out.printf("%-15s \t %3d\n", entry.getKey(), entry.getValue());
    }
  }
}