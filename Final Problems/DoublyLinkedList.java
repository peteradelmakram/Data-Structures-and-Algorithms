package Finals;

public class DoublyLinkedList {
    class Link {
        public Object data;
        public Link next;
        public Link previous;

        public Link(Object o) {
            data = o;
        }

        public String toString() {
            return data.toString();
        }
    }

    private Link first; // reference to first link on list
    private Link last;
    private int size; // reference to first link on list

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(Object d) {
        Link newLink = new Link(d);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
        size++;
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
        size++;
    }

    public Object removeFirst() {
        Object temp = first.data;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        size--;
        return temp;
    }

    public Object removeLast() {
        Object temp = last.data;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        size--;
        return temp;
    }

    public Object getFirst() {
        return first.data;
    }

    public Object getLast() {
        return last.data;
    }

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

    public int size(){
        return size;
    }

    /* START OF FINAL PROBLEMS: */
    // Exercise 8-5 : a) Insert After. Insert Object dd after element key.
    public void insertAfter(Object dd, Object key) {
        Link n = new Link(dd);
        Link curr = first;

        while (curr != null) {
            if (curr.data.equals(key)) {
                break;
            }
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if (curr.next != null) {
            Link nxt = curr.next;
            curr.next = n;
            n.previous = curr;
            n.next = nxt;
            nxt.previous = n;
        } else {
            curr.next = n;
            n.previous = curr;
        }
    }

    // b) Insert before, Insert object dd before element key.
    public void insertBefore(Object dd, Object key) {
        Link n = new Link(dd);
        Link curr = first;

        while (curr != null) {
            if (curr.data.equals(key)) {
                break;
            }
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if (curr.previous != null) {
            Link prev = curr.previous;
            curr.previous = n;
            n.next = curr;
            prev.next = n;
            n.previous = prev;
        } else {
            curr.previous = n;
            n.next = curr;
        }
    }

    // c) delete key:
    public void deleteKey(Object key) {
        Link curr = first;

        while (curr != null) {
            if (curr.data.equals(key)) {
                break;
            }
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if (curr == first) {
            first = curr.next;
            curr.next.previous = null;
        } else if (curr == last) {
            last = curr.previous;
            curr.previous.next = null;
        } else {
            curr.previous.next = curr.next;
            curr.next.previous = curr.previous;
        }
        curr.next = null;
        curr.previous = null;
    }

    // d) Insert to sorted LL:
    public void insertToSorted(Comparable key) {
        Link n = new Link(key);
        Link curr = first;
        if (first == null) {
            first = n;
            last = n;
            return;
        }

        while (curr != null) {
            Comparable c = (Comparable) curr.data;
            if (c.compareTo(key) > 0) {
                break;
            }
            curr = curr.next;
        }

        if (curr == first) {
            n.next = curr;
            curr.previous = n;
            first = n;
        } else if (curr == last || curr == null) {
            last.next = n;
            n.previous = last;
            last = n;
        } else {
            n.next = curr;
            n.previous = curr.previous;
            curr.previous.next = n;
            curr.previous = n;
        }
    }

    // f) Insertion sort: using the insert to sorted method.
    public void insertionSort() {
        DoublyLinkedList res = new DoublyLinkedList();
        Link curr = first;

        while (curr != null) {
            res.insertToSorted((Comparable) curr.data);
            curr = curr.next;
        }

        first = res.first;
        last = res.last;
    }

    // g) Reverse the list completely in place:
    public void reverse() {
        Link curr = first;
        while (curr != null) {
            if (curr.previous == null) {
                last = curr;
            }

            if (curr.next == null) {
                first = curr;
            }

            Link tmp = curr.previous;
            curr.previous = curr.next;
            curr.next = tmp;
            curr = curr.previous;
        }
    }

    // Problem 8-6: Create a Dynamic Queue using a Linked List:
    public class Queue {
        DoublyLinkedList Q;

        public Queue() {
            Q = new DoublyLinkedList();
        }

        public void enqueue(Object key) {
            Q.insertLast(key);
        }

        public Object dequeue() {
            return Q.removeFirst();
        }

        public Object peek() {
            return Q.getFirst();
        }

    }

    // Final 2017:Ex.2:
    // public void addOne() {
    //     if ((int) last.data < 9) {
    //         last.data = (int) last.data + 1;
    //         return;
    //     }

    //     Link curr = first;
    //     while (curr.next != null && (int) curr.next.data < 9) {
    //         curr = curr.next;
    //     }
    //     curr.data = (int) curr.data + 1;
    //     curr = curr.next;
    //     while (curr != null) {
    //         curr.data = 0;
    //         curr = curr.next;
    //     }

    //     if ((int) first.data >= 9) {
    //         Link n = new Link(1);
    //         n.next = first;
    //         first.previous = n;
    //         Link tmp = first;
    //         while (tmp != null) {
    //             tmp.data = 0;
    //             tmp = tmp.next;
    //         }
    //         first = n;
    //         return;
    //     }
    // }

    public void addOne() {
        int s = size();
        if (first == null)
            return;
        int l = 1;
        while (true) {
            Link cur = first;
            for (int i = 0; i < s - l; i++) { // got the last node.
                cur = cur.next;
            }

            if ((int)cur.data < 9) {
                cur.data = (int) cur.data + 1;
                break;
            } else {
                cur.data = 0;
                if (first == cur) {
                    Link n = new Link(1);
                    n.next = first;
                    if (first == last) {
                        last = n;
                    }
                    first = n;
                    break;
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();
        l.insertLast(9);
        l.insertLast(8);
        l.insertLast(9);
        l.addOne();
        l.displayForward();
    }
}
