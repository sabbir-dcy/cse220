public class Main {
  public static void main(String[] args) {
    System.out.println(expo(2, 4));
    System.out.println(expoHalf(2, 4));
  }

  static int expo(int number, int pow) {
    if (pow == 0) {
      return 1;
    }
    return number * expo(number, pow - 1);
  }

  static int expoHalf(int number, int pow) {
    if (pow == 0) {
      return 1;
    }
    int x = expoHalf(number, pow/2);
    if (pow % 2 == 0) {
      return x * x;
    } else {
      return number * x * x;
    }
  }
}