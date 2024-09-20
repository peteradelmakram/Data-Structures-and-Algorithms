package Trees;
import java.util.*;


public class BinaryTree {
    private Node root;

    static class Node{
        public Object data;
        public Node left;
        public Node right;

        public Node(Object o){
            this.data = o;
            this.left = null;
            this.right = null;
        }

        public Node(Object o, Node left, Node right){
            this.data = o;
            this.left = left;
            this.right = right;
        }
    }

    //preOrder traversal using Recursion (Also known as Depth first value)
    // root -> left -> right
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
        
    }

    //preOrder traversal using Iteration
    static void preOrderIterative(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    //InOrder traversal using Recursion  left --> root --> right
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    //InOrder traversal using Iteration
    public static void inOrderIterative(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }
    //postOrder traversal using Recursion (Iterative one is too complicated and inefficient that it isn't worth studying.)
    // left -> right -> root
    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }  
    //levelOrder traversal of tree nodes.
    public static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()){
            Node temp = Q.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null)
                Q.offer(temp.left);
            if(temp.right != null)
                Q.offer(temp.right);
        }
    }

    //find maximum node recursively.
    public static int findMax(Node root){
        if(root == null) return -1;
        int result = (Integer) root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result)
            result = left;
        if(right > result)
            result = right;
        return result;
    }

    public int numOfLeaves(){
        return numOfLeavesHelper(root);
    }

    public int numOfLeavesHelper(Node root){
        if(root == null) return 0;
        return 1 + numOfLeavesHelper(root.left) + numOfLeavesHelper(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node first = new Node(1);
        Node second = new Node (2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        tree.root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh; 


        System.out.println(tree.numOfLeaves());
        preOrder(tree.root);
    }

}
