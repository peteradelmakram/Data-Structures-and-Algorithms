package LinkedLists;
import Queues.Queue;

public class QueueDLL {
  DoublyLinkedList Q;
  int size;

  public QueueDLL() {
    Q = new DoublyLinkedList();
    size = 0;
  }

  public void enqueue(Object o) {
    Link x = new Link(o);
    Q.insertLast(x);
    size++;
  }

  public Object dequeue() {
    Object x = Q.removeFirst();
    size--;
    return x;
  }

  public Object peek() { return Q.getFirst(); }

  public boolean isEmpty() { return Q.isEmpty(); }

  public int size() { return size; }

  public static void main(String[] args) {
    QueueDLL Queue = new QueueDLL();
    Queue.enqueue(1);
    Queue.enqueue(2);
    Queue.enqueue(3);
    Queue.enqueue(4);
  }
}
