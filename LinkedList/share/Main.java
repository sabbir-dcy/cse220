import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    var list = new LinkedList();
    for (int i = 0; i < 5; i++) {
      list.addLast(10 + i);
    }
    list.insertBefore(list.head, 10, 9);
    list.print();
    // System.out.println(list.head.preve.element);
  }
}

class LinkedList {
  Node head;

  public LinkedList() {
    head = new Node(null);
    head.next = head.preve = head; 
  }

  public void addLast(Object newElement) {
    Node newNode = new Node(newElement);

    newNode.preve = head.preve;
    head.preve.next = head.preve = newNode;
    newNode.next = head;
  }

  public void insertBefore(Node head, Object elem, Object newElement)  {
    Node newNode = new Node(newElement);

    Node elemNode = nodeAt(head, elem);
    Node elemPred = elemNode.preve;

    newNode.next = elemNode;
    newNode.preve = elemPred;

    elemPred.next = elemNode.preve = newNode;
  }

  public Node nodeAt(Node head, Object elem) {
    Node n = head.next;
    while (n != head) {
      if (n.element == elem) {
        return n;
      }
      n = n.next;
    }
    throw new IndexOutOfBoundsException();
  }

  public void print() {
    Node n = head.next;

    while (n != head) {
      System.out.println(n.element);
      n = n.next;
    }
  }
} 

class Node {
  Object element;
  Node preve, next;

  public Node(Object element) {
    this.element = element;
  }
}