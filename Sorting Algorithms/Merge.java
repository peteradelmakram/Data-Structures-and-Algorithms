public class Merge {
  //This is a class to implement merge-sort on a linked list, and how merging linked lists works.
  public static ListNode mergeSort(ListNode head){
    if(head == null || head.next == null) return head;
    
    ListNode tmp = head;
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null){
      tmp = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    tmp.next = null;

    ListNode leftSide = mergeSort(head);
    ListNode rightSide =  mergeSort(slow);

    return merge(leftSide, rightSide);
  }

  public static ListNode merge(ListNode l1, ListNode l2){
    ListNode dummyNode = new ListNode(0);
    ListNode currNode = dummyNode;

    while(l1 != null && l2 != null){
      if(l1.val < l2.val){
        currNode.next = l1;
        l1 = l1.next;
      }else{
        currNode.next = l2;
        l2 = l2.next;
      }

      currNode = currNode.next;
    }

    if(l1 != null){
      currNode.next = l1;
      l1 = l1.next;
    }

    if(l2 != null){
      currNode.next = l2;
      l2 = l2.next;
    }

    return dummyNode.next;
  }
  public static void main(String[] args) {
    
  } 
}


class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
