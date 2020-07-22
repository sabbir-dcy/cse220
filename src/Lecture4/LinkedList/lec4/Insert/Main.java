import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    var list = new LinkedList();
    var sc = new java.util.Scanner(System.in);
    for (int i = 0; i < 5; i++) {
      list.addLast(sc.nextInt());
    }

    list.insert(99, 1);
    // list.duplicate();
    list.print();
  }
}

class LinkedList {

  private class Node {
    private Node next;
    private Object element;

    public Node(Object element) {
      this.element = element;
    }
  }

  private Node head;
  private Node tail;

  /**
   * inserts value to the position asked for
   * note: can insert value after the tail
   * @param element element to be inserted
   * @param index position of the node
   */
  public void insert(Object element, int index) {
    // head is an instance variable inside node class
    // so..not taking as argument.
    // No need of 'size'...'nodeAt' function handles the
    // null pointer exception that occurs after the end of list
    
    var newNode = new Node(element); // node class constructor takes only one argument

    if (index == 0) {
      newNode.next = head;
      head = newNode;
      return;
    }
    var pred = nodeAt(index - 1);  // previous node of desired position
    newNode.next = pred.next;
    pred.next = newNode;
  }

  /**
   * returns previous node
   * @param index is for determining position
   * @return predecessor of current node
   */
  private Node nodeAt(int index) {
    var current = head;
    int i = 0;

    // if the desired position for inserting elemenet
    // is negative then throws exception immediately
    while (current != null && index >= 0) {
      if (index == i++) {
        return current;
      }
      current = current.next;
    }
    throw new IndexOutOfBoundsException();
  }

    public void addLast(Object item) {
    var node = new Node(item);

    if (isEmpty(head)) {
      head = tail = node;
    } 
    else {
      tail.next = node;
      tail = node;
    }
  }

  public void print() {
    Node node = head;
    while (!isEmpty(node)) {
      System.out.println(node.element);
      node = node.next;
    }
  }

  public boolean isEmpty(Node n) {
    return n == null;
  }

  public void duplicate() {
    Set<Object> set = new HashSet<>();

    Object dup = null;
    for (var n = reverse(head); n != null; n = n.next) {
    	if (!set.add(n.element)) {
    		dup = n.element;
    	}
    }
    System.out.println("dup : "+dup);
  }

  private Node reverse(Node head) {
    var current = head;
    var mid = head.next;
    tail = head;
    head.next = null;

    while (mid != null) {
    	var last = mid.next;
    	mid.next = current;
    	current = mid;
    	mid = last;
    }
    return current;
  }
}











//   private boolean isEmpty(Node obj) {
//     return obj == null;
//   }

//   public void addLast(int item) {
//     var node = new Node(item);

//     if (isEmpty(head)) {
//       head = tail = node;
//     } 
//     else {
//       tail.next = node;
//       tail = node;
//     }
//   }



//   public void addFirst(int item) {
//     var node = new Node(item);
//     if (isEmpty(head)) {
//       head = tail = node;
//     } 
//     else {
//       node.next = head;
//       head = node;
//     }
//   }

//   public void removeFirst() {
//     if (!isEmpty(head)) {
//       head = head.next;
//     } else {
//       throw new IllegalArgumentException();
//     }

  // public Node insert(int element, int index) {
  // 	int i = 0;
  // 	Node pred = null;

  // 	for (Node node = head; node.next != null; node = node.next) {
  // 		if (index == i) {
  // 			pred = node;
  // 			break;
  // 		}
  // 		i++;
  // 	}

  // 	if (pred == null) {
  // 		throw new IndexOutOfBoundsException();
  // 	}

  // 	else {
  // 		Node node = new Node(element, null);
  // 		node.next = pred.next;
  // 		pred.next = node;
  // 	}
  // }

  // public void print() {
  //   Node node = head;
  //   while (!isEmpty(node)) {
  //     System.out.println(node.data);
  //     node = node.next;
  //   }
  // }
