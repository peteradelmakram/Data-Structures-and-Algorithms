package LeetCode;

public class SessionSix {
    //141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if(slowPtr == fastPtr) return true; 
        }
        
        return false;
    }

    //234. Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        ListNode reverse = reverse(slowPtr);
        
        while(curr != null && reverse != null){
            
            if(curr.val != reverse.val){
                return false;
            }
            
            curr = curr.next;
            reverse = reverse.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    //7. Reverse Integer
    public int reverse(int x) {
        double total = 0;
        
        while(x != 0){
            total = total*10 + (x%10);
            x = x/10;
        }
        
        if(total >= Integer.MIN_VALUE && total <= Integer.MAX_VALUE){
            return (int) total;
        }else{
            return 0;
        }
        
    }

    // 572. Subtree of Another Tree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        
        if(root == null || subRoot == null) return false;
        
        if(isSame(root, subRoot)) return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isSame(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        
        if(t1.val == t2.val){
            return ( isSame(t1.left, t2.left) && isSame(t1.right, t2.right) );
        }
        
        return false;
    }

    //35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length -1;
        
        while(i <= j){
            int mid = i + (j-i)/2;
            if(nums[mid] == target) return mid;
            if(target < nums[mid]){
                j = mid -1;
            } 
            else{
                i = mid + 1;  
            } 
        }
        
        return i;
    }
    
}
