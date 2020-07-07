public class Main {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 0, 0, 0};
    remove(arr, 6, 2);
    for (int x : arr) {
      System.out.println(x);
    }
  }

  public static void remove(int[] arr, int size, int pos) {
    for (int i = pos; i < size - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[size - 1] = 0;
    
    /** 1, 2, 3, 4, 5, 6, 0
        loop will run till index 5
        and index 6 which has 0 will also be shifted left
        thats why no need to assign 0 to the last index
        explicitly after the loop breaks

        however, if the length of the array and size is same
        then have to assign 0 at the last index
        and condition should be (size - 1)
    */

  }
}