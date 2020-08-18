import Stack.link_stack.Stack;
import Stack.link_stack.LinkStack;

public class Main {
  public static void main(String[] args) {
    Stack stack = new LinkStack();
    int i = 0;
    while (i < 5) {
      stack.push(i++);
    }
    System.out.println(stack.peek());
  }
}