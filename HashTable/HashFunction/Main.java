import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    System.out.println(hash("123456-A"));
    put(123, "A");
    System.out.println(Arrays.toString(arr));
  }

  // for integer type of key
  public static int hash(int n) {
    return n % arr.length;
  } 

  // for String type of key
  public static int hash(String str) {
    int i = 0;
    for (char ch : str.toCharArray()) {
      i += ch;
    }
    return i % arr.length;
  }
  // test with an array
  static String[] arr = new String[10];
  public static void put(int n, String s) {
    arr[hash(n)] = s;
  }
}