/*
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.
 */
class Problem {

  public Node addNumbers(Node a, Node b) {
    int num = toNumber(a) + toNumber(b);  // add number from both linked list

    while (num > 0) {          // insert each digit of num
      insert(num % 10);
      num = num / 10;
    }
    return start;
  }

  Node start;
  public void insert(int data) {
    start = new Node(data, start);   // insert at first
  }

  // using recursion
  private int toNumber(Node n) {
    if (n == null) {
      return 0;
    }
    int num = toNumber(n.next) * 10 + n.data;
    return num;
  }

  // using string [extra space]
  private int toNum(Node n) {
    String s = "";
    for (; n != null; n = n.next) {
      s = n.data + s;
    }
    return Integer.parseInt(s);
  }
}