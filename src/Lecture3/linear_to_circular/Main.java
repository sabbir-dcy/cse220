package linear_to_circular;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] linear = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0};
    var circular = new Circular(linear);
    int[] circ = circular.convert(8);
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

  public int[] convert(int start) {
    int[] circular = new int[len];

    for (int i = 0; i < linear.length; i++) {
      start = start % len;
      circular[start++] = linear[i];
    } 
    return circular;
  }
}