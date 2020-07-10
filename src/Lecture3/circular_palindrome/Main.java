public class Main {
  public static void main(String[] args) {
    int[] arr = new int[]{5, 2, 9, 5, 0, 0, 2, 5, 7, 3, 4, 3, 7};
    arr = new int[]{4, 3, 7, 2, 5, 8, 0, 0, 0, 3, 5, 2, 7, 3};
    var mod = new Mod(arr);
    System.out.println(mod.isPalindrome(10, 4, 6));
  }
}

class Mod {
  int[] arr;
  int len;

  public Mod(int[] arr) {
    this.arr = arr;
    this.len = arr.length;
  }

  public Boolean isPalindrome(int p1, int p2, int start) {
    int end = (size + start - 1) % arr.length;
    if (p1 >= arr.length || p1 < 0 || p2 >= arr.length || p2 < 0) {
      return false;
    }
    if (p1 < end && p2 > start) {
      return false;
    }
  
    int i = 0, range;
    if (p1 < p2) {
      range = (end - start + 1) / 2;
    }
    range = (arr.length - p1 + p2 + 1) / 2;

    while (i++ < range) {
      if (arr[p1++] != arr[p2--]) {
        System.out.println("not palindrome");
        return false;
      }
      p1 %= arr.length;
      p2 = (p2 + arr.length) % arr.length;
    }
    return true;
  }
}