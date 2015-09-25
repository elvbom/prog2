//Att fånga ett undantag

import java.io.*;

/**
 * Class for storing Integer objects. 
 */
public class Storage {
  
  private Integer[] objects;
  
  /**
   * Create a storage with room for 5 Integers.
   */
  public Storage() {
    objects = new Integer[5];
  }
  
  public int average() {
    int sum = 0;
    for (int i=0; i<objects.length; i++) {
      sum += getValue(i);
    }
    int averageValue = sum / objects.length;
    return averageValue;
  }
  
  /**
   * Get a value from the storage.
   * 
   * @param ind Index of the requested value. 
   */
  public int getValue(int ind) {
    return objects[ind].intValue();
  }
  
  
  /**
   * Store a value at a specified position in the storage, if it is empty.
   * 
   * @param ind Position on which the value will be stored
   * @param val Value to store
   */
  public void put(int ind, int val) {
    if (objects[ind] == null) {
      objects[ind] = val; 
    } else {
      throw new StorageException("Cannot insert value on position " + ind
                                   + ", which already stores the value "
                                   + objects[ind] + ".");
    }
  }
    
  
  /**
   * @return String representation of the storage.
   */
  public String toString() {
    String res = "";
    for (int i=0; i<objects.length; i++) {
      res += objects[i] + " ";
    }
    return res;
  }
  
  public static void main(String[] args) {
    Storage s = new Storage();
    System.out.println(s.toString());
    s.put(2, 67);
    System.out.println(s.toString());
    s.put(3, 2549);
    System.out.println(s.toString());
    s.put(2, 35);
    System.out.println(s.toString());
    int i = 3;
    try {
      System.out.println("Value on position " + i + " : " + s.getValue(i));
    } catch (NullPointerException e) {
      System.out.println("No object is stored on position " + i + "!");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid array index : " + i + "!");
    }
    System.out.println(s.toString());
  }
  
}