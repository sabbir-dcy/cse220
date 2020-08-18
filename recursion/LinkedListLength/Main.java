package single;

public class Main {
  public static void main(String[] args) {
    LinkedList list1 = new LinkedList();

    for (int i = 0; i < 5; i++) {
      list1.add(i + 1);
    }
    System.out.println(list1.len(list1.head));
    System.out.println(list1.sumOfElement(list1.head));
  }
}

class LinkedList {
  Node head;
  Node tail;

  public void add(Object element) {
    Node n = new Node(element);

    if (head == null) {
      head = n;
      tail = n;
    }else {
      tail.next = n;
      tail = n;
    }
  }

  public int len(Node n) {
    if (n == null) {
      return 0;
    }
    return 1 + len(n.next);
  }

  public int sumOfElement(Node n) {
    if (n == null) {
      return 0;
    }
    return (int)n.element + sumOfElement(n.next);
  }

}

class Node {
  Object element;
  Node next;
  static int size;

  public Node(Object element) {
    this.element = element;
    size++;
  }
}