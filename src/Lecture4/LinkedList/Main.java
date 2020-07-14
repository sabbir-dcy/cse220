public class Main {
  public static void main(String[] args) {
    // var n4 = new Node(40, null);
    // var n3 = new Node(30, n4);
    // var n2 = new Node(20, n3);
    // var n1 = new Node(10, n2);
    // var head = n1;

    var m = new Main();
    var i = 5;
    Node back = null;
    while (i-- > 0) {
      var node = new Node(i, back);
      back = node;
    }
    var head = back;
    // new Main().set(head, 2, 99);
    var temp = head;
    while (temp != null) {
      System.out.println(temp.toString());
      temp = temp.next;
    }
  }

  public static Object get(Node head, int index) {
    var c = 0;
    for (var node = head; node != null; node = node.next) {
      if (c++ == index) {
        return node.data;
      }
    }
    return "wrong input"; // -1, false
  }

  public void set(Node head, int index, Object data) {
    Node temp = head, pre = temp;
    for (var i = 0; i < index; i++) {
      pre = temp;
      temp = temp.next;
    }
    var node = new Node(99, temp);
    pre.next = node;
  }
}

public class Node {
  Object data;
  Node next;
  public Node(Object data, Node next) {
    this.data = data;
    this.next = next;
  }
}