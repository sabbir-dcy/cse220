public class Main {
  public static void main(String[] args) {
    var list = new LinkedList<Integer>();
    for (int i = 0; i < 5; i++) {
      list.addLast(10 + i);
    }
    list.print();
  }
}

class LinkedList<E> {
  Vertex head, tail;

  public LinkedList() {
    head = tail = new Vertex<E>(null);
  }

  public void addLast(E data) {
    var vtx = new Vertex<E>(data);
    tail.next = vtx;
    tail = vtx;
    tail.next = head;
  }

  public void print() {
    var vtx = head.next;
    while (vtx != head) {
      System.out.println(vtx.data);
      vtx = vtx.next;
    }
  }
}

class Vertex<E> {
  E data;
  Vertex next;

  public Vertex(E data) {
    this.data = data;
  }
}