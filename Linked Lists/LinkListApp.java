import Stacks.Stack;

public class LinkListApp {  
    //Exercise 7-2
    public static void reverseList(LinkList l){
        LinkList x = new LinkList();

        while(!l.isEmpty()){
            x.insertLast(l.removeLast());
        }
        
        while(!x.isEmpty()){
            l.insertLast(x.removeFirst());
        }
    }

    //Exercise 7-4
    public static void removeDuplicates(LinkList l){
        LinkList z = new LinkList();

        while(!l.isEmpty()){
            if(!z.isEmpty() && z.getLast().equals(l.getFirst())){
                l.removeFirst();
            }else{
                z.insertLast(l.removeFirst());
            }
        }

        while(!z.isEmpty()){
            l.insertLast(z.removeFirst());
        }
    }

    //Exercise 7-5
    public static void mixList(LinkList l){
        LinkList x = new LinkList();
        while(!l.isEmpty()){
            x.insertLast(l.removeFirst());
            if(!l.isEmpty())
                x.insertLast(l.removeLast());
        }

        while(!x.isEmpty()){
            l.insertLast(x.removeFirst());
        }
    }

    //Exercise 7-6
    public static void cutList(LinkList l){
        int length = 0;
        LinkList x = new LinkList();

        while(!l.isEmpty()){
            x.insertLast(l.removeFirst());
            length++;
        }

        length /= 2;

        for(int i = 0; i < length; i++){
            l.insertFirst(x.removeLast());
        }

        while(!x.isEmpty()){
            l.insertLast(x.removeFirst());
        }        
    }

    //splits the linked lists into two, one with even indices, one with odd indices.
    public static void alternatingSplit(LinkList l){
        int count = 0;
        LinkList tmp = l;
        
        LinkList subList1 = new LinkList();
        LinkList subList2 = new LinkList();

        while(!l.isEmpty()){
            if(count % 2 == 0){
                subList1.insertLast(tmp.removeFirst());
            }else{
                subList2.insertLast(tmp.removeFirst());
            }
            count++;
        }

        System.out.println(subList1);
        System.out.println(subList2);
    }

    //is it descending?
    public static boolean isDescending(LinkList l){
        LinkList y = new LinkList();
        boolean flag = true;

        while(!l.isEmpty()){
            y.insertFirst(l.removeLast());

            if(!l.isEmpty()){
                if((int) y.getFirst() > (int) l.getLast()){
                    flag = false;
                }
            }
            

        }

        while(!y.isEmpty()) l.insertLast(y.removeFirst());

        return flag;
    }

    //Replace an int k with m in a linked list.
    public static void replace(LinkList l, int k, int m){
        LinkList y = new LinkList();

        while(!l.isEmpty()){
            int sus = (int) l.removeFirst();

            if(sus != k){
                y.insertLast(sus);
            }else{
                y.insertLast(m);
            }
        }

        while(!y.isEmpty()){
            l.insertLast(y.removeFirst());
        }
    }

    // +first-second+third-fourth+fifth....
    public static int switchSum(LinkList l){

        int sum = 0;
        int count = 0;
        LinkList y = new LinkList();

        while(!l.isEmpty()){
            int x = (int) l.removeFirst();

            if(count % 2 == 0){
                sum += x;
            }else{
                sum -= x;
            }

            y.insertLast(x);
            count++;
        }

        while(!y.isEmpty()){
            l.insertLast(y.removeFirst());
        }

        return sum;
    }

    // {1,2,3} --> {1,2,2,3,3,3}
    public static void duplicateValue(LinkList l){
        LinkList y = new LinkList();

        while(!l.isEmpty()){
            int x = (int) l.removeFirst();

            for(int i = 0; i < x; i++){
                y.insertLast(x);
            }
        }

        while(!y.isEmpty()){
            l.insertLast(y.removeFirst());
        }
    }

    public static boolean checkDuplicate(LinkList l1, LinkList l2, LinkList l3){
        
        while(!l1.isEmpty()){
            int x = (int) l1.removeFirst();
            
            if(l2.isEmpty()){
                return false;
            }

            int occ = (int) l2.removeFirst();
            
            for(int i = 0; i < occ; i++){
                int z = (int) l3.removeFirst();
                if(z != x){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean palindrome(LinkList l){
        while(!l.isEmpty()){
            char a = (Character) l.removeFirst();

            if(l.isEmpty()) return true;

            char b = (Character) l.removeLast();

            if(a != b){
                return false;
            }
        }
        return true;
    }

    public static DoublyLinkedList insertionSort(DoublyLinkedList l){
        DoublyLinkedList res = new DoublyLinkedList();

        while(!l.isEmpty()){
            if(res.isEmpty()){
                res.insertFirst(l.removeFirst());
            }else{
                Object tmp = l.removeFirst();
                DoublyLinkedList temp = new DoublyLinkedList();
                boolean flag = false;

                while(!flag){
                    if(res.isEmpty()){
                        res.insertFirst(tmp);
                        flag = true;
                        break;
                    }

                    Comparable z = (Comparable) res.removeFirst();
                    if(z.compareTo((Comparable) tmp) <0){
                        temp.insertLast(z);
                    }else{
                        res.insertFirst(z);
                        res.insertFirst(tmp);
                        flag = true;
                    }
                }

                while(!temp.isEmpty()){
                    res.insertFirst(temp.removeLast());
                }
            }
        }

        return res;
    }




    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(1);
        list.insertLast(5);
        list.insertLast(3);
        list.insertLast(11);
        list.insertLast(4);

    }
}