package LinkedLists;
class Link {
  public Object data;
  public Link next;
  public Link previous;

  public Link(Object o) { data = o; }

  public String toString() { return data.toString(); }
}

public class DoublyLinkedList {
  private Link first; // reference to first link on list
  private Link last;  // reference to first link on list

  public DoublyLinkedList() {
    first = null;
    last = null;
  }

  public boolean isEmpty() { return (first == null); }

  public void insertFirst(Object d) {
    Link newLink = new Link(d);
    if (isEmpty()) {
      last = newLink;
    } else {
      first.previous = newLink;
    }
    newLink.next = first;
    first = newLink;
  }

  public void insertLast(Object d) {
    Link newLink = new Link(d);
    if (isEmpty())
      first = newLink;
    else {
      last.next = newLink;
      newLink.previous = last;
    }
    last = newLink;
  }

  public Object removeFirst() {
    Object temp = first.data;
    if (first.next == null)
      last = null;
    else
      first.next.previous = null;
    first = first.next;
    return temp;
  }

  public Object removeLast() {
    Object temp = last.data;
    if (first.next == null)
      first = null;
    else
      last.previous.next = null;
    last = last.previous;
    return temp;
  }

  public Object getFirst() { return first.data; }

  public Object getLast() { return last.data; }

  public void displayForward() {
    System.out.print("[ ");
    Link current = first;
    while (current != null) {
      System.out.print(current + " ");
      current = current.next;
    }
    System.out.println("]");
  }

  public void displayBackward() {
    System.out.print("[ ");
    Link current = last;
    while (current != null) {
      System.out.print(current + " ");
      current = current.previous;
    }
    System.out.println("]");
  }

  public int countIter() {
    Link curr = first;
    int count = 0;

    while (curr != null) {
      count++;
      curr = curr.next;
    }

    return count;
  }

  public int countRec() {
    Link curr = first;
    return countRecHelper(curr);
  }

  public int countRecHelper(Link curr) {
    if (curr == null)
      return 0;

    return 1 + countRecHelper(curr.next);
  }

  public int maxInList() {
    Link curr = first;
    int max = 0;

    while (curr != null) {
      if ((Integer)curr.data > max) {
        max = (Integer)curr.data;
      }

      curr = curr.next;
    }
    return max;
  }

  public boolean insertAfter(Object key, Object dd) {
    Link x = new Link(dd);
    boolean flag = false;
    Link curr = first;

    while (curr != null) {
      if (curr.data.equals(key)) {
        if (curr.next != null) {
          Link nxt = curr.next;
          curr.next = x;
          x.next = nxt;
          x.previous = curr;
          nxt.previous = x;

        } else {
          curr.next = x;
          x.previous = curr;
          last = x;
        }
        flag = true;
      }
      curr = curr.next;
    }

    return flag;
  }

  public boolean insertBefore(Object key, Object dd) {
    boolean flag = false;
    Link x = new Link(dd);
    Link curr = first;

    while (curr != null) {

      if (curr.data.equals(key)) {
        if (curr.previous != null) {
          Link prev = curr.previous;
          prev.next = x;
          x.next = curr;
          x.previous = prev;
          curr.previous = x;
        } else {
          x.next = curr;
          curr.previous = x;
          first = x;
        }
        flag = true;
      }

      curr = curr.next;
    }
    return flag;
  }

  public void deleteKey(Object key) {
    Link curr = first;

    while (curr != null) {
      if (curr.data.equals(key)) {
        break;
      }
      curr = curr.next;
    }

    if (curr == first) {
      first = curr.next;
    } else if (curr == last) {
      last = curr.previous;
    } else {
      curr.previous.next = curr.next;
      curr.next.previous = curr.previous;
      curr.next = null;
      curr.previous = null;
    }
  }

  public void insertToSorted(Comparable o) {
    Link x = new Link(o);
    Link curr = first;

    if (first == null) {
      first = x;
      last = x;
      return;
    }

    while (curr != null) {
      if (o.compareTo((Comparable)curr.data) < 0) { // o < curr.data
        x.next = curr;
        x.previous = curr.previous;

        // If the node is at the beginning.
        if (curr.previous != null) {
          curr.previous.next = x;
        } else {
          first = x;
        }
        curr.previous = x;
        break;
      }
      // If the node is at the end
      if (curr.next == null) {
        curr.next = x;
        x.previous = curr;
        last = x;
        break;
      }
      curr = curr.next;
    }
  }

  public void insertionSort() {
    DoublyLinkedList tmp = new DoublyLinkedList();
    Link curr = first;

    while (curr != null) {
      tmp.insertToSorted((Comparable)curr.data);
      curr = curr.next;
    }

    first = tmp.first;
    last = tmp.last;
  }

  public void reverse() {
    Link l = first;

    while (l != null) {
      if (l.previous == null) {
        last = l;
      }
      if (l.next == null) {
        first = l;
      }

      Link tmp = l.previous;
      l.previous = l.next;
      l.next = tmp;

      l = l.previous;
    }
  }

  public void reverseRec() {
    Link curr = first;
    reverseRecHelper(curr);
  }

  public void reverseRecHelper(Link curr) {
    if (curr == null) {
      return;
    }

    if (curr.previous == null) {
      last = curr;
    }
    if (curr.next == null) {
      first = curr;
    }

    Link tmp = curr.previous;
    curr.previous = curr.next;
    curr.next = tmp;
    reverseRecHelper(curr.previous);
  }

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    list.insertLast(1);
    list.insertLast(4);
    list.insertLast(3);
    list.insertLast(5);

    list.displayForward();

    list.reverseRec();
    list.displayForward();
  }
}