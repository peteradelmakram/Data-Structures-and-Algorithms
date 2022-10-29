public class DoublyLinkedList {
    public ListNode head;
    public ListNode tail;

    public class ListNode{
        public Object data;
        public ListNode next;
        public ListNode previous;

        public ListNode(Object data){
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void insertFirst(Object o){
        ListNode newNode = new ListNode(o);
        if(head == null){
            tail = newNode;
        }else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(Object o){
        ListNode newNode = new ListNode(o);
        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    public Object removeFirst(){
        Object temp = head.data;
        if(head.next == null){
            tail = null;
        }else{
            head.next.previous = null;
        }
        head = head.next;
        return temp;
    }

    public Object removeLast(){
        Object temp = tail.data;
        if(head.next == null){
            head = null;
        }else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        return temp;
    }

    public static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " -- > ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.removeLast();
        print(list.head);
    }
}
