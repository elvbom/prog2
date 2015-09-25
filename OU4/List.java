/**
 * A class for ordered lists of data items of integer type.
 * Every single data item occurs just once. Inserting an already
 * existing data item is null opertion - it does not change the
 * list in any way.
 * @version 2015-09-20
 */
public class List {
  
  private Node first;
  
  
  /* Inner class for list nodes */
  
  private static class Node {
    private int data;
    private Node next;
    
    private Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
  
  
  /**
   * Class for tree exceptions
   */
  public static class ListException extends RuntimeException {
    public ListException(String msg) {
      super(msg);
    }
  }   
  
  
  /**
   * Standard constructor 
   */
  public List() {
    first = null; 
  }
  
  
  /**
   * Private constructor to be used by some of the methods in the class
   */
  private List(Node n) {  
    first = n;
  }
  
  /* Methods */
  
  @Override
  public String toString() {
    return "[" + toString(first) + "]";
  }
  
  private static String toString(Node n) {
    if (n==null)
      return "";
    else if (n.next==null)
      return "" + n.data;
    else
      return "" + n.data + ", " + toString(n.next);
  }
  
  /**
   * Put a new number as a first node in the list.
   * In order to preserve the sorted condition, the list must either be
   * empty or the value to be entered less the the first data item in the list.
   * This method is mainly intended to be used by the unit test.
   */
  public void putFirst(int x) {
    assert first==null || x<first.data;
    first = new Node(x, first);
  }
  
  /**
   * Check if the list is empty.
   * @return <code>true</code> if the list har no elements, else <code>false</code>
   */
  public boolean isEmpty() {
    return first==null;
  }
  
  /** 
   * Insert a number in an ordered list so that the order is maintained. 
   * If the number already is in the list, nothing
   * is changed, i. e. every number occurs only once in the list
   * @param x the value to be inserted in the list
   */
  public void insert(int x) { 
    first = insert(x, first); 
  } 
  
  private static Node insert(int x, Node n) { 
    if (n==null || x<n.data) { 
      return new Node(x, n); 
    } else if (x>n.data) { 
      n.next = insert(x, n.next); 
    } 
    return n; 
  }
  
  
  /**
   * Make a copy of the list
   * @return a new List object containing a copy of the elements from this list
   */
  public List copy() {
    return new List(copy(first)); 
  }
  
  private static Node copy(Node n) {
    if (n==null)
      return null;
    else
      return new Node(n.data, copy(n.next));
  }
  
  
  /**********************************************************
    * 
    * Assignments: Implement the following methods
    * 
    **********************************************************/
  
  
  /**
   * Compute the number of elements in the list
   * @return the number of elements
   * 
   * Notes to the programmer:
   * Should be implemented with recursion
   * Should run in O(n) time if the list is of length n.
   */
  public int length() {
    if (first == null) {
      return 0;
    } else {
      List nextList = this.copy();
      nextList.first = nextList.first.next;
      return 1 + nextList.length();
    }
  }
  
  /**
   * Check if a specified data item is in the list
   * @param x the data item to be searched for
   * @return <code>true</code> if the data item is found, else <code>false</code>
   * 
   * Notes to the programmer:
   * Should be implemented with recursion.
   * Should run in O(n) time if the list is of length n.
   */
  
  public boolean contains(int x) {
    return contains(x, first);
  }  
  
  private boolean contains(int x, Node n) {
    if (n == null) {
      return false;
    } else if (x == n.data) {
      return true;
    } else { 
      return contains(x, n.next);
    }
  }
  
  /**
   * Check if a specified data item is in the list
   * @param x the data item to be searched for
   * @return <code>true</code> if the data item is found, else <code>false</code>
   * 
   * Notes to the programmer:
   * Should be implemented with iteration.
   * Should run in O(n) time if the list is of length n.
   */
  
  public boolean containsIter(int x) {
    Node n = first;
    if (first == null) {
      return false;
    } else {
      while (n != null) {
        if (n.data == x) {
          return true;
        } else {
          n = n.next;
        }
      } 
    }
    return false; 
  }
  
  
  /**
   * Find the last (i.e. the largest) data item in the list
   * @return the value of the last data item
   * @throws ListException if the list is empty
   * 
   * Notes to the programmer:
   * Should be implemented with recursion.
   * Should run in O(n) time if the list is of length n.
   */
  
  public int getLast() {
    if (first == null) {
      throw new ListException("List is empty");
    } else {
      return getLast(first);
    }
  }
  
  private int getLast(Node n) {
    if (n.next == null) {
      return n.data;
    } else { 
      return getLast(n.next);
    }
  }
  
  /**
   * Find the last (i.e. the largest) data item in the list
   * @return the value of the last data item
   * 
   * Notes to the programmer:
   * Should be implemented using iteration
   * Should run in O(n) time if the list is of length n.
   */
  
