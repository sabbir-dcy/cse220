import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0};
    var circ = new Circular(arr);
    circ.toCircular(4); // start index
    System.out.println(Arrays.toString(arr));


  }

  public static void toCircularTest(int[] lin, int start, int size) {
    int limit = start;
    for (int i = 0, j = 0; i < size; i++) {
      lin[start] += lin[j] - (lin[j] = lin[start]);
      j = (j + 1) % (limit);
      start = (start + 1) % lin.length;
    }
  }
}

class Circular {
  int[] arr;
  public Circular(int[] arr) {
    this.arr = arr;
  }

  public int gcd(int n1, int n2) {
    if (n2 == 0) {
      return n1;
    }
    return gcd(n2, n1 % n2);
  }

  public void toCircular(int start) {
    int rot = arr.length - start;
    for (int i = 0; i < gcd(arr.length, rot); i++) {
    swap(rot, i);
    }
  }

  public void swap(int rot, int i) {
    int temp = arr[i];
    int j = i;
    while (true) {
      int k = (j + rot) % arr.length;
      if (k == i) {
        break;
      }
      arr[j] = arr[k];
      j = k;
    }
    arr[j] = temp;
  }
}