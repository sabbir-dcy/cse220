package linear_to_circular;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] linear = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0};
    var circular = new Circular(linear);
    int[] circ = circular.convert(8, 6);
    System.out.println(Arrays.toString(circ));
  }
}

class Circular {
  int[] linear;
  int len;

  public Circular(int[] arr) {
    this.linear = arr;
    this.len = linear.length;
  }

  public int[] convert(int start, int size) {
    int[] circular = new int[len];

    for (int i = 0; i < size; i++) {
      circular[start] = linear[i];
      start = (start + 1) % len;
    } 
    return circular;
  }
}