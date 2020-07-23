import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    var stack = new Stack(7);
    String name = "AHANAF";
    for (char c : name.toCharArray()) {
      stack.push(c);
    }
    // stack.printAll();
    System.out.println(stack.peek());
  }
}

class Stack {
  Object[] arr;
  int conter;

  public Stack() {
    arr = new Object[10];
  }

  public Stack(int size) {
    arr = new Object[size];
  }

  public void push(Object data) {
    if (conter == arr.length) {
      resize();
    }
    arr[arr.length - 1 - conter++] = data;
  }

  private void resize() {
    int len = arr.length * 3 / 2;
    Object[] temp = new Object[len];

    for (int i = arr.length - 1, j = 0; i >= 0; i--) {
      temp[temp.length - 1 - j++] = arr[i];
    }
    arr = temp;
  }

  public Object peek() {
    for (Object val : arr) {
      if (val != null) {
        return val;
      }
    }
    throw new NoSuchElementException();
  }

  public void printAll() {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != null) {
        System.out.println(arr[i]);
      }
    }
  }
}