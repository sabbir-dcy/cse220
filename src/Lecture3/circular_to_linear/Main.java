package circular_to_linear;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] circ = {3, 4, 5, 6, 0, 0, 0, 0, 1, 2};
    var lin = new Linear(circ);
    int[] linear = lin.convert(8, 6);
    System.out.println(Arrays.toString(linear));
  }
}

class Linear {
  int circular[], len;
  public Linear(int[] circular) {
    this.circular = circular;
    this.len = circular.length;
  }

  public int[] convert(int start, int size) {
    int[] linear = new int[len];
    for (int i = 0; i < size; i++) {
      linear[i] = circular[start];
      start = (start + 1) % len;
    }
    return linear;
  }
}