import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    var list = new LinkedList<Integer>();
    for (int i = 0; i < 5; i++) {
      list.addLast(10 + i);
    }
    list.insertBefore(list.head, 10, 9);
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
  public void addLast(E newElement) {
    var node = new Node<E>(newElement);

    node.previous = head.previous;
    head.previous.next = head.previous = node;
    node.next = head;
  }

  /**
    * inserts node before the node containing given element
    * @param head head node. e.g. dummy node
    * @param elem existing element
    * @param newElement element to be added
   */
  public void insertBefore(Node<E> head, E elem, E newElement)  {
    var node = new Node<E>(newElement);

    // get the node of given element
    Node<E> current = getNode(head, elem); 

    // inserting node
    node.next = current;
    node.previous = current.previous;
    node.previous.next = current.previous = node;
  }

  /**
    * returns node only if given element exists in the list.
    * @param head head node. e.g. dummy node
    * @param elem element to be matched
    * @return Node object
    * @throws NoSuchElementException if the list is empty or
    * does not contain the given element
   */
  private Node<E> getNode(Node<E> head, E elem) {
    
    for (Node<E> node = head.next; node != head; node = node.next) {
      if (node.element.equals(elem)) {
        return node;
      }
    }
    // from java.util library
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