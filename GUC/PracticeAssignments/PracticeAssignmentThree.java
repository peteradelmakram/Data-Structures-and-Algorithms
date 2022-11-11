package PracticeAssignments;

public class PracticeAssignmentThree{
    //Problem One:
    static int searchStack(ArrayStack s1, int key){
        int count = 1;
        ArrayStack temp = new ArrayStack(s1.size());
        boolean found = false;
        while(!s1.isEmpty() && !found){
            if(s1.top() == key){
                found = true;
                break;
            }
            temp.push(s1.pop());
            count++;
        }

        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }

        if(found){
            return count;
        }else{
            return -1;
        }

    }

    static void compressX(ArrayStack s){
        ArrayStack temp = new ArrayStack(s.size());
        ArrayStack search = new ArrayStack(s.size());
        boolean flag = false;

        while(!s.isEmpty()){
            if(temp.isEmpty()){
                temp.push(s.pop());
            }
            else{
                while(!temp.isEmpty() && !flag){
                    if(temp.top() == s.top()){
                        flag = true;
                        break;
                    }else{
                        search.push(temp.pop());
                    }
                }
                
                while(!search.isEmpty()){
                    temp.push(search.pop());
                }

                if(flag){
                    s.pop();
                }else{
                    temp.push(s.pop());
                }

            }

            flag = false;
        }

        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
    }
    //Problem Two:
    static ArrayStack stackDecompose(ArrayStack s1){
        ArrayStack odd = new ArrayStack(s1.size()/2 +1);
        ArrayStack even = new ArrayStack(s1.size()/2 + 1);

        while(!s1.isEmpty()){
            odd.push(s1.pop());
            if(!s1.isEmpty()) even.push(s1.pop());
        }

        ArrayStack temp = new ArrayStack(odd.size());
        while(!odd.isEmpty()){
            temp.push(odd.pop());
        }

        while(!even.isEmpty()){
            s1.push(even.pop());
        }

        return temp;
    }

    //Problem Three:
    static void sortStack(ArrayStack s1){
        int count = s1.size();
        ArrayStack temp = new ArrayStack(count);
        while(count > 0){
            int min = s1.pop();
            for(int i = 1; i < count; i++){
                if(min < s1.top()){
                    temp.push(s1.pop());
                }else{
                    temp.push(min);
                    min = s1.pop();
                }
            }

            s1.push(min);
            while(!temp.isEmpty()){
                s1.push(temp.pop());
            }
            count--;
        }
    }

    //Problem Four:
    static boolean cubeGame(ArrayStack s1){
        int firstSum = 0, secondSum = 0;
        ArrayStack temp = new ArrayStack(s1.size());
        int size = s1.size();

        for(int i = 0; i < size /2; i++){
            int x = s1.pop();
            temp.push(x);
            firstSum += x;
        }

        if(s1.size() % 2 != 0) temp.push(s1.pop());

        for(int i = 0; i < size /2; i++){
            int x = s1.pop();
            temp.push(x);
            secondSum += x;
        }

        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }

        if(firstSum == secondSum) return true;

        return false;

    }

    //Problem Five:
    static void removeNth(ArrayStack s1, int n){
        // 2 -> 6 -> 3 -> 4 TOP  remove(s1, 1 ) -->>>  6 -> 3 -> 4 TOP
        ArrayStack temp = new ArrayStack(s1.size());
        int s = s1.size();

        while(s > n){
            temp.push(s1.pop());
            s--;
        }

        s1.pop();

        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }
    }

    //QUIZ SAMPLE ONE:

    static boolean containsSequence(ArrayStack s1, ArrayStack s2){
        ArrayStack s1Temp = new ArrayStack(s1.size());
        ArrayStack seq = new ArrayStack(s2.size());
        boolean found = false;
        while(!s1.isEmpty() && !found){
            while(s1.top() == s2.top()){
                s1Temp.push(s1.pop());
                seq.push(s2.pop());

                if(s2.isEmpty()){
                    found = true;
                    break;
                }
                
                if(s1.isEmpty()){
                    break;
                }
            }

            while(!seq.isEmpty()){
                s2.push(seq.pop());
                s1.push(s1Temp.pop());
            }

            s1Temp.push(s1.pop());
        }

        while(!s1Temp.isEmpty()){
            s1.push(s1Temp.pop());
        }

        while(!seq.isEmpty()){
            s2.push(seq.pop());
        }

        return found;
    }

    //Quiz Sample 2 :

    static boolean search(ArrayStack s, int x){
        ArrayStack temp = new ArrayStack(s.size());
        boolean res = false;
        while(!s.isEmpty()){
            if(s.top() == x){
                res = true;
            }
            temp.push(s.pop());
        }

        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

        return res;
    }

    static void compress(ArrayStack s1){
        ArrayStack compressed = new ArrayStack(s1.size());
        ArrayStack temp = new ArrayStack(s1.size());
        boolean flag = false;

        while(!s1.isEmpty()){
            if(compressed.isEmpty()) 
                compressed.push(s1.pop());
            else{
                while(!compressed.isEmpty() && !flag){
                    if(compressed.top() == s1.top()){
                        flag = true;
                    }else{
                        temp.push(compressed.pop());
                    }
                }

                while(!temp.isEmpty()){
                    compressed.push(temp.pop());
                } 
                if(!flag){
                    compressed.push(s1.pop());
                }else{
                    s1.pop();
                }

                flag = false;
            }
        }

        while(!compressed.isEmpty()){
            s1.push(compressed.pop());
        }

    }

    //Quiz Last Sample:
    static boolean isUnique(ArrayStack s){
        ArrayStack tempS = new ArrayStack(s.size());
        ArrayStack temp = new ArrayStack(s.size());
        boolean found = false;
        while(!s.isEmpty()){
            if(tempS.isEmpty()){
                 tempS.push(s.pop());
            }else{
                while(!tempS.isEmpty() && !found){
                    if(tempS.top() == s.top()){
                        found = true;
                    }else{
                        temp.push(tempS.pop());
                    }
                }

                while(!temp.isEmpty()){
                    tempS.push(temp.pop());
                }
            }
        
            if(found){
                break;
            }else{
                tempS.push(s.pop());
            }
        }

        while(!tempS.isEmpty()){
            s.push(tempS.pop());
        }

        return !found;
    }


    //Problem Nine:
    static void insertionSortStack(ArrayStack s){
        int size = s.size();
        ArrayStack x = new ArrayStack(size);
        ArrayStack y = new ArrayStack(size);

        while(!s.isEmpty()){
            int tmp = s.pop();

            if(x.isEmpty()) x.push(tmp);
            else{
                while(!x.isEmpty() && x.top() > tmp){
                    y.push(x.pop());
                }

                x.push(tmp);

                while(!y.isEmpty()){
                    x.push(y.pop());
                }
            }
        }
        while(!x.isEmpty()){
            s.push(x.pop());
        }
    }

    static int countRange(ArrayStack[] arr, int max, int min){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            while(!arr[i].isEmpty()){
                int x = arr[i].pop();
                if(x >= min && x <= max){
                    count++;
                }
            }
        }

        return count;
    }

    //Quiz 1 CSEN03: (V1)
    static void reorderOdd(int[] arr){
        ArrayStack vals = new ArrayStack(arr.length);
        ArrayStack indexes = new ArrayStack(arr.length);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                vals.push(arr[i]);
                indexes.push(i);
            }
        }

        ArrayStack reversed = new ArrayStack(indexes.size());

        while(!indexes.isEmpty()){
            reversed.push(indexes.pop());
        }

        while(!reversed.isEmpty()){
            arr[reversed.pop()] = vals.pop();
        }
    }

    

    public static void main(String[] args) {
      // Array -> {1,2,3,4,5,6,7,8,9}; 
      // -->      {9,2,7,4,5,6,3,8,1}

      int[] arr = {1,2,3,4,5,6,7,8,9};

      reorderOdd(arr);

      for(int x : arr){
        System.out.print(x + " ");
      }

    }
}
