package PriorityQueues;
public class PriorityQueue{
    private int maxSize;
    private Object[] priorityQueue;
    private int nItems;

    public PriorityQueue(int s) {
       maxSize = s;
       priorityQueue = new Object[maxSize];
       nItems = 0; 
    }  

    public void insert(Object o){
        if(nItems == 0)
            priorityQueue[nItems++] = o;
        else{
            int j;
            for(j = nItems -1; j >= 0; j--){
                if(((Student) o).compareTo(priorityQueue[j]) < 0){
                    priorityQueue[j+1] = priorityQueue[j];
                }
                else{
                    break;
                }
            }
            priorityQueue[j+1] = o;
            nItems++;
        }
    }

    public Object remove(){
        nItems--;
        return priorityQueue[nItems];
    }

    public static void main(String[] args) {
        Student student1 = new Student("Ahmed", 10);
        Student student2 = new Student("Bob", 20);
        Student student3 = new Student("Carl", 30);

        PriorityQueue Q = new PriorityQueue(3);
        Q.insert(student3);
        Q.insert(student1);
        Q.insert(student2);

        for(int i = 0; i < 3; i++)
            System.out.print(Q.remove() + " ");
    }

    
}
