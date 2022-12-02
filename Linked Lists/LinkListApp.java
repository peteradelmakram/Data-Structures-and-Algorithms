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


    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLast('a');
        l.insertLast('b');
        l.insertLast('c');
        l.insertLast('d');
        l.insertLast('e');
        alternatingSplit(l);
    }
}

class Link{
    public Object data;
    public Link next;

    public Link(Object o) {
        this.data = o;
        this.next = null;
    }

    public String toString() {
        return data.toString();
    }
}