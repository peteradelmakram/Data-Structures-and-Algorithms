package LinkedLists;
public class LinkedList {
  private ListNode head;

  class ListNode {
    public Object data;
    public ListNode next;

    public ListNode(Object data) {
      this.data = data;
      this.next = null;
    }

    public String toString() { return data.toString(); }
  }

  public LinkedList() { this.head = null; }

  public void insertFirst(Object obj) {
    ListNode newLink = new ListNode(obj);
    newLink.next = head;
    head = newLink;
  }

  public Object removeFirst() {
    if (head == null)
      return null;
    Object res = head.data;
    head = head.next;
    return res;
  }

  public void inerstLast(Object obj) {
    ListNode newNode = new ListNode(obj);
    if (head == null) {
      head = newNode;
      return;
    }
    ListNode curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = newNode;
  }

  public Object removeLast() {
    if (head.next == null) {
      Object res = head.data;
      head = null;
      return res;
    }
    ListNode curr = head;
    while (curr.next.next != null) {
      curr = curr.next;
    }
    Object temp = curr.next.data;
    curr.next = null;
    return temp;
  }
}
