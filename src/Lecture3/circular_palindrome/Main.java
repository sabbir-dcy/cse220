public class Main {
  public static void main(String[] args) {
    int[] arr = new int[]{5, 2, 9, 5, 0, 0, 2, 5, 7, 3, 4, 3, 7};
    arr = new int[]{4, 3, 7, 2, 5, 8, 0, 0, 0, 3, 5, 2, 7, 3};
    var mod = new Mod(arr);
    System.out.println(mod.isPalindrome(10, 4));
  }
}

class Mod {
  int[] arr;
  int len;

  public Mod(int[] arr) {
    this.arr = arr;
    this.len = arr.length;
  }

  public Boolean isPalindrome(int start, int end) {
    if (!isValid(start, end)) {
      System.out.println("invalid input");
      return false;
    }
    if (start < end) {
      start += end - (end = start);
    }

    int i = 0;
    int range = (arr.length - start + end + 1) / 2;

    while (i++ < range) {
      if (arr[start++] != arr[end--]) {
        System.out.println("not palindrome");
        return false;
      }
      start = start % arr.length;
      end = (end + arr.length) % arr.length;
    }
    return true;
  }

  private Boolean isValid(int start, int end) {
    return start >= 0 && start < arr.length && end >= 0 && end < arr.length;
  }
}