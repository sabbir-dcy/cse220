package resize_circular_array;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {3, 4, 5, 1, 2};
    var resize = new Resize(arr);
    arr = resize.expand(3, 5, 2);
    System.out.println(Arrays.toString(arr));
  }
}

class Resize {
  int[] nativeArr;

  public Resize(int[] arr) {
    this.nativeArr = arr;
  }

  public int[] expand(int start, int size, int increaseBy) {
    int[] resizedArr = new int[lenOf(nativeArr) + increaseBy];
    var resizeIndex = start;
    for (var i = 0; i < size; i++) {
      resizedArr[resizeIndex] = nativeArr[start];
      start = (start + 1) % lenOf(nativeArr);
      resizeIndex = (resizeIndex + 1) % lenOf(resizedArr);
    }
    return resizedArr;
  }

  private int lenOf(int[] arr) {
    return arr.length;
  }
}