import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    var list = new LinkedList<Integer>();
    for (int i = 0; i < 5; i++) {
      list.addLast(10 + i);
    }
    list.insertBefore(15, 9);
    list.print();
  }
}

class LinkedList<E> {
  Node<E> head;

  public LinkedList() {
    // dummy Node
    head = new Node<E>(null);
    // making dummy Node circular
    head.next = head.previous = head; 
  }

  /**
  * adds element at the end
  */
  public void addLast(E element) {
    var node = new Node<E>(element);

    node.previous = head.previous;
    head.previous.next = head.previous = node;
    node.next = head;
  }

  public void insertBefore(E elem, E element) {
    /* if user wants to add 'element' before the first 'element',
    add it to the last....then return.
    */
    if (head.next.element.equals(elem)) {
      addLast(element);
      return;
    }

    // else, create 'new node' and add this to before the node containing the given element.
    var node = new Node<E>(element);

    Node<E> current = getNode(elem); // get the node of given element
    node.next = current;
    node.previous = current.previous;
    node.previous.next = current.previous = node;
  }

  private Node<E> getNode(E elem) {
    // returns node only if given element exists in the list
    // else throws exception
    for (Node<E> node = head.next; node != head; node = node.next) {
      if (node.element.equals(elem)) {
        return node;
      }
    }
    throw new NoSuchElementException();
  }

  public void print() {
    Node<E> node = head.next;

    while (node != head) {
      System.out.println(node.element);
      node = node.next;
    }
  }
} 

class Node<E> {
  E element;
  Node<E> previous, next;

  public Node(E element) {
    this.element = element;
  }
}