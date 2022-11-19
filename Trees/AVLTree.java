package Trees;

public class AVLTree{
    public Node root;

    public class Node{
        int val, height;
        Node left, right;

        public Node(int val){
            this.val = val;
            height = 1;
        }
    }

    
    static int max(int a , int b){
        return (a > b) ? a : b;
    }

    static int height(Node n){
        if(n == null) return 0;
        else return n.height;
    }

    public Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public int getBalance(Node node){
        if(root == null) return 0;
        return height(node.left) - height(node.right);
    }

    public Node insert(Node root, int key){
        if(root == null) return new Node(key);
        if(key < root.val) root.left = insert(root.left, key);
        else if(key > root.val) root.right = insert(root.right, key);
        else return root;

        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        //Left-Left Case:
        if(balance > 1 && key < root.left.val) return rightRotate(root);
        //Right-Right Case:
        if(balance < -1 && key > root.right.val) return leftRotate(root);

        //Left-Right Case:
        if(balance > 1 && key > root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //Right-Left Case:
        if(balance < -1 && key < root.right.val){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public int getMinNode(Node root){
        int minV = root.val;
        while(root.left != null){
            minV = root.left.val;
            root = root.left;
        }
        
        return minV;
    }

    public Node deleteNode(Node root, int key){
        if(root == null) return root;

        if(key < root.val) root.left = deleteNode(root.left, key);
        if(key > root.val) root.right = deleteNode(root.right, key);
        else{
            if((root.right == null) || (root.left == null)){
                Node temp = null;

                if(temp == root.left){
                    temp = root.right;
                }else{
                    temp = root.left;
                }

                if(temp == null){
                    temp = root;
                    root = null;
                }else root = temp;
            }else{
                int min = getMinNode(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        }

        if(root == null) return root;

        root.height = max(height(root.left), height(root.right)) + 1;
        int balanceFactor = getBalance(root);

        if(balanceFactor > 1){
            if(getBalance(root.left) >= 0) return rightRotate(root);
            else{
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if(balanceFactor < -1 ){
            if(getBalance(root.right) <= 0) return leftRotate(root);
            else{
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        return root;
    }


}
