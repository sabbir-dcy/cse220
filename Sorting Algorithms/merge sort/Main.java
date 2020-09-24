import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {6, 3, 1, 7, 10, 12, 8, 4, 2, 5, 11};
    var sort = new Sort(arr);
    sort.sort();
    System.out.println(Arrays.toString(arr));
  }
}

class Sort {
  int[] arr, temp;
  int len;

  public Sort(int[] arr) {
    this.arr = arr;
    this.len = arr.length;
    this.temp = new int[len];
  }

  public void sort() {
    divide(0, len - 1);
  }

  public void merge(int l, int mid, int r) {
    for (int i = l; i <= r; i++) {
      temp[i] = arr[i];
    }
    
    int i = l, j = mid + 1, k = l;

    while (i <= mid && j <= r) {
      if (temp[i] <= temp[j]) {
        arr[k] = temp[i];
        i++;
      } else {
        arr[k] = temp[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      arr[k] = temp[i];
      k++;
      i++;
    }
  }

  public void divide(int l, int r) {
    if (l < r) {
      int mid = (l + r) / 2;

      divide(l, mid);
      divide(mid + 1, r);

      merge(l, mid, r);
    }

  }
}