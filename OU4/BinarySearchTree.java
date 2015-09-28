import java.util.ArrayList;

/**
 * Binary search tree with strings as keys.
 * @version 2015-09-14
 */
public class BinarySearchTree {
  /**
   * Inner class for tree nodes
   */
  private static class Node {
    private String key;
    private Node left, right;
    
    private Node(String key, Node left, Node right) {
      this.key = key;
      this.left  = left;
      this.right = right;
    }
  }
  
  /**
   * Inner class for TreeExceptions
   */
  public class TreeException extends RuntimeException {
    public TreeException(String msg) {
      super(msg);
    }
  }
  
  private Node root;
  
  /**
   * Standard consytructor
   */
  public BinarySearchTree() { 
    root = null; 
  }
  
  private BinarySearchTree(Node r) { 
    root = r; 
  }
  
  /**
   * Insert a key preserving the sorted condition
   * @param key the key to be inserted
   */
  public void insert(String key) {
    root = insert(key, root);
  }
  
  private static Node insert(String key, Node r) {
    if (r==null) {
      return new Node(key, null, null);
    } else if (key.compareTo(r.key) < 0) {
      r.left = insert(key, r.left);
    } else if (key.compareTo(r.key) > 0) {
      r.right = insert(key, r.right);
    } else {
      // Do nothing - the key is already in the tree
    }
    return r;
  }
  
  public String toString() {
    return "<" + toString(root) + ">";
  }
  
  private static String toString(Node r) {
    if (r==null) {
      return "";
    } else {
      return toString(r.left) + " " + r.key + toString(r.right);
    }
  }
  
  /******************** Methods to be implemeted *************/
  
  /**
   * Compute the number of nodes in the tree
   * @return the number of nodes
   */
  
  public int size(){
    return size(root);
  }
  
  private static int size(Node n){
    if (n == null) {
      return 0;
    } else { 
      return 1+size(n.left)+size(n.right);
    }
  }
  
  
  /**
   * Compute the height.
   * The height is defined as the number of nodes on 
   * the longest path from the root to a leave.
   * @return the height
   */ 
  
  public int height() {
    return height(root);
  }
  
  private static int height(Node n) {
    if (n == null) {
      return 0;
    } else if (n.left == null && n.right != null) {
      return 1+height(n.right);
    } else {
      return 1+height(n.left);
    }
  }  
  
  /**
   * Determine if a specified key is in the tree.
   * @param key the key to be searched for
   * @return <code>true</code> if <code>key</code> is found, else <code>false</code>
   */

  public boolean contains(String key){
    return contains(root, key);
  }
  
  private boolean contains(Node n, String key){
    if (n == null) {
      return false;
    } else if (n.key == key) {
      return true;
    } else { 
      return contains(n.left,key) || contains(n.right,key);
    }
  }
  
  /**
   * Find the smallest (defined by compareTo()) key in the tree
   * return the smallest key
   */
  
  public String smallest() {
    if (root == null) {
      throw new TreeException("Tree is empty");
    } else {
      String small = smallest(root);
      return small;
    }
  }
  
  private String smallest(Node n) {
    if (n.left != null) {
      return smallest(n.left);
    }
    return n.key;
  }
  
  
  /**
   * Construct an arraylist containing the the keys from the nodes in symetric order
   * i.e. the keys will be stored in aphabetic order.
   * @return an arralist containing all keys from the tree i alphabetic order
   */
  
  public ArrayList<String> toArrayList() {
    ArrayList<String> listTree = new ArrayList<String>();
    return toArrayList(root, listTree);
  }
  
  private ArrayList<String> toArrayList(Node root, ArrayList<String> listTree) {
    if (root == null) {
      return listTree;
    } else {
      toArrayList(root.left, listTree); 
      listTree.add(root.key); 
      toArrayList(root.right, listTree); 
      return listTree;
    }
  }
  
  /**
   * Create a (deep) copy of the tree structure
   * @return a tree containing a copy of this tree
   */
  
  public BinarySearchTree copy(){
   BinarySearchTree c = new BinarySearchTree();
   if (root == null) {
     c.root = null;
   } else {
     copy(c, root);
   }
   return c;
  }
  
  private static void copy(BinarySearchTree c, Node n) {
    c.insert(n.key);
    if (n.left != null) {
      copy(c, n.left);
    }
    if (n.right != null) {
      copy(c, n.right);
    }
  } 
  
