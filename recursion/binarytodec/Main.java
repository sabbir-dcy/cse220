public class Main {
  public static void main(String[] args) {
    System.out.println(decimal(1011, 0));
    System.out.println(binary(2));
  }

  static int decimal(int bin, int i) {
    if (bin == 0) return 0;
    int rem = bin%10;
    int n = (int)Math.pow(2, i);
    return n * rem + decimal(bin/10, i+1);
  }

  static int binary(int dec) {
    if (dec == 0) return 0;
    return binary(dec/2)*10 + dec%2;
  }
}