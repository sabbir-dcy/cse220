public class Main {
  public static void main(String[] args) {
    var list = new LinkedList();
    for (int i = 0; i < 5; i++) {
      list.addLast(20 + i);
    }
    list.insert(99, 4); // including 5
    list.print();
    System.out.println(list.size());
  }
}
  
public class LinkedList {
  /* 
  * size var counts the size,
  * can not declare as static inise node (nestsed) class,
  * that is why declaring as an instance of linked list class.
  * note: in order to declare as static inside node class node
  * should not be nested...e.g node should public in general
  */
  private int size; 

  private class Node {
    private Object data;
    private Node next;

    public Node(Object data) {
      this.data = data;
      /*
      * as its a nummy headed linked list,
      * dummy node will not be included to size
      * if node is null (dummy) additioin 0..e.g no change in size
      * else size increase
      */
      size += data != null ? 1 : 0;
    } 
  }
  // head and tail points to the dummy node inititally
  // note: can not do 'just declare' & 'then define' outside of functions
  // that is why both creating 'dummy' node and initializing to 'head'
  /* private head;
  head = new Node(null);  -/...........<identifier> expected error
  */

  private Node head = new Node(null);
  private Node tail = head;

  public void addLast(Object data) {
    /**
    * node need to check for head is null or not,
    * beacause, already defined head as a dummy node
    * so 'head' can not be null node..but, the data it contains..is null
    */
    var node = new Node(data);
    tail.next = node;
    tail = node;
  }

  /**
  * returns true if given node is null
  * @return {code = true}
  */
  private boolean isEmpty(Node n) {
    return n == null;
  }

  public void insert(Object data, int index) {
    if (index < 0 || index > size) throw new IndexOutOfBoundsException();

    var node = new Node(data);
    var pred = nodeAt(index - 1); // previous node of given index
    node.next = pred.next;
    pred.next = node;
  }

  private Node nodeAt(int index) {
    /**
    * if the user want to insert value at 0th index
    * previous node will be 'dummy'.
    * var node holds the 'dummy node'*/
    var node = head;
    for (int i = 0; i <= index; i++) {
      node = node.next;
    }
    return node;
  } 

  public int size() {
    return size;
  }

  public void print() {
    // start printing from head.next...e.g skip the dummy node
    var node = head.next;
    while (!isEmpty(node)) {
      System.out.println(node.data);
      node = node.next;
    }
  }
}