  /**
   * Check if this tree is equal to another key.
   * Equal means the same branching structure and the same keys in the nodes.
   * @param t the tree to be compared with
   * @return <code>true</code> if the trees are equal, else <code>false</code
   */
  
  public boolean equals(BinarySearchTree t) {
    return equals(root, t.root);
  }
  
  // FIXME jag tror felet ar har ngnstans. Fraga pa labb!
  private boolean equals(Node n, Node m) {
    if (n == null && m == null) {
      return true;
    } else if (n == null || m == null) {
      return false;
    } else if (n.key.compareTo(m.key) != 0) {
      return false;
    } else {
      return equals(n.left, m.left) && equals(n.right, m.right);
    }
  }
  
  /**
   * Check if two trees have exactly the same contents
   * @param t the tree to be compared with
   * @return <code>true</code> if the trees have the same contents, else <code>false</code>
   */
  
  public boolean sameContents(BinarySearchTree t) {
    return sameContents(root, t.root);
  }
  
  public boolean sameContents(Node n, Node m) {
    if (n == null && m == null) {
      return true;
    } else if (n.key == m.key) {
      if (sameContents(n.left, m.left) && sameContents(n.right, m.right)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
  
  
  /**
   * Compute the internal path length.
   * The internal path length can be defined as the
   * sum of the depths of the individual nodes.
   * The root has depth 1, the children of the root depth 2 etc.
   * Thus, a tree with one node has ipl 1, 
   * a tree with two nodes has ipl 3 and a tree with three nodes 
   * ipl 5 or 6 depending on shape.
   */
  
  public int ipl() {
    if (root == null) {
      return 0;
    } else {
      int depth = 1;
      depth = depth + ipl(root, depth);
      return depth;
    }
  }
  
  private int ipl(Node n, int depth) {
    int depthLeft = 0;
    int depthRight = 0;
    if (n.left != null) {
      depthLeft = depth + 1 + ipl(n.left, depth + 1);
    }
    if (n.right != null) {
      depthRight = depth + 1 + ipl(n.right, depth + 1);
    }
    return depthLeft + depthRight; 
  }
  
  /**
   * Main-metod showing calls to and results from all methods above
   */
  
  public static void main(String[] args) {
    BinarySearchTree emptyTree = new BinarySearchTree();
    BinarySearchTree nonEmptyTree = new BinarySearchTree();
    nonEmptyTree.insert("Keron");
    nonEmptyTree.insert("Akka");
    nonEmptyTree.insert("Stour Jierta");
    nonEmptyTree.insert("Unna Sievgok");
    //System.out.println("Non-empty tree has size: " + nonEmptyTree.size());
    //System.out.println("Non-empty tree has height: " + nonEmptyTree.height());
    
    BinarySearchTree anotherNonEmptyTree = nonEmptyTree.copy();
    //System.out.println("A copy of the non-empty tree: " + anotherNonEmptyTree);
    anotherNonEmptyTree.insert("Vistas");
    //System.out.println("A new element in the copy: " + anotherNonEmptyTree);
    //System.out.println("The original tree: " + nonEmptyTree);
    // Inserting into the original tree should not change the copy.
    nonEmptyTree.insert("Vistas");
    //System.out.println("The same new element in the original: " + nonEmptyTree);
    //System.out.println("The copy tree: " + anotherNonEmptyTree);
    nonEmptyTree.insert("Tarfala");
    System.out.println(anotherNonEmptyTree + " equals " 
                         + nonEmptyTree + ": "
                         + anotherNonEmptyTree.equals(nonEmptyTree));
    
    BinarySearchTree depthTree = new BinarySearchTree();
    depthTree.insert("Keron");
    depthTree.insert("Akka");
    depthTree.insert("Stour Jierta");
    //System.out.println(depthTree + "has internal depth length " + depthTree.ipl());
    
    //System.out.println("Empty tree has same contents as empty tree: " + emptyTree.sameContents(emptyTree));
    //System.out.println("Non-empty tree has same contents as same non-empty tree: " + depthTree.sameContents(depthTree));
    
    BinarySearchTree numberTree = new BinarySearchTree();
    numberTree.insert("1");
    numberTree.insert("2");
    numberTree.insert("3");
    //System.out.println("The smallest element of " + numberTree + " is: " + numberTree.smallest());
  }
  
}





