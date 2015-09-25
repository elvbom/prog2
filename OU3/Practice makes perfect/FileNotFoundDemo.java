import java.io.*;

public class FileNotFoundDemo { 
  /**
   * Open the file whose name is given as argument to the method.
   * 
   * @param fileName Path to file to open
   */
  static void openFile(String fileName) {
    try {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("Error while opening file: " + e.getMessage());
    }
  }
  
  public static void main(String[] args) throws FileNotFoundException {
    openFile("non-existent_file.txt");
  }
  
}
