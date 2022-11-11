public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        if(head == null) return 0;
        ListNode current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    public void insertLast(int value){
        ListNode node = new ListNode(value);
        if(head == null){
            head = node;
            return;
        }
        ListNode current = head;
        while (null != current.next){
            current = current.next;
        }
        current.next = node;
    }

    public void insert(int position, int value){
        ListNode node = new ListNode(value);
        if(position == 1){
            node.next = head;
            head = node;
        }else{
            ListNode previous = head;
            int count = 1;
            while(count < position -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast(){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public ListNode delete(int position){
        if(position ==1){
            head = head.next;
            return head;
        }else{
            ListNode previous = head;
            int count = 1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
            return current;
        }
    }

    public boolean search(int value){
        ListNode current = head;
        while(current != null){
            if(current.data == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode findMiddleNode(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    
    public ListNode getNthNodeFromEnd(int n){
        if(head == null){
            return null;
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n){
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public ListNode addNodeInSortedLL(int value){
        ListNode node = new ListNode(value);
        if(head == null){
            return node;
        }
        ListNode current = head;
        ListNode temp = null;
        while(current != null && current.data < node.data){
            temp = current;
            current = current.next;
        }
        node.next = current;
        temp.next = node;
        return head;
    }

    public void removeKey(int key){
        ListNode current = head;
        ListNode temp = null;
        if(current != null && current.data == key) head = current.next;
        while (current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null) return;
        temp.next = current.next;
    }

    public boolean checkLoop(){
        if(head == null) return false;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) return true;
        }
        return false;
    }

    public void createContextLoop(){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;
    }

    public ListNode startNodeInLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) return getStartingNode(slowPtr);
        }
        return null;
    }

    public ListNode getStartingNode(ListNode node){
        ListNode temp = head;
        while (temp != node){
            temp = temp.next;
            node = node.next;
        }
        return temp;
    }

    public void removeLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) removeLoop(slowPtr);
        }
    }

    public void removeLoop(ListNode node){
        ListNode temp = head;
        while (temp.next != node.next){
            temp = temp.next;
            node = node.next;
        }
        node.next = null;
    }

    public void removeDuplicates(){
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public static ListNode mergeTwoSortedLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode head2 = new ListNode(4);
        ListNode first2 = new ListNode(7);
        ListNode second2 = new ListNode(2);
        head.next = first;
        first.next = second;
        head2.next = first2;
        first2.next = second2;
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.head = head;
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.head = head2;
        list1.display();
        list2.display();
        // SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        // singlyLinkedList.display(head);
        // ListNode reversedNode = singlyLinkedList.reverse(head);
        // singlyLinkedList.display(reversedNode);        
    }
}

