import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    var list = new LinkedList<Character>();
    String str = "hello";
    for (char c : str.toCharArray()) {
      list.addLast(c);
    }
    System.out.println(Node.size);
    list.print();
  }
}

class LinkedList<E> {
  Node head, tail;

  public LinkedList() {
    // dummy node creation while creating an object of linkedlist class
    head = tail = new Node<E>(null);
  }

  public void addLast(E data) {
    var node = new Node<E>(data);
    tail.next = node;
    tail = node;
  }

  public void addFirst(E data) {
    var node = new Node<E>(data);
    node.next = head.next;
    head.next = node;
  }

  public void insertAt(E data, int index) {
    var node = new Node<E>(data);
    var pred = nodeAt(index - 1);
    node.next = pred.next;
    pred.next = node;
  }

  public void removeAt(int index) {
    if (index < 0 || index >= Node.size) throw new NoSuchElementException();
    var pred = nodeAt(index - 1);
    var current = pred.next;
    pred.next = current.next;
    current.next = null;

  }

  private Node nodeAt(int index) {
    if (index < -1 || index > Node.size) throw new IndexOutOfBoundsException();
    var node = head;
    for (int i = 0; i <= index; i++, node = node.next);
    return node; 
  } 

  public void print() {
    var node = head.next;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }
}

class Node<E> {
  E data;
  Node next;
  static int size;

  public Node(E data) {
    this.data = data;
    size += this.data == null ? 0 : 1;
  }
}