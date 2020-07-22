public class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    for (int i = 0; i < 5; i++) {
      list.addLast(i + 1);
    }
    list.print();

  }
}

class LinkedList {
  Node head;
  Node tail;

  public void addLast(int element) {
    Node node = new Node(element);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
  }

  public void print() {
    for (Node temp = head; temp != null; temp = temp.next) {
      System.out.println(temp.element);
    }
  }
}

class Node {
  int element;
  Node next, prev;

  public Node(int element) {
    this.element = element;
  }
}