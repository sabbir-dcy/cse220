public class Main {
  public static void main(String[] args) {
    var list = new LinkedList<Integer>();
    for (int i = 0; i < 5; i++) {
      list.addLast(10 + i);
    }
    list.printReverse();
  }
}


class LinkedList<E> {
  Vertex head, tail;

  public LinkedList() {
    head = tail = new Vertex<E>(null);
  }

  public void addFirst(E data) {
    var vtx = new Vertex<E>(data);
    vtx.next = head.next;
    head.next = vtx;
    vtx.previous = head;
  }

  public void addLast(E data) {
    var vtx = new Vertex<E>(data);
    tail.next = vtx;
    vtx.previous = tail;
    tail = vtx;
  }

  public void print() {
    var vtx = head.next;
    while (vtx != null) {
      System.out.println(vtx.data);
      vtx = vtx.next;
    }
  }

  public void printReverse() {
    var vtx = tail;
    while (vtx != head) {
      System.out.println(vtx.data);
      vtx = vtx.previous;
    }
  }
}

class Vertex<E> {
  E data;
  Vertex previous, next;

  public Vertex(E data) {
    this.data = data;
  }
}

