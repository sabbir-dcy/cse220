import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] lin = {1, 2, 3, 4, 5, 6, 7, 8};
    new Rotation().toCircular(lin, 3);
    System.out.println(Arrays.toString(lin));
  }
}

class Rotation {
  int[] arr;

  public void toCircular(int[] arr, int rot) {
    this.arr = arr;
    leftRotation(rot);
    }

  private void leftRotation(int rotation) {
    
    for (int i = 0; i < gcd(arr.length, rotation); i++) {
      int temp = arr[i];
      int j = i; // j will be the initial index of each loop

      while (true) {
        int k = (j + rotation) % arr.length; // which one to rotate
        if (k == i) { 
          break;
        }
        arr[j] = arr[k];
        j = k;
      }
      arr[j] = temp; // at last intdex that moved forward
    }
  }

  private void rightRotation(int rotation) {
    
    for (int i = 0; i < gcd(arr.length, rotation); i++) {
      int initial = arr.length - i - 1;
      int temp = arr[initial];
      int j = initial;

      while (true) {
        int k = (j - rotation + arr.length) % arr.length;
        if (k == initial) {
          break;
        }
        arr[j] = arr[k];
        j = k;
      }
      arr[j] = temp;
    }
  }

  private int gcd(int n1, int n2) {
    if (n2 == 0) {
      return n1;
    }
    return gcd(n2, n1 % n2);
  }
}