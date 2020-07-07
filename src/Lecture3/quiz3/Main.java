import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 8, 9, 10, 11, 0, 0, 0, 0, 1, 2, 3};
    var modify = new Modify();
    modify.reverse(arr, 11, 12);
    System.out.println(Arrays.toString(arr));
  }
}

public class Modify {
  public void reverse(int[] arr, int size, int start) {
    int last = (start + size - 1) % arr.length;
    int i = 0;
    while (i++ < size / 2) {
      arr[start] ^= arr[last] ^ (arr[last--] = arr[start++]);
      start %= arr.length;
      last = (last + arr.length) % arr.length;
    }
  }
}