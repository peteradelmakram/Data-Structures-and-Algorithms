package Queues;

import java.util.NoSuchElementException;

// Queue implementation using a Linked List.
public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public class ListNode{
        private Object data;
        private ListNode next;

        public ListNode(Object data){
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void enqueue(Object obj){
        ListNode newNode = new ListNode(obj);
        if(isEmpty()) front = newNode;
        else{
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public Object dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        Object res = front.data;
        front = front.next;
        if(front == null) rear = null;
        length--;
        return res;
    }

    public void print(){
        if(isEmpty()) return;
        ListNode temp = front;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public Object peek(){
        return front.data;
    }

    //Problems:
    //Generates binary numbers from 1 to n inclusive.
    public static String[] generateBinary(int n){
        String[] res = new String[n];
        Queue Q = new Queue();
        Q.enqueue("1");
        for(int i = 0; i < n; i++){
            res[i] = (String) Q.dequeue();
            String n1 = res[i] + "0";
            String n2 = res[i] + "1";
            Q.enqueue(n1);
            Q.enqueue(n2);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] ans = generateBinary(5);
       
        for(String x : ans){
            System.out.print(x + " ");
        }
    }
}
