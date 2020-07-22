
public class Main {
  public static void main(String[] args) {
    var i = 6;
    Node back = null;
    while (i-- > 0) {
      var node = new Node("one", back);
      back = node;
    }
    var head = back;
    var main = new Main();
    String str = new String("one");
    System.out.println(Main.contains(head, str));
    // System.out.println(head.next.next.element);
  }

  public static boolean contains(Node n, Object element) {
    for (; n != null; n = n.next)
      if (n.element.equals(element)) return true;
      return false;
  }
}

class Node {

  Node next;
  Object element;

  public Node(Object element, Node next) {
    this.element = element;
    this.next = next;
  }
}
