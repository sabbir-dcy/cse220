package link_stack;

public class LinkStack implements Stack {

  private class Vertex {
    private Object data;
    private Vertex next;

    public Vertex(Object data, Vertex next) {
      this.data = data;
      this.next = next;
    }
  }

  private Vertex head;

  public void push(Object data) {
    var vtx = new Vertex(data, head);
    head = vtx;
  }

  public Object peek() {
    return head.data;
  }

  public Object pop() {
    var vtx = head;
    head = head.next;
    vtx.next = null;

    return vtx.data;
  }

  public boolean isEmpty() {
    return head == null;
  }
}