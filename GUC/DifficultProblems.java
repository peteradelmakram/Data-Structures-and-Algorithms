
import PracticeAssignments.ArrayQueue;

public class DifficultProblems {

    public static boolean checkIfPossibleMerge(int[] a , int[] b){
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                i++;
            }else{
                j++;
            }

            if(Math.abs(i-j) > 1){
                return false;
            }
        }
        return true;
    }

    public static void nextSmallerElement(int[] a){
        ArrayStack s = new ArrayStack(a.length);

        for(int i = a.length -1; i > 0; i--){
            if(a[i] < a[i-1]){
                s.push(a[i]);
            }
        }

        int j = 0;
        while(!s.isEmpty()){
            if(a[j] > s.top()){
                a[j++] = s.top();
            }

            if(a[j] == s.top()){
                s.pop();
            }
        }
    }

    public static boolean sameAsAndBs(String s){
        ArrayStack tmp = new ArrayStack(s.length());
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                tmp.push(s.charAt(i));
            }
        }

        for(int j = 0; j < s.length(); j++){
            if(s.charAt(j) == 'b'){
                if(tmp.isEmpty()){
                    return false;
                }else{
                    tmp.pop();
                }
            }
        }

        if(tmp.isEmpty()){
            return true;
        }

        return false;
    }

    public static void scramble(ArrayQueue Q){
        int size = Q.size();
        int count = 1;
        ArrayStack s = new ArrayStack(size);
        int i = 0;
        while(i < size){   
            for(int j = 0; j < count && count %2 == 1 && i < size; i++){
                Q.enqueue(Q.dequeue());
                i++;
            }

            for(int k = 0; k < count && count % 2 == 0 && i < size; k++){
                s.push((Integer) Q.dequeue());
                i++;
            }

            while(!s.isEmpty()){
                Q.enqueue(s.pop());
            }

            count++;
        }
    }

    public static void sortRelative(int[] a, int[] b){
        int k = 0;
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < a.length; j++){
                if(b[i] == a[j]){
                    int tmp = a[k];
                    a[k] = a[j];
                    a[j] = tmp;
                    k++;
                }
            }
        }

        for(int i = k; i < a.length -1; i++){
            for(int j = k; j < a.length - 1; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }

    }

    public static void interleave(ArrayQueue Q){
        int size = Q.size();
        ArrayStack s = new ArrayStack(size);

        for(int i = 0; i < size/2; i++){
            for(int j = 0; j < size/2 -1; j++){
                Q.enqueue(Q.dequeue());
            }
            s.push((int)Q.dequeue());
        }
        
        for(int i = 0; i < size/2; i++){
            Q.enqueue(Q.dequeue());
            if(!s.isEmpty()) Q.enqueue(s.pop());
        }
    }

    public static void main(String[] args) {
    
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};
        
        sortRelative(A1, A2);

        for(int x : A1){
            System.out.print(x + " ");
        }

    }
}
