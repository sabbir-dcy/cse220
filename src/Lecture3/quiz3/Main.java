import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 0,0, 0, 0, 0, 0, 0, 0, 0};
    /** 
     1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0 // 6
     0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7 // 6
     3, 4, 5, 6, 7, 0, 0, 0, 0, 1, 2 // 7
     6, 7, 0, 0, 0, 0, 1, 2, 3, 4, 5 // 7
     0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 0 // 6 or 7
    */ 
    var modify = new Modify();
    modify.rev(arr);
    System.out.println(Arrays.toString(arr));
  }
}

public class Modify {

  public void rev(int[] arr) {
    int len = arr.length, size = 0;
    int i = 0;
    int head = 0, tail = len - 1;
    
    while (true) {
      if (i == len) {
        break;
      }
      if (arr[i] != 0) {
        i++;
      }
      else {
        tail = (i + len - 1) % len;
        while (arr[tail] == 0) {
          tail--;
        }
        break;
      }
    }
    while (true) {
      if (i == len) {
        break;
      }
      if (arr[i] == 0) {
        i = (i + 1) % len;
      }
      else {
        head = i;
        break;
      }
    }

    size = len - Math.abs(head - tail) % (len - 1) + 1;
    System.out.println(size);
    int c = 0;

    while (c++ < size / 2) {
      System.out.println(head +" "+ tail);
      arr[head] += arr[tail] - (arr[tail--] = arr[head++]);
      head %= len;
      tail = (tail + len) % len;
    }
  }
}