import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    var pal = new Palindrome();
  
    int[] arr = {3, 4, 5, 6, 7, 6, 5, 3, 1, 0, 0, 0};
    int[] brr = {1, 3, 4, 4, 3, 1};

    boolean b = pal.isPalindrome(arr, 9, 6, 2);
    System.out.println(b);
    
    // int[] crr = {1, 2, 3, 4, 5};
    // var rot = new Rotation(crr);
    // rot.rotate(2);
    // System.out.println(Arrays.toString(crr));
  }
}

class Palindrome {
  public Boolean isPal(int[] arr, int size, int start, int end) {
    int[] brr = arr.clone();
    int upTo = end;

    while (start <= upTo) {
      brr[start] = arr[end--];
      start++;
    }
    return Arrays.equals(arr, brr);
  }

  /**
    * returns a boolean if value of two array same or not,
    * brr[] is a new array which contains the same value as arr[] but different memory address,
    * loop will execute from start value to end value
    * by putting the last element of arr[] to the first index of brr[]
      reversing the order between start to end
    * after reversing the order if the values and order remains same inside both array
      then function will return true, else false;
    */

    public Boolean isPalindrome(int[] arr, int size, int start, int end) {
      if (!isValid(size, start, end)) {
        return false;
      }

      if (start > end) {
       int temp = start;
       start = end;
       end = temp;
      }
      
      while (start < end) {
        if (arr[start++] != arr[end--]) {
          return false;
        }
      }
      return true;
    }

    private Boolean isValid(int size, int start, int end) {
      if (start >= size || start < 0 || end >= size || end < 0) {
        return false;
      }
      return true;
    }
}

class Rotation {
  private int[] arr;

  public Rotation(int[] arr) {
    this.arr = arr;
  }

  public void rotate(int times) {
    int i = 0;
    while (i++ < times) {
     rotate();
    }
  }

  private void rotate() {
    for (int i = 0; i < arr.length - 1; i++) {
      int temp = arr[0];
      arr[0] = arr[i + 1];
      arr[i + 1] = temp;
    }    
  }
}