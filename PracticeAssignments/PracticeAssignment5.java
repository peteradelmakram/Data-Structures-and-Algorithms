package PracticeAssignments;

public class PracticeAssignment5 {
    //Exercise 5 - 1:
    public static void reverseQ(ArrayQueue Q){
        ArrayStack temp = new ArrayStack(Q.size());
        while(!Q.isEmpty()){
            temp.push((int) Q.dequeue());
        }

        while(!temp.isEmpty()){
            Q.enqueue(temp.pop());
        }
    }

    //Exercise 5 -2:
    public static ArrayQueue mirror(ArrayQueue Q){
        ArrayQueue reverse = new ArrayQueue(Q.size());
        int size = Q.size();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size -1; j++){
                Q.enqueue(Q.dequeue());
            }
            reverse.enqueue(Q.peek());
        }

        ArrayQueue result = new ArrayQueue (Q.size() * 2);
        while(!reverse.isEmpty()) result.enqueue(reverse.dequeue());
        while(!Q.isEmpty()) result.enqueue(Q.dequeue());
        return result;
    }

    //Exercise 5-4:
    public class StackQueue{
        ObjStack Queue;
        int length;

        public StackQueue(int size){
            Queue = new ObjStack(size);
            length = 0;
        }

        public void enqueue(Object o){
            Queue.push(o);
            length++;
        }

        public Object dequeue(){
            ObjStack temp = new ObjStack(length);
            while(!Queue.isEmpty()){
                temp.push(Queue.pop());
            }

            Object res = temp.pop();

            while(!temp.isEmpty()){
                Queue.push(temp.pop());
            }
            length--;
            return res;
        }

        public int size(){
            return length;
        }

        public boolean isEmpty(){
            return Queue.isEmpty();
        }

    }
    //Exercise 5-5:
    public static void shiftZeros(ArrayQueue Q){
        int zeroCount = 0;
        ArrayQueue res = new ArrayQueue(Q.size());
        while(!Q.isEmpty()){
            if((int)Q.peek() == 0){
                zeroCount++;
                Q.dequeue();
            }else{
                res.enqueue(Q.dequeue());
            }
        }

        while(zeroCount > 0){
            res.enqueue(0);
            zeroCount--;
        }

        while(!res.isEmpty()){
            Q.enqueue(res.dequeue());
        }
    }

    //Exercise 5-6:
    public static ArrayQueue everyThirdElement(ArrayQueue Q){
        ArrayStack temp = new ArrayStack(Q.size());
        ArrayQueue tempQ = new ArrayQueue(Q.size());

        while(!Q.isEmpty()){
            Object x = Q.dequeue();
            temp.push((int) x);
            tempQ.enqueue(x);
        }

        ArrayQueue res = new ArrayQueue(tempQ.size() /3 +1);
        int count = 0;

        while(!temp.isEmpty()){
            if(count % 3 == 0 || count == 0){
                res.enqueue(temp.pop());
            }else{
                temp.pop();
            }    
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayQueue Q = new ArrayQueue(5);
        Q.enqueue(8);
        Q.enqueue(3);
        Q.enqueue(7);
        Q.enqueue(4);
        Q.enqueue(23);

        ArrayQueue res = everyThirdElement(Q);
        res.printQueue();



    }
}
