public class Main {
  public static void main(String[] args) {
    int[] arr = {3, 2, 5, 6, 7, 6, 5, 3, 1, 0, 0, 0};
    var arrays = new Arrays();
    var isPal = arrays.isPalindrome(arr, 9, 2, 6);
    System.out.println(isPal);
  }
}

class Arrays {
  public Boolean isPalindrome(int[] arr, int size, int start, int end) {
    if (start >= size || start < 0 || end >= size || end < 0) {
    	System.out.println("invalid index");
      return false;
    }
    if (start > end) {
      start ^= end ^ (end = start); // since, it's a linear array
    }

    while (start < end) {
      if (arr[start++] != arr[end--]) {
        return false;
      }
    }
    return true;
  }
}