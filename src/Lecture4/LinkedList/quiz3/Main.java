import java.util.Set;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) {
    
    var main = new Main();
    Node head = null;

    var sc = new java.util.Scanner(System.in);
    for (int i = 0; i < 5; i++) {
      head = main.insert(head, sc.nextInt(), i);
    }
    // var temp = head;
    // while (temp != null) {
    //   System.out.println(temp.element);
    //   temp = temp.next;
    // }
    // System.out.println(".............");
    // main.printDuplicate(head);
    // System.out.println(">>>>>>>>>>>>");
    // System.out.println(head.element);

    main.printDup(head);
  }

  public Node insert(Node head, Object element, int index) {
    var node = new Node(element, null);
    if (index == 0) {
      node.next = head;  // next = null
      head = node;  // head = new node
    }
    else {
      Node pred = nodeAt(head, index - 1);
      node.next = pred.next;
      pred.next = node;
    }
    return head;
  }

  public Node nodeAt(Node head, int index) {
    for (int c = 0; c < index; head = head.next, c++); 
    return head;
  }

  /**
   * Prints the first duplicate element found inside the list.
   * Elements from the list will be added to set {@link java.util.Set HashSet},
   * add method returns {@code true} if the element to be added
   * already not exist.
   *
   * @param head the pointer to the first node of the list.
   */
  public void printDuplicate(Node head) {
    Set<Object> set = new HashSet<>();
    for (; head != null; head = head.next)
      if (!set.add(head.element)) {
        System.out.println(head.element);
        return;
      }
  }

  public void printDup(Node head) {
    for (; head != null; head = head.next) {
      for (Node successor = head.next; successor != null; successor = successor.next) {
        if (head.element == successor.element) {
          System.out.println(">>>>>>>>>>>>\n" + head.element);
          return;
        }
      }
    }
  }
}

class Node {

  Node next;
  Object element;

  public Node(Object element, Node next) {
    this.element = element;
    this.next = next;
  }
}