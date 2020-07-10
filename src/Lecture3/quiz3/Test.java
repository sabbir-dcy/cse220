import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    int[] arr = {3, 4, 5, 0, 0, 0, 0, 0};
    var modify = new Modify();
    // modify.reverse(arr, 7, 11);
    modify.rev(arr);
    System.out.println(Arrays.toString(arr));
  }
}

public class Modify {

  public void rev(int[] arr) {
    int len = arr.length;
    int i = len / 2, j = 0;

    while (i < len - 1) {
      if (arr[i - 1] != 0) {
        i--;
      }
      if (arr[i + 1] != 0) {
        i++;
        break;
      }
      else {
        i = (i + 1)% len;
      }
    }

    j = i;
    System.out.println(j);
    // while (true) {
    //   if (arr[j - 1] == 0) {
    //     j--;
    //   }
    //   else {
    //     j--;
    //     break;
    //   }
    // }
    // int size = (len + (i) - j + 1);
    // int c = 0;
    // while (c++ < size / 2) {
    //   // System.out.println(head +" "+ tail);
    //   arr[i] += arr[j] - (arr[j--] = arr[i++]);
    //   i %= len;
    //   j = (j + len) % len;
    // }
  }
}