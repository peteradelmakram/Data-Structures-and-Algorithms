package Queues;

public class PriorityQueue implements Comparable {
    Comparable[] queue;
    int nItems;
    int maxSize;

    public PriorityQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new Comparable[maxSize];
        nItems = 0;
    }

    public void insert(Comparable x){
        int i;
        for(i = nItems -1; i>= 0 && x.compareTo(queue[i]) > 0; i--){
            queue[i+1] = queue[i];
        }
        queue[i+1] = x;
        nItems++;
    }

    public Comparable remove(){
        return queue[--nItems];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }


    @Override
    public int compareTo(Object o) {

        return 0;
    }
    
}
