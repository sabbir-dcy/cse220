public class Main {
  public static void main(String[] args) {
    var list = new LinkedList();
    for (int i = 0; i < 5; i++) {
      list.addLast(20 + i);
    }
    list.doPrint();
  }
}
  
public class LinkedList {
  private class Node {
    private int data;
    private Node next;

    public Node(int data) {
      this.data = data;
    } 
  }


  private Node head, tail;

  public void addLast(int data) {
    var node = new Node(data);
    if (isEmpty(head)) 
      head = tail = node;
    else {
     tail.next = node;
     tail = node;
     tail.next = head;
    } 
  }

  private boolean isEmpty(Node n) {
    return n == null;
  }

  public void print() {
    Node node, temp;
    node = temp = head;

    while (temp.next != head) {
      temp = node;
      System.out.println(temp.data);
      node = node.next;
    }
  }

  public void doPrint() {
    var node = head;
    do {
      System.out.println(node.data);
      node = node.next;
    }
    while (node != head);
  }
}