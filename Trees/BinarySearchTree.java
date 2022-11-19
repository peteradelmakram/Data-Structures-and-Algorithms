package Trees;
public class BinarySearchTree {
    private Node root;

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int o){
            data = o;
        }
    }

    public BinarySearchTree(){
        root = null;
    }

    //Traversals for Printing: 
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    //Primary Methods:
    public static Node searchBST(Node root, int key){
        if(root == null || root.data == key) return root;
        else if(root.data < key) return searchBST(root.right, key);
        else return searchBST(root.left, key);
    }

    public static Node searchBSTIteratively(Node root, int key){
        if(root == null) return root;
        else{
            while(root.data != key){
                if(key < root.data) root = root.left;
                else root = root.right;

                if(root == null) return null;
            }
        }
        return root;
    }

    public static Node insertBST(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.data) root.left = insertBST(root.left, val);
        else {
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    public static Node deleteBST(Node root, int data){
        // there are 3 cases : node to be deleted is a leaf, node to be deleted has one child, or node to be deleted has two children.
        if(root == null) return root;
        //Traversing down the BST till we find the node that we want to delete.
        if(data < root.data){
            root.left = deleteBST(root.left, data);
        }else if(data > root.data){
            root.right = deleteBST(root.right, data);
        }else{
            //Case 1 & 2: No children or one child.
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            //Case 3 : Two children (Get inorder successor (smallest value in right subtree)) and delete it.
            else{
                root.data = minVal(root.right);
                root.right = deleteBST(root.right, root.data);
            }
        }
        return root;
    }

    static int minVal(Node root){
        int minVal = root.data;
        while(root.left != null){
            minVal = root.left.data;
            root = root.left;
        }

        return minVal;
    }

    static boolean validBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data <= min|| root.data >= max){
            return false;
        }
        boolean left = validBST(root.left, min, root.data);
        if(left){
            boolean right = validBST(root.right, root.data, max);
            return right;
        }
        return false;
    }
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        Node root = searchTree.root;
        root = insertBST(null, 5);
        insertBST(root, 1);
        insertBST(root, 10);
        insertBST(root, 3);
        insertBST(root, 7);
        insertBST(root,6);
        insertBST(root, 4);
        insertBST(root, 9);
        inOrder(root);
        deleteBST(root, 4);
        System.out.println();
        inOrder(root);
    }
}
