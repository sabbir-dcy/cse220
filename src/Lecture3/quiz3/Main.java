import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {6, 0, 0, 0, 0, 1, 2, 3, 4, 5};
    var modify = new Modify();
    modify.reverse(arr, 6, 5);
    System.out.println(Arrays.toString(arr));
  }
}

public class Modify {
  public void reverse(int[] arr, int size, int start) {
    int last = (start + size - 1) % arr.length;
    int i = 0;
    while (i++ < size / 2) {
      arr[start] ^= arr[last] ^ (arr[last--] = arr[start++]);
      // start++;
      // last--;
      start %= arr.length;
      last = (last + arr.length) % arr.length;
    }
  }
}