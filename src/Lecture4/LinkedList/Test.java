import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    var list = new LinkedList();
    var sc = new java.util.Scanner(System.in);
      for (int i = 0; i < 5; i++) {
        list.insert(5,sc.nextInt(), i);
      }
 
    
    // list.rotateRight();
    // list.rotateRight();
    list.printDuplicate();
    // list.print();
  }
}

class LinkedList {

  private class Node {
    private Node next;
    private int element;

    public Node(int element, Node next) {
      this.element = element;
      this.next = next;
    }
  }

  private Node head;
  private Node tail;

  public void insert(int size, int element, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    Node newNode = new Node(element, null);

    if (index == 0) {
      newNode.next = head;
      head = newNode;
    }
    else {
      Node pred = nodeAt(index - 1);
      newNode.next = pred.next;
      pred.next = newNode;
    }
  }

  public Node nodeAt(int index) {
    int c = 0;
    for (Node temp = head; temp != null; temp = temp.next) {
      if (c == index) {
        return temp;
      }
      c++;
    }
    return null;
  }

  public void rotateRight() {
  Node pred = null;
  Node temp = head;

  while (temp.next != null) {
    pred = temp;
    temp = temp.next;
  }

  temp.next = head;
  head = temp;
  pred.next = null;
}

public void printDuplicate() {
  boolean found = false;
  for (Node first = head; first != null; first = first.next) {
    for (Node second = first.next; second != null; second = second.next) {
      if (first.element == second.element) {
          System.out.println(first.element);
          found = true;
          break;
      }
    }
    if (found) {
      break;
    }
  }
}

  public void print() {
    Node node = head;
    while (node != null) {
      System.out.println(node.element);
      node = node.next;
    }
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

//   public void duplicate() {
//     Set<Integer> set = new HashSet<>();

//     Node current = head;
//     Node mid = head.next;

//     tail = head;
//     head.next = null;
//     for (; mid != null; mid = mid.next) {
//     	Node last = mid.next;
//     	mid.next = current;
//     	current = mid;
//     	mid = last;
//     }
//     head = current;

//     // for (Node count = head; count != null; count = count.next) {
//     // 	if (!set.add(count.data)) {
//     // 		System.out.println("found : " + count.data);
//     // 		return;
//     // 	}
//     // } 
// }

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
