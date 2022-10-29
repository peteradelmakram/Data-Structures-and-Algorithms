package LeetCode;
import java.util.*;

public class SessionThree {

    // 203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val == val){
                ListNode tmp = curr.next;
                curr.next = null;
                prev.next = tmp;
                curr = tmp;
            }else{
                curr = curr.next;
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
    

    //2095. Delete the Middle Node of a Linked List
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode curr = head;
        ListNode prev = dummy;
        
        //Find length of the linked list.
        int length = 0;
        ListNode temp = curr;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        
        int midLength = length/2;
        
        for(int i = 0; i < midLength; i++){
            curr = curr.next;
            prev = prev.next;
        }
        
        ListNode tmp = curr.next;
        curr.next = null;
        prev.next = tmp;
        
        return dummy.next;
    }

    //143. Reorder List
    public void reorderList(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        
        ListNode secondList = slowPtr.next;
        slowPtr.next = null;
        ListNode curr = secondList;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        secondList = prev;
        ListNode firstList = head;
        while(secondList != null && firstList != null){
            ListNode tempFirst = firstList.next;
            ListNode tempSecond = secondList.next;
            firstList.next = secondList;
            secondList.next = tempFirst;
            
            firstList = tempFirst;
            secondList = tempSecond;
        }
    }

    //94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list;
    }
    public static void inOrder(List<Integer> list, TreeNode root){
        if(root == null) return; 
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }

    //144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(list, root);
        return list;
    }
    public static void preOrder(List<Integer> list, TreeNode root){
        if(root == null) return; 
        list.add(root.val);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

    //145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(list, root);
        return list;
    }   
    
    public void postOrder(List<Integer> list, TreeNode root){
        if(root == null) return;
        postOrder(list, root.left);
        postOrder(list, root.right);
        list.add(root.val);
    }

    //101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        return mirror(root, root);
    }
    
    public boolean mirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        
        return (t1.val == t2.val) && mirror(t1.left, t2.right) && mirror(t1.right, t2.left);
    }

    //136. Single Number
    public int singleNumber(int[] nums) {
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            ans ^= nums[i];
        }
        
        return ans;
    }

    // 389. Find the Difference
    public char findTheDifference(String s, String t) {
        char output = t.charAt(s.length());
        
        for(int i = 0; i < s.length(); i++){
            output ^= s.charAt(i)^t.charAt(i);
        }
        
        return output;
    }

    // 100. Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    
}

    