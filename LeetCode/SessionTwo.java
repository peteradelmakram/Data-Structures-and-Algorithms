package LeetCode;

public class SessionTwo {
    //19. Remove Nth Node From End of List
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode left = dummy;
        ListNode right = head;
        while(n > 0 && right != null){
            right = right.next;
            n--;
        }
        
        while(right != null){
            left = left.next;
            right = right.next;
        }
        
        left.next = left.next.next;
        
        return dummy.next;
    }

    //83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr;
            
            while(temp != null && curr.val == temp.val){
                temp = temp.next;
            }
            
            curr.next = temp;
            curr = curr.next;
        }
    return head;
    }

    //82. Remove Duplicates from Sorted List II
    public static ListNode deleteDuplicates2(ListNode head) {
        //Create a dummy node.
        ListNode dummy = new ListNode(Integer.MIN_VALUE , head);
        ListNode curr = head;
        ListNode prev = dummy;
        
        while(curr != null){
            ListNode temp = curr;
            int tempCount = 0;
            
            while(temp != null && curr.val == temp.val){
                temp = temp.next;
                tempCount++;
            }
            
            if(tempCount > 1){
                  prev.next = temp;
                  curr = temp;                  
            }else{
                prev.next = curr;
                curr.next = temp;
                curr = curr.next;
                prev = prev.next;
            }
        }
    return dummy.next;
    }

    //24. Swap Nodes in Pairs
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode curr = dummy;
        
        while(curr.next != null && curr.next.next != null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        
        return dummy.next;
    }

    //61. Rotate List
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        // get length of the linked list.
        int length = 1;
        ListNode tail = head;
        
        while(tail.next != null){
             tail = tail.next;
             length ++;
        }
        
        k = k % length;
        if(k == 0) return head;
        
        ListNode curr = head;
        
        for(int i = 0; i < length - k - 1; i++){
            curr = curr.next;
        }
        
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        
        return newHead;
    }
}

class ListNode{
    int val;
    ListNode next;
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
