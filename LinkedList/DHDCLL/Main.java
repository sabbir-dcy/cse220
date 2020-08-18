public class Main {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      list.addLast(10 + i);
    }
    list.remove(list.head.next);
    list.print();
  }
}

class LinkedList<E> {
  Node<E> head, tail;

  public LinkedList() {
    head = tail = new Node<>(null);
  }

  public void addLast(E data) {
    Node<E> node = new Node<>(data);
    
    tail.next = node;
    node.previous = tail;
    tail = head.previous = node;
    tail.next = head;
  }

  public void removeLast() {
    Node<E> pred = tail.previous;
    pred.next = head;
    tail.next = tail.previous = null;
    head.previous = tail = pred;
  }

  public void remove(Node<E> node) {
    if (node == head) {
      throw new IndexOutOfBoundsException();
    }

    node.previous.next = node.next;
    node.next.previous = node.previous;
    node.next = node.previous = null;
    // help gc
    node.data = null;
  }

  public void print() {
    Node<E> node = head.next;
    while (node != head) {
      System.out.println(node.data);
      node = node.next;
    }
  }

  public void printReverse() {
    Node<E> node = tail;
    while (node != head) {
      System.out.println(node.data);
      node = node.previous;
    }
  }
}

class Node<E> {
  E data;
  Node<E> previous, next;

  public Node(E data) {
    this.data = data;
  }
}