  public int getLastIter() {
    Node n = first;
    int last = 0;
    if (n == null) {
      throw new ListException("List is empty");
    } else {
      while (n != null) {
        if (n.next == null) {
          last = n.data;
          return last;
        }
        n = n.next;
      }
      return last;
    }
  }
  
  
  /**
   * Find the data item at a specified position in the list.
   * Positions are numbered from 0 and upwards.
   * @param i the position to be checked
   * @return the value at position <code>i</code>
   * @throws ListException if <code>i</code> specifies a nonexistent position
   * 
   * Note to the programmer:
   * Should be implemented with recursion.
   * Should run in O(n) time if the list is of length n.
   */
  
  public int atIndex(int i) {
    return atIndex(i, first);
  }
  
  private int atIndex(int i, Node n) {
    if (n == null) {
      throw new ListException("List is empty");
    } else if (i < 0) {
      throw new ListException("Index cannot be < 0");
    } else {
      if (i == 0) {
        return n.data; 
      } else {
        return atIndex(i-1, n.next);
      }
    }   
  }
    
  /**
   * Find the position of a specified data item
   * @param x the data item to be searched for
   * @return the position of data item or -1 if the list does not contain x
   *
   * Note to the programmer:
   * Should be implemented with recursion.
   * Should run in O(n) time if the list is of length n.
   */
  
  public int indexOf(int x) {
    return indexOf(x, first, 0);
  }
  
  private int indexOf(int x, Node n, int i) {
    if (n.data == x) {
      return i; 
    } else if (n.next == null) {
      return -1;
    } else {
      return indexOf(x, n.next, i+1);
    }
  }   
  
  
  /** 
   * Insert a number iteratively in an ordered list so that the order is maintained. 
   * If the number already is in the list, nothing
   * is changed, i. e. every number occurs only once in the list
   * @param x the value to be inserted in the list
   * 
   * Note to the programmer:
   * Should be implemented with iteration
   * Should run in O(n) time if the list is of length n.
   */
  
  public void insertIter(int x) {
    if (first == null || x < first.data) {
      first = new Node(x, first);
    } else if(first.next == null && x > first.data) {
      Node m = new Node(x, null);
      first.next = m;
    } else {
      Node n = first;
      Node m = first.next;
      while(n != null) {
        if (x < m.data) {
          Node o = new Node(x, m);
          n.next = o;
          break;
        } else if (m.next == null) {
          Node o = new Node(x, null);
          m.next = o;
          break;
        } else {
          n = n.next;
          m = m.next;
        }
      }
    }
  } 
    
  
  /** 
   * Clear the list, i.e. removes alla element from the list. 
   * 
   * Note to the programmer:
   * Should run in O(1) time if the list is of length n.
   */
  
  public void clear() {
    if (first == null)
      throw new ListException("List is already empty");
    else {
      while (first != null) {
        first = first.next;
      }
    }
  }
  
  
  /**
   * Remove the first element in the list
   * @return the data item in the removed element
   * @throws ListException if the list is empty
   */
  
  public int removeFirst() {
    if (first == null)
      throw new ListException("List is already empty");
    else {
      int x = first.data;
      first = first.next;
      return x;
    }
  }
  
  /**
   * Remove the last element in the list.
   * @returns the data item in the removed element
   * @throws ListException if the list is empty
   *
   * Notes to the programmer:
   * Should be implemented with recursion
   * Should run in O(n) time if the list is of length n.
   */

  public int removeLast() {
    if (first == null) {
      throw new ListException("List is empty");
    } else {
      return removeLast(first);
    }
  }
  
  private int removeLast(Node n) {
    if (n.next == null) {
      int x = n.data;
      clear();
      return x;
    } else {
      if (n.next.next == null) {
        int x = n.next.data;
        n.next = null;
        return x;
      } else {
        return removeLast(n.next);
      }
    }
  }
  
  /**
   * Remove a node with a specified data item
   * @param x the value to be removed
   * @throws ListException if x is not found
   */
  
  public void remove(int x) { 
    first = remove(x, first); 
    if (first == null) {
      throw new ListException("No such element in list: " + x +
                              ", hence it cannot be removed"); 
    }
  }
  
  /**
   * Recursive help method for remove.
   * @param x the value to be removed
   * @param n the first node in the sequences of nodes to be handled
   * @return the first node in the shrinked list
   * @throws ListException if x is not found
   * 
   * Notes to the programmer: 
   * Should be implemented with recursion.
   * This may be a bit tricky - study the given insert method!
   * Should run in O(n) time
   */
  
