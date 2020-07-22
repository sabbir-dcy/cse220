import java.util.HashSet;
import java.util.Set;

public class TestWithArray {
  public static void main(String[] args) {
    dup();
    dup2();
  }

  public static void dup() {
    int[] arr = {10, 5, 7, 2, 4, 3, 5, 10};
    var set = new HashSet<Integer>();
    Integer dupIndex = null;

    for (int i = arr.length - 1; i >= 0; i--) {
      if (!set.add(arr[i])) {
        dupIndex = i;
      }
    }
    System.out.print(dupIndex != null ?  arr[dupIndex] + "\n" : "");
  }

  public static void dup2() {
    // O(n square)
    int[] arr = {1, 5, 7, 7, 2, 4, 3, 5, 10};
    for (int i : arr) {
      for (int j = 1; j < arr.length; j++) {
        if (i == arr[j]) {
          System.out.println(i);
          return;
        }
      }
    }
  }
}