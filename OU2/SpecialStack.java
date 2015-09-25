/*** 
  * Represents a stack of integer numbers. A higher number may not be pushed on a lower number.
  ***/
public class SpecialStack {

  public SpecialStack() {
    Stack specStack = new Stack();
  }
  //  Initiates an empty stack

  public SpecialStack(int n) {
    Stack specStack = new Stack();
    int i;
    for (i = 0; i < n; i++) {
      
    }
  }
  //  Initiates a stack with the numbers n, n-1, ... 2, 1 with n in the bottom and 1 on the top.

  public void push(int x) {
  }
  //  Pushes a number on the stack.
  //Throws: RuntimeException - if number to be pushed is higher than the number on the stack top

  public int pop() {
  }

  //  Removes the top element from the stack
  //  Returns: The removed element 
  //  Throws: RuntimeException - if the stack is empty

  public String toString() {
  }
  //  A string representation of the stack. The first element is the bottom and the last the top element of the stack.
  //  Overrides: toString in class Object
}

