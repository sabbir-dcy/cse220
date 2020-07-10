import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 0, 0, 0};
    /** 
     1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0
     0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7
     0, 1, 2, 3, 4, 5, 6, 7, 0, 0, 0
     3, 4, 5, 6, 7, 0, 0, 0, 0, 1, 2
     6, 7, 0, 0, 0, 0, 1, 2, 3, 4, 5
    */ 
    var modify = new Modify();
    modify.rev(arr);
    System.out.println(Arrays.toString(arr));
  }
}

class Modify {

  public void rev(int[] arr) {
  	int head = 0, tail = arr.length - 1, size = 0;
  	if (!isLinear) {
  		int[] ind = getIndexes();
  		head = ind[0];
  		tail = ind[1];
  	}

  	if (head < tail) {
    	size = tail - head + 1;
    }
    else {
    	size = arr.length + tail - head + 1;
    }
    int c = 0;
    while (c++ < size / 2) {
      arr[head] += arr[tail] - (arr[tail--] = arr[head++]);
      head %= arr.length;
      tail = (tail + arr.length) % arr.length;
    }
  }

  public Boolean isLinear(int[] arr) {
  	for (int i = 0; i < arr.length; i++) {
  		if (arr[i] == 0) {
  			return false;
  		}
  	}
  	return true;
  }

  private int[] getIndexes(int[] arr) {
  	int len = arr.length;
    int i = 0;
    int head = 0, tail = len - 1;

  	while (true) {
      if (arr[i] != 0) {
        i++;
      }
      else {
        tail = (i + len - 1) % len;
        while (arr[tail] == 0) {
          tail--;
        }
        break;
      }
    }
    while (true) {
      if (arr[i] == 0) {
        i = (i + 1) % len;
      }
      else {
        head = i;
        break;
      }
    }
    int[] ind = {head, tail};
    return ind;
  }
}
