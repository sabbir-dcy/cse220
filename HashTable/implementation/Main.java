import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    HashTable ht = new HashTable();
    ht.put(1, "a");
  }
}

class HashTable {
  LinkedList<Entry>[] entries = new LinkedList[5];

  public void put(int k, String v) {
    var entry = new Entry(k, v);
    var index = hash(k);
    if (entries[index] == null)
      entries[index] = new LinkedList<>();
    entries[index].addLast(entry);
  }
  
  private int hash(int key) {
    return key % entries.length;
  }
}

class Entry {
  int key;
  String value;

  public Entry(int k, String v) {
    key = k;
    value = v;
  }
}