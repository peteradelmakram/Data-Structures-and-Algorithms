package Finals;
import java.util.*;
public class Problems {
    //Exercise 7.2:
    public static void reverse(LinkList l){
        LinkList tmp = new LinkList();

        while(!l.isEmpty()){
            tmp.insertLast(l.removeFirst());
        }

        while(!tmp.isEmpty()){
            l.insertFirst(tmp.removeFirst());
        }
    }

    //Exercise 7.5:
    public static LinkList mixList(LinkList l){
        LinkList res = new LinkList();

        while(!l.isEmpty()){
            res.insertLast(l.removeFirst());
            if(!l.isEmpty()){
                res.insertLast(l.removeLast());
            }
        }

        return res;
    }

    //Exercise 11-2: Remove all duplicates from an array in O(n) time:
    public static int[] removeDuplicates(int[] arr){
        HashSet<Integer> hs = new HashSet<>();
        int[] res = new int[arr.length];
        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if(!hs.contains(arr[j])){
                hs.add(arr[j]);
                res[i] = arr[j];
                i++;
            }
        }

        return res;
    }

    //Exercise 3 : Convert LinkedList:
    public static void convert(LinkList l){
        LinkList tmp = new LinkList();
        LinkList zeros = new LinkList();
        
        while(!l.isEmpty()){
            if((int) l.getFirst() == 0){
                zeros.insertLast(l.removeFirst());
                continue;
            }else{
                tmp.insertLast(l.removeFirst());
            }

            if(!l.isEmpty() && !tmp.isEmpty()){
                if(tmp.getLast() == l.getFirst()){
                    int n = (int) tmp.removeLast() * 2;
                    l.removeFirst();
                    tmp.insertLast(n);
                    zeros.insertLast(0);
                }
            }
        }

        while(!tmp.isEmpty()){
            l.insertLast(tmp.removeFirst());
        }

        while(!zeros.isEmpty()){
            l.insertLast(zeros.removeFirst());
        }
    }


    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLast(2);
        l.insertLast(2);
        l.insertLast(0);
        l.insertLast(4);
        l.insertLast(0);
        l.insertLast(8);
        
        convert(l);

        System.out.println(l);


    }

}
