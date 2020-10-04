public class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    
    Node newList = createLinkedList(list);
    list.printElement(newList);
    System.out.println(list.tail.element);
  }

  static Node createLinkedList(LinkedList list) {
    for (int i = 0; i < 5; i++) 
      list.insertBefore(i);
    // list.insertBefore(10);
    return list.head;
  }
}

class LinkedList {
  Node head, tail;

  public void insertBefore(Object element) {
    head = new Node(element, head);
    if (tail == null)
      tail = head;
  }

  public void insertAfter(Object element) {
    Node node = new Node(element, null);
    if (head == null)
      head = tail = node;
    else {
      tail.next = node;
      tail = node;
    }
  }

  public void printElement(Node head) {
    Node node = head;
    while (node != null) {
      System.out.println(node.element);
      node = node.next;
    }
  }
}

class Node {
  Node next;
  Object element;

  Node(Object e, Node next) {
    this.element = e;
    this.next = next;
  }
}