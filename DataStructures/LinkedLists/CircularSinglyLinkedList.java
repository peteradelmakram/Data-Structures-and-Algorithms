package LinkedLists;
import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
  private ListNode last;
  private int length;

  private class ListNode {
    private ListNode next;
    private Object data;

    public ListNode(Object data) { this.data = data; }
  }

  public CircularSinglyLinkedList() {
    last = null;
    length = 0;
  }

  public boolean isEmpty() { return length == 0; }

  public void print() {
    if (last == null)
      return;
    ListNode first = last.next;
    while (first != last) {
      System.out.print(first.data + " --> ");
      first = first.next;
    }
    System.out.print(first.data);
  }

  public void insertFirst(Object value) {
    ListNode temp = new ListNode(value);
    if (last == null)
      last = temp;
    else {
      temp.next = last.next;
    }
    last.next = temp;
    length++;
  }

  public void insertLast(Object value) {
    ListNode temp = new ListNode(value);
    if (last == null) {
      last = temp;
      last.next = last;
    } else {
      temp.next = last.next;
      last.next = temp;
      last = temp;
    }
    length++;
  }

  public Object removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    ListNode head = last.next;
    if (last.next == last) {
      last = null;
    } else {
      last.next = head.next;
    }
    head.next = null;
    length--;
    return head.data;
  }
  public static void main(String[] args) {
    CircularSinglyLinkedList list = new CircularSinglyLinkedList();
    list.insertLast(20);
    list.insertLast(40);
    list.insertLast(60);
    list.insertLast(80);
    list.insertLast(100);
    list.insertLast(120);
    list.removeFirst();
    list.print();
  }
}
