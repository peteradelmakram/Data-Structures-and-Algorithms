package Trees;

public class BinarySearchTree {
    private Node root;

    public static class Node{
        public Object data;
        public Node left;
        public Node right;

        public Node(Object o){
            data = o;
        }
    }

    public BinarySearchTree(){
        root = null;
    }

    public static Node search(Node root, int key){
        if(root == null || (Integer) root.data == key){
            return root;
        }
        if(key < (Integer) root.data){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    public static Node searchIteratively(Node root, int key){
        if(root == null) return root;
        else{
            while((Integer) root.data != key){
                if(key < (Integer) root.data){
                    root = root.left;
                }else{
                    root = root.right;
                }
                if(root == null) return null;
            }
        }
        return root;
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < (Integer) root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static String inOrderStr(Node root){
        if(root == null) return " ";
        return inOrderStr(root.left) +root.data + inOrderStr(root.right); 
    }

    static boolean validBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if((Integer) root.data <= min|| (Integer) root.data >= max){
            return false;
        }
        boolean left = validBST(root.left, min, (Integer) root.data);
        if(left){
            boolean right = validBST(root.right, (Integer) root.data, max);
            return right;
        }
        return false;
    }
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        Node root = searchTree.root;
        root = insert(null, 5);
        insert(root, 1);
        insert(root, 10);
        insert(root, 3);
        insert(root, 7);
        insert(root,6);
        insert(root, 4);
        insert(root, 9);

        boolean res = validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.print(res);

    }
}
