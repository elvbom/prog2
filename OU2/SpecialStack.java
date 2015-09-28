/*** 
  * Represents a stack of integer numbers. A higher number may not be pushed on a lower number.
  ***/
import java.util.*;

public class SpecialStack {
  private ArrayList<Integer> specStack = new ArrayList<Integer>(); 
  
  public SpecialStack() {
    this.specStack = specStack;
  }
  
  //  Initiates a stack with the numbers n, n-1, ... 2, 1 with n in the bottom and 1 on the top.
  public SpecialStack(int n) {
    this.specStack = specStack;
    int i;
    for (i = 0; i < n; i++) {
      specStack.add(i, n-i);
    }
  }
  
  //  Pushes a number on the stack.
  //Throws: RuntimeException - if number to be pushed is higher than the number on the stack top
  public void push(int x) {
    if (specStack.size() == 0) {
      specStack.add(x);
    } else if (x > specStack.get(specStack.size() - 1)) {
      throw new RuntimeException("Number to be pushed is too high!");
    } else {
      specStack.add(x);
    }
  }
  
  //  Removes the top element from the stack
  //  Returns: The removed element 
  //  Throws: RuntimeException - if the stack is empty
  public int pop() {
    if (specStack.size() == 0) {
      throw new RuntimeException("Stack is empty!");
    } else {
      int length = specStack.size() - 1;
      int topEl = specStack.get(length);
      specStack.remove(length);
      return topEl;
    }
  }
  
  //  A string representation of the stack. The first element is the bottom and the last the top element of the stack.
  //  Overrides: toString in class Object
  public String toString() {
    String arrList = "[";
    int i;
    for (i = 0; i < specStack.size(); i++) {
      if (i == specStack.size() - 1) {
        arrList = arrList + specStack.get(i);
      } else {
        arrList = arrList + specStack.get(i) + ", ";}
    } 
    arrList = arrList + "]";
    return arrList;
  }
  
}

