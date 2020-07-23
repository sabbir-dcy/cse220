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
  Vertex<E> head, tail;

  public LinkedList() {
    head = tail = new Vertex<>(null);
  }

  public void addLast(E data) {
    Vertex<E> vtx = new Vertex<>(data);
    
    tail.next = vtx;
    vtx.previous = tail;
    tail = head.previous = vtx;
    tail.next = head;
  }

  public void removeLast() {
    Vertex<E> pred = tail.previous;
    pred.next = head;
    tail.next = tail.previous = null;
    head.previous = tail = pred;
  }

  public void remove(Vertex<E> vtx) {
    if (vtx == head) {
      throw new IndexOutOfBoundsException();
    }

    vtx.previous.next = vtx.next;
    vtx.next.previous = vtx.previous;
    vtx.next = vtx.previous = null;
    // help gc
    vtx.data = null;
  }

  public void print() {
    Vertex<E> vtx = head.next;
    while (vtx != head) {
      System.out.println(vtx.data);
      vtx = vtx.next;
    }
  }

  public void printReverse() {
    Vertex<E> vtx = tail;
    while (vtx != head) {
      System.out.println(vtx.data);
      vtx = vtx.previous;
    }
  }
}

class Vertex<E> {
  E data;
  Vertex<E> previous, next;

  public Vertex(E data) {
    this.data = data;
  }
}