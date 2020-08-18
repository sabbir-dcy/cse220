import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = {5, 1, 4, 2, 6, 3};
		bubble(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubble(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

