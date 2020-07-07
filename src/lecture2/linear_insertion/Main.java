public class Main {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 0, 0, 0};
    var main = new Main();
    main.insert(arr, 6, 2, 22);
    for (int x : arr) {
      System.out.println(x);
    }
  }

  public void insert(int[] arr, int size, int pos, int value) {
    if (arr.length == size) {
      System.out.println("no space left");
      return;
    }
    if (pos >= arr.length || pos < 0) {
      System.out.println("invalid index given");
      return;
    }

    for (int i = size - 1; i >= pos; i--) {
      arr[i + 1] = arr[i];
    }
    arr[pos] = value;
  }
}