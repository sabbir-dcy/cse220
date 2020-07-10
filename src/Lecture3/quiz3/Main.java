import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 0, 0};
    var modify = new Modify();
    modify.rev(arr);
    System.out.println(Arrays.toString(arr));
  }
}

public class Modify {

  public void rev(int[] arr) {
    int len = arr.length, size = 0;
    int i = len - 1, j = 0;
    
    while (true) {
      if (i < 0) {
        j = len - 1;
        i++;
        break;
      }
      if (arr[i] == 0) {
        j = i;
        i++;
        break;
      }
      else {
        i--;
      }
    }
    while (true) {
      if (arr[j] != 0) {
        break;
      }
      else {
        j--;
      }
    }

    size = len - Math.abs(i - j) % (len - 1) + 1;
    System.out.println(size);
    int c = 0;

    while (c++ < size / 2) {
      // System.out.println(i +" "+ j);
      arr[i] += arr[j] - (arr[j--] = arr[i++]);
      i %= len;
      j = (j + len) % len;
    }
  }
}