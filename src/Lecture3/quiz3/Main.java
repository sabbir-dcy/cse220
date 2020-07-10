import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 1, 0, 0, 0, 11, 10, 9, 8, 7, 6, 5};
    var modify = new Modify();
    modify.reverse(arr, 7, 11);
    System.out.println(Arrays.toString(arr));
  }
}

public class Modify {
  public void reverse(int[] arr, int head, int size) {
    int tail = (head + size - 1) % arr.length;
    int laps = 0;

    while (laps++ < arr.length / 2) {
      arr[head] += arr[tail] - (arr[tail--] = arr[head++]);
      head %= arr.length;
      tail = (tail + arr.length) % arr.length;
    }
  }
}