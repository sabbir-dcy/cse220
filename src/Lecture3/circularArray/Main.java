package lecture2.circle;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {40, 50, 0, 0, 0, 0, 0, 0, 10, 20, 30};
    int[] brr = {4, 5, 6, 7, 8, 9,0, 0, 0, 0, 0, 1, 2, 3};
    var circle = new Circuler(brr);
    // circle.rotate(2);
    // System.out.println(Arrays.toString(arr));
    // circle.forwardPrint(5, 4);
    // System.out.println();
    circle.reversePrint(9, 11);

  }
} 

class Circuler {
  int[] arr;

  public Circuler(int[] arr) {
    this.arr = arr;
  }

  public void rotate(int index) {
    for (int i = 0; i < index; i++) {
      swapper();
    }
  }

  private void swapper() {
    int head = arr[arr.length - 1];

    int i = arr.length - 1;
    for (; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[i] = head;
  }

  public void forwardPrint(int size, int start) {
    int index = start;
    for (int i = 0; i < size; i++) {
      System.out.print(arr[index] + " ");
      index = (index + 1) % arr.length;
    }
  }

  public void reversePrint(int size, int start) {
    int index = (start + size - 1) % arr.length;
    for (int i = 0; i < size; i++) {
      System.out.println(arr[index]);
      index = (index + arr.length - 1) % arr.length;
      System.out.println("index is "+ index);
    }
  }
} 