  private static Node remove(int x, Node p) { 
    if (p == null || x < p.data) {
      throw new ListException("No such element in list: " + x +
                              ", hence it cannot be removed"); 
    } else if (x == p.data) {
      return p.next; 
    } else { 
      p.next = remove(x, p.next); 
    }
    return p;  
  }
  
  
  /**
   * Compute the intersection of this lists with another list.
   * <p>
   * Example:
   * <p>
   * If this list contains {1, 3, 4, 8} and the other list contains {2, 3, 8, 9}
   * this method should create a list containing {3, 8}
   * @param l the other list to be used
   * @return a new list object containing the intersection of the lists
   * 
   * Note to the programmer:
   * Should be implemented with recursion
   * Should run in O(n+m) time if the list are of length n and m.
   */

  public List intersection(List l) {
    if(l.length() == 0 || length() == 0){
      List liEmpty = new List();
      return liEmpty;
    } else {
      List listInter = new List();
      intersection(first, l, listInter);
      return listInter;
    }
  }
  
  private void intersection(Node a, List l, List listInter){
    if(l.contains(a.data)) {
      listInter.insert(a.data);
    }
    if(a.next != null) {
      intersection(a.next, l, listInter);
    }
  }
  
  /**
   * Check if two lists contain the same data items
   *
   * @param l the list to be checked against
   * @return <code>true</code> if the lists contain exactly the same elements, 
   *         else <code>false</code>
   * 
   * Notes to the programmer:
   * Should be implemented with recursion.
   * Should run in O(n+m) time if the list are of length n and m.
   * 
   */
  
  public boolean equals(List l) {
    if (l.isEmpty() == isEmpty()) {
      return equals(l.first, first);
    } else {
      return false;
    }
  }      
  
  private boolean equals(Node n, Node m) {
    if (n == null && m == null) {
      return true;
    } else if (n.data == m.data) {
      if (n.next == null && m.next == null) {
        return true;
      } else if (n.next != null && m.next != null) {
        return equals(n.next, m.next);
      } else { 
        return false;
      }
    } else {
      return false;
    }
  }
  
  /****************************************************
    * Question:
    *   What is the complexity of the following code:
    *     List list = new List();
    *     for (int i=1; i<n; i++) {
    *        list.insert((int)(Math.random()*1000000));
    *     }
    * 
    *****************************************************/
  
  
  /**
   * Main method trying the methods above
   */
  public static void main(String[] args) {
    List p = new List();
    p.insert(5);
    p.insert(7);
    p.insert(3);
    p.insert(1);   
    System.out.println(p.toString());
    
    System.out.println("Length: " + p.length());           // Test length
    System.out.println("contains(0): " + p.contains(0));   // Test contains
    System.out.println("contains(1): " + p.contains(1));
    System.out.println("contains(2): " + p.contains(2));
    System.out.println("contains(5): " + p.contains(5));
    System.out.println("contains(7): " + p.contains(7));
    System.out.println("contains(9): " + p.contains(9));
    
    System.out.println("getLast()  : " + p.getLast());    // Test getLast
    
    System.out.println("atIndex(0) : " + p.atIndex(0));   // Test atIndex
    System.out.println("atIndex(1) : " + p.atIndex(1));     
    System.out.println("atIndex(2) : " + p.atIndex(2));
    
    System.out.println("indexOf(1) : " + p.indexOf(1));   // Test indexOf
    System.out.println("indexOf(7) : " + p.indexOf(7));
    System.out.println("indexOf(4) : " + p.indexOf(4));
    
    System.out.println("removeFirst: " + p.removeFirst()); // Test removeFirst
    System.out.println("p: " + p); 
    System.out.println("removeLast : " + p.removeLast());  // Test removeLast
    System.out.println("p: " + p); 
    p.clear();
    System.out.println("After clear(): " + p); 
    System.out.println("Force an exception");             // Test ListException
    try {
      p.removeFirst();
    } catch (ListException e) {
      System.out.println("*** List exception: " + e.getMessage());
    }
    
    // Rebuilding lists
    for (int i=0; i<20; i++) {
      p.insert((int)(Math.random()*10));
    }
    
    System.out.println("Inserted random numbers: " + p);
    
    for (int i= 0; i<10; i+=2 ) {
      if (p.contains(i))
        p.remove(i);
    }
    System.out.println("Without even numbers   : " + p);
    
    List q = p.copy();
    q.insert(42);
    System.out.println("p: " + p);
    System.out.println("q: " + q);
    
    System.out.println("p.equals(q): " + p.equals(q));   // Test equals
    p.insert(42);
    System.out.println("p.equals(q): " + p.equals(q) + 
                       " after insertion in p");
    
    // Test intersection
    for (int i=0; i<10; i++) {
      p.insert((int)(Math.random()*15));
      q.insert((int)(Math.random()*15));
    }
    
    System.out.println("p: " + p);
    System.out.println("q: " + q);
    System.out.println("p.intersection(q): " + p.intersection(q));
  }
}

