public void reverse(int[] arr, int head, int size) {
    int tail = (head + size - 1) % arr.length;
    int laps = 0;

    while (laps++ < arr.length / 2) {
      arr[head] += arr[tail] - (arr[tail--] = arr[head++]);
      head %= arr.length;
      tail = (tail + arr.length) % arr.length;
    }
  }