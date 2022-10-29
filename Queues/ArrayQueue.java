package Queues;

//Works like a queue list, Imagine a school queue, where the students are added to the back of the queue, and students are leaving
//at the front, "FIFO" --> First In, First Out. "First elements added, are the first to be removed."
//Opposite to the stack's LIFO properties "Last in, first out" , "Last elements added at the top of the stack, first to be removed."

public class ArrayQueue {
    private int maxSize;
    private Object[] ArrayQueue;
    private int front;
    private int rear;
    private int nItems;

    public ArrayQueue(int size) {
        maxSize = size;
        ArrayQueue = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(Object obj){
        if(rear == maxSize -1){
            rear = -1;
        }
        ArrayQueue[++rear] = obj;
        nItems++;
    }

    public Object dequeue(){
        Object res = ArrayQueue[front];
        front++;
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return res;
    }

    public Object peek(){
        return ArrayQueue[front];
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    public int size(){
        return nItems;
    }

    public static String[] generateBinary(int n){
        String[] res = new String[n];
        ArrayQueue queue = new ArrayQueue(n);
        queue.enqueue("1");
        for(int i = 0; i < n ; i++){
            res[i] = (String) queue.dequeue();
            String n1 = res[i] + "1";
            String n2 = res[i] + "0";
            queue.enqueue(n1);
            queue.enqueue(n2);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ans = generateBinary(6);

        for(String x : ans){
            System.out.print(x + " ");
        }
    }
}
