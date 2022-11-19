import Queues.ArrayQueue;
public class Midterms {
    
    public static void reverseChunk(ArrayStack x, int c){
        ArrayStack t1 = new ArrayStack(x.size());
        ArrayStack t2 = new ArrayStack(c);
        int si = x.size();
        while(!x.isEmpty()) t1.push(x.pop());

        for(int i = 0; i < si % c; i++) x.push(t1.pop());

        while(!t1.isEmpty()){
            for(int i = 0; i < c; i++) t2.push(t1.pop());
            while(!t2.isEmpty()) x.push(t2.pop());
        }
    }

    public static void interleave(ArrayQueue Q){
        int size = Q.size();
        ArrayStack s = new ArrayStack(size/2);

        for(int i = 0; i < size /2; i++){
            for(int j = 0; j < size /2 -1; j++){
                Q.enqueue(Q.dequeue());
            }
            s.push((int) Q.dequeue());
        }

        for(int i = 0; i < size /2 ; i++){
            Q.enqueue(Q.dequeue());
            Q.enqueue(s.pop());
        }
    }

    public static int countMatches(int[] a, int[] b){
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(a[i] == b[j]) count++;
            }
        }

        return count;
    }

    public static int priority(String s){
        switch(s){
            case "+" : 
            case "-" :
                return 1;
            case "*" :
            case "/" :
                return 2;
        }
        return -1;
    }

    public static String infixToPrefix(String s){
        String[] chars = s.split(" ");
        ObjStack stack = new ObjStack(chars.length);
        String result = "";
        for(int i = chars.length -1; i >= 0; i--){
            if(priority(chars[i]) > 0){
                while(!stack.isEmpty() && priority(chars[i]) <= priority( (String) stack.top())){
                    result = (String) stack.pop() + result;
                }
                stack.push(chars[i]);
            }else{
                result = chars[i] + result;
            }
        }

        while(!stack.isEmpty()){
            result = (String) stack.pop() + result;
        }


        return result;
    }

    public class LastNStream{
        ArrayQueue Q;
        int maxSize;
        int sum;
        int items;

        public LastNStream(int size){
            maxSize = size;
            Q = new ArrayQueue(maxSize);
            sum = 0;
            items = 0;
        }

        public void insert(int x){
            if(Q.isFull()){
                sum -= (int) Q.dequeue();
            }
            sum += x;
            items++;
            Q.enqueue(x);
        }

        public float getAverage(){
            return sum/ items;
        }
    }

    public class PriorityStack{
        ObjStack PS;
        int maxSize;

        public PriorityStack(int size){
            maxSize = size;
            PS = new ObjStack(maxSize);
        }

        public void push(Comparable o){
            if(PS.isEmpty()) PS.push(o);
            else{
                ObjStack tmp = new ObjStack(PS.size());
                while(!PS.isEmpty() && o.compareTo((Comparable) PS.top()) > 0){
                    tmp.push(PS.pop());
                }

                tmp.push(o);

                while(!tmp.isEmpty()){
                    PS.push(tmp.pop());
                }

            }
        }

        public Comparable pop(){
            return (Comparable) PS.pop();
        }

        public Comparable top(){
            return (Comparable) PS.top();
        }

        public boolean isEmpty(){
            return PS.isEmpty();
        }

        public boolean isFull(){
            return PS.isFull();
        }

        public int size(){
            return PS.size();
        }
    }

    public class PriorityQueue{
        ArrayQueue PQ;

        public PriorityQueue(int size){
            PQ = new ArrayQueue(size);
        }

        public void enqueue(Comparable o){
            if(PQ.isEmpty()) PQ.enqueue(o);
            else{
                ArrayQueue tmp = new ArrayQueue(PQ.size());
                while(o.compareTo(PQ.peek()) > 0){
                    tmp.enqueue(PQ.dequeue());
                }

                tmp.enqueue(o);
                
                while(!PQ.isEmpty())
                    tmp.enqueue(PQ.dequeue());

                while(!tmp.isEmpty())
                    PQ.enqueue(tmp.dequeue());
            }
        }

        public Comparable dequeue(){
            return (Comparable) PQ.dequeue();
        }

        public boolean isEmpty(){
            return PQ.isEmpty();
        }

        public boolean isFull(){
            return PQ.isFull();
        }

        public int size(){
            return PQ.size();
        }
    }

    public static boolean searchStack(ArrayStack s, int x){
        ArrayQueue Q = new ArrayQueue(s.size());
        boolean found = false;

        while(!s.isEmpty()){
            if(s.top() == x){
                found = true; 
                break;
            }else{
                Q.enqueue(s.pop());
            }
        }

        for(int i = 0; i < Q.size(); i++){
            for(int j = 0; j < Q.size() -1; j++){
                Q.enqueue(Q.dequeue());
            }
            s.push( (int) Q.peek());
        }
        return found;
    }

    static boolean isValidPostfix(String str){
        ObjStack s = new ObjStack(str.length());
        String[] chars = str.split(" ");
        for(int i = 0; i < chars.length; i++){
            if(priority(chars[i]) > 0){
                if(s.size() < 2 ){
                    return false;
                }else{
                    s.pop();
                    s.pop();
                    s.push(chars[i]);
                }
            }else{
                s.push(chars[i]);
            }
        }
        return true;
    }

    public class OrderedStack{
        ArrayStack s;
        int maxSize;

        public OrderedStack(int size){
            maxSize = size;
            s = new ArrayStack(maxSize);
        }

        public void pushOrdered(int x){
            if(s.isEmpty()) s.push(x);
            else{
                ArrayStack tmp = new ArrayStack(maxSize);
                while(!s.isEmpty() && x < s.top()){
                    tmp.push(s.pop());
                }

                s.push(x);

                while(!tmp.isEmpty()){
                    s.push(tmp.pop());
                }
            }
        }

        public int popOrdered(){
            return s.pop();
        }


    }

    public static String removeDuplicates(String str){
        ObjStack s = new ObjStack(str.length());

        for(int i = 0; i < str.length(); i++) s.push(str.charAt(i));
        
        ObjStack tmp = new ObjStack(s.size());

        while(!s.isEmpty()){
            char c = (Character) s.pop();
            if(c == (Character) s.top()){
                s.pop();
                while(!tmp.isEmpty()){
                    s.push(tmp.pop());
                }
            }else{
                tmp.push(s.pop());
            }
        }

        String sx = "";
        while(!tmp.isEmpty()){
            sx += (Character) tmp.pop();
        }

        return sx;
    }

    public static void insertAtFront(ArrayQueue Q1, ArrayQueue Q2){

        int s = Q1.size();

        for(int i = 0; i < s; i++){
            if(i > s - Q2.size()){
                Q1.dequeue();
            }else{
                Q1.enqueue(Q1.dequeue());
            }
        }

        for(int i = 0; i < Q2.size(); i++){
            int n = (Integer) Q2.dequeue();
            Q2.enqueue(n);
            if(i < s){
                Q1.enqueue(n);
            }
        }

        for(int i = 0; i < s - Q2.size(); i++){
            Q1.enqueue(Q1.dequeue());
        }

    }


    public static void main(String[] args) {
        ArrayQueue Q1 = new ArrayQueue(3);
        Q1.enqueue(2);
        Q1.enqueue(6);
        Q1.enqueue(1);

        ArrayQueue Q2 = new ArrayQueue(4);
        Q2.enqueue(17);
        Q2.enqueue(19);
        Q2.enqueue(37);
        Q2.enqueue(41);

        insertAtFront(Q1, Q2);

        Q1.printQueue();
    }
}
