public class Main {
  public static void main(String[] args) {
    String str = "ABCDEF";
    System.out.println(len(str));
  }

  public static int len(String str) {
    if (str.equals("")) return 0;
    return 1 + len(str.substring(1));
  }
}