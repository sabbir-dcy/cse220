import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/* determine the power set
input : [a, b, c]
output : [, a, b, c, ab, bc, ac, abc]
*/

public class Main {
  public static void main(String[] args) {
    String[] arr = {"a", "b", "c", "d"};
    List<String> list = powerSet(arr);
    
    Collections.sort(list);
    int k = 0;
    for (int i = 0; i < list.size(); i++) {
      for (var x : list) {
        if (x.length() == k)
          System.out.println("{"+x+"}");
      }
      k++;
    }
  }

  static List<String> powerSet(String[] str) {
    // auxilary space to be returned
    List<String> list = new ArrayList<>();
    // cardinality of power set = 2^n
    int cardinality = (int)Math.pow(2, str.length);

    for (int i = 0; i < cardinality; i++) {
      // binary form of i as string
      var binary = bin(i);

      /*  bit len == len of the string array
          ex- binary 0f dec 2, is 01(2 bit)..but we need 3 bit [if len of String is 3]
          so..add zeros before binary form
      */
      while (binary.length() != str.length) {
        binary = 0+binary;
      }

      /* combine all 1 value
         ex - bin of 0101 represents {bd} combination
              bin of 1100 represents {ab} combination
      */
      var comb = "";
      
      for (int j = 0; j < str.length; j++) {
        if (binary.charAt(j) == '1')
          comb += str[j]; 
      }
      list.add(comb);
    }
    return list;
  }

  // getting binary form of each value of total cardinality
  static String bin(int n) {
    if (n == 0) return "";
    return bin(n/2) + n%2;
  }
}