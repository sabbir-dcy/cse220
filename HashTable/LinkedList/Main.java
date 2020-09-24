public class Main {
  public static void main(String[] args) {
    HashTable<String, String> map = new HashTable<>(); // in terms of key only String and int allowed
    map.put("A", "Luther");
    map.put("B", "Alex");
    map.put("C", "Lucy");
    map.put("D", "Ron");

    System.out.println(map.get("A"));
    System.out.println(map.get("B"));
    System.out.println(map.get("E"));

    System.out.println("removed : " + map.remove("A").value);
    System.out.println("removed : " + map.remove("D").value);

    System.out.println("check existence of Lucy : " + map.get("A"));


  }

}

class Entry<E, T> { // <E> -> type of key & <T> -> is type of the value
  E key;
  T value;

  public Entry(E key, T val) {
    this.key = key;
    this.value = val;
  }
}

class HashTable<E, T> { // <E> -> type of key & <T> -> is type of the value
  LinkedList<Entry<E, T>>[] entries;

  @SuppressWarnings("unchecked")
  public HashTable() {
    entries = new LinkedList[5];
  }

  public void put(E key, T val) {
    int index = hashCode(key);

    if (entries[index] == null) {
      entries[index] = new LinkedList<>();
    }
    LinkedList<Entry<E, T>> list = entries[index];
    Node<Entry<E, T>> node = list.head;
    while (node != null) {
      if (node.element.key == key) {
        node.element.value = val;
        return;
      }
      node = node.next;
    }
    Entry<E, T> entry = new Entry<>(key, val);
    list.insert(entry);
  }

  private int hashCode(E key) {
    String s = String.valueOf(key);
    int hash = 0;
    for (char c : s.toCharArray()) {
      hash += c;
    }
    return hash % 5;
  }

  public T get(E key) {
    int index = hashCode(key);
    if (entries[index] == null)
      return null;
      
    LinkedList<Entry<E, T>> list = entries[index];
    Node<Entry<E, T>> node = list.head;
    while (node != null) {
      Entry<E, T> e = node.element;
      if (e.key == key)
        return e.value;
      node = node.next;
    }
    return null;
  }

  public Entry<E, T> remove(E key) {
    int index = hashCode(key);
    LinkedList<Entry<E, T>> list = entries[index];
    Node<Entry<E, T>> node = list.head;
    while (node != null) {
      Entry<E, T> entry = node.element;
      if (entry.key == key) {
        return list.remove(entry);
      }
      node = node.next;
    }
    return null;
  }
}

class LinkedList<T> { // <T> is Entry type
  Node<T> head, tail;

  public void insert(T element) {
    Node<T> node = new Node<>(element);

    if (head == null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
  }

  public T remove(T target) {
    Node<T> tgNode = find(target);
    Node<T> node = head, temp = null;
    if (tgNode == head) {
      head = head.next;
      tgNode.next = null;
      return target;
    }
    while (node != null) {
      if (node == tgNode) {
        temp.next = node.next;
        node.next = null;
        break;
      }
      temp = node;
      node = node.next;
    }
    return target;
  }

  private Node<T> find(T target) {
    Node<T> node = head;
    while (node != null) {
      if (node.element == target) {
        return node;
      }
      node = node.next;
    }
    return null;
  }
}

class Node<T> { // T is entry type
  Node<T> next;
  T element;

  public Node(T element) {
    this.element = element;
  }
}



