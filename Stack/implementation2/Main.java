import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    var stack = new ArrayStack(7);
    String name = "AVENGERS";
    for (char c : name.toCharArray()) {
      stack.push(c);
    }
    // stack.pop();
    // stack.printAll();
    System.out.println(stack.peek());
  }
}

public interface Stack {
  void push(Object data);
  Object pop();
  Object peek();
}
  
public class ArrayStack implements Stack {
  Object[] arr;
  int counter;

  public ArrayStack() {
    arr = new Object[10];
  }

  public ArrayStack(int size) {
    arr = new Object[size];
  }

  public void push(Object data) {
    if (counter == arr.length) {
      resize();
    }
    arr[counter++] = data;
  }

  private void resize() {
    int len = arr.length * 3 / 2;
    Object[] temp = new Object[len];

    for (int i = 0; i < counter; i++) {
      temp[i] = arr[i];
    }
    arr = temp;
  }

  public Object peek() {
    return counter == 0 ? null : arr[counter - 1];
  }

  public Object pop() {
    var removed = arr[counter - 1];
    arr[counter-- - 1] = null;
    return removed;
  }

  public void printAll() {
    for (int i = counter - 1; i >= 0; i--) {
      System.out.println(arr[i]);
    }
  }
}