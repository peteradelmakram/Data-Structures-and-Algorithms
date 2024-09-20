package Finals;
import java.util.*;
import Queues.Queue;
import Stacks.Stack;

class Node{

       public Comparable data;
       public Node left,right;
   
       public Node (Comparable data){
           this(data, null, null);
       }
   
       public Node(Comparable data, Node left, Node right){
   
           this.data = data;
           this.left = left;
           this.right = right;
       }
       
       public String toString(){
           return this.data + " ";
       }
   }
public class BTree {
    
    private Node root;

	public BTree() {
		root = null;
	}

    public void add(Comparable key) {
		Node current = root, parent = null;
		while (current != null) {
			if (key.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			}

			else{
				parent = current;
				current = current.right;
			}
		}

		if (parent == null)
			root = new Node(key);

		else {
			if (key.compareTo(parent.data) < 0)
				parent.left = new Node(key);

			else
				parent.right = new Node(key);
		}
	}

	public boolean delete(Comparable key) {
        if (root == null)
               return false;
        Node current = root;
        Node parent = root;
        boolean right = true;
        // searching for the node to be deleted
        while (key.compareTo(current.data) != 0) {  
               if (key.compareTo(current.data) < 0) {         right = false;
                     parent = current;
                     current = current.left;
               } else {
                     right = true;
                     parent = current;
                     current = current.right;
               }
               if (current == null)
                     return false;
        }

        Node substitute = null;
        //  case 1: Node to be deleted has no children
        if (current.left == null && current.right == null)
               substitute = null;

        //  case 2: Node to be deleted has one child
        else if (current.left == null)
               substitute = current.right;
        else if (current.right == null)
               substitute = current.left;
        else // case 3: Node to be deleted has two children
        {
               Node successor = current.right;
               Node successorParent = current;
               //  searching for the inorder successor of the node to be deleted
               while (successor.left != null) {
                     successorParent = successor;
                     successor = successor.left;
               }
               substitute = successor;
               if (successorParent == current) {
                     if (successor.right == null)
                            successorParent.right = null;
                     else
                            successorParent.right = successor.right;
               } else {
                     if (successor.right == null)
                            successorParent.left = null;
                     else
                            successorParent.left = successor.right;
               }
               successor.right = current.right;
               successor.left = current.left;
               substitute = successor;
        } // case 3 done
        if (current == root) // Replacing the deleted node
               root = substitute;
        else if (right)
               parent.right = substitute;
        else
               parent.left = substitute;
        return true;

 }

	public void displayTree()
	{
		java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			java.util.Stack<Node> localStack = new java.util.Stack<Node>();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
				System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			}  // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
	}


/* START OF FINAL PROBLEMS: */
       //Exercise 9-2 : Ideally Topological Tree from sorted array.
       public static BTree idealTopology(int[] arr){
             Node n =  idealTopology (arr, 0, arr.length -1);
             BTree t = new BTree();
             t.root = n;
             return t;
       }

       public static Node idealTopology(int[] arr, int l, int r){
             if(l > r) return null;
             int mid = l + (r-l) /2;
             Node n = new Node(arr[mid]);

             n.left = idealTopology(arr, l, mid-1);
             n.right = idealTopology(arr, mid+1, r);

             return n;
       }

       //Exercise 9-3: Max Key in BST:
       public Comparable maxKey(){
              Node curr = root;
              while(curr.right != null){
                     curr = curr.right;
              }

              return curr.data;
       }

       //Exercise 9-4: Recursive implementation of max key in a regular binary tree:
       public Comparable maxKeyRec(){
              return maxKeyRec(root);
       }

       public Comparable maxKeyRec(Node root){
              if(root == null){
                     return -1;
              }
              Comparable maxLeft = maxKeyRec(root.left);
              Comparable maxRight = maxKeyRec(root.right);

              return Math.max((int) root.data, Math.max((int) maxLeft, (int) maxRight));
       }

       //Exercise 9-5: a) size:
       public int size(){
              return size(root);
       }
       public int size(Node root){
              if(root == null) return 0;
              else{
                     return 1 + size(root.left) + size(root.right);
              }
       }

       // b) Number of leaves:
       public int numOfLeaves(){
              return numOfLeaves(root);
       }
       public int numOfLeaves(Node root){
              if(root == null) return 0;
              if(root.left == null && root.right == null) return 1;
              return numOfLeaves(root.left) + numOfLeaves(root.right);
       }

       // c) Sum of all nodes:
       public int sum(){
              return sum(root);
       }
       public int sum(Node root){
              if(root == null) return 0;
              else{
                     return (int) root.data + sum(root.left) + sum(root.right);
              }
       }

       // e) numOfLeftChildNodes : returns the number of nodes having a left child and no right child.
       public int numOfLeftChildNodes(){
              return numOfLeftChildNodes(root);
       }

       public int numOfLeftChildNodes(Node root){
              if(root == null) return 0;
              if(root.left != null && root.right == null) return 1;
              return numOfLeftChildNodes(root.left) + numOfLeftChildNodes(root.right);
       }

       //f) numOfOccurences : how many times key occurs in the tree :
       public int occurences(int key){
              return occurences(root, key);
       }
       public int occurences(Node root, int key){
              if(root == null) return 0;
              if(root.data.equals(key)) return 1 + occurences(root.left, key) + occurences(root.right, key) ;
              return occurences(root.left, key) + occurences(root.right, key);
       }

       //g) invert tree: invert the tree.
       public void invert(){
              invert(root);
       }
       public void invert(Node root){
              if(root == null) return;
              invert(root.left);
              invert(root.right);

              Node tmp = root.right;
              root.right = root.left;
              root.left = tmp;
       }

       //Exercise 9-6 : Level of a node: 
       public int level(int key){
              return level(root, key);
       }

       public int level(Node root, int key){
              if(root == null) return -1;

              if(root.data.equals(key)) return 0;

              int leftDepth = level(root.left, key);

              if(leftDepth != -1){
                     return 1 + leftDepth;
              }

              int rightDepth = level(root.right, key);

              if(rightDepth != -1){
                     return 1+ rightDepth;
              }

              return -1;
       }

       //Exercise 9-7: double values:
       public void doubleVal(){
              doubleVal(root);
       }

       public void doubleVal(Node root){
              if(root == null) return;

              doubleVal(root.left);
              doubleVal(root.right);

              root.data = (int) root.data *2;
       }

       //Exercise 10-4: Level printing: given int l, print all nodes on that level.
       public void printLevel(int l){
              printLevel(root, l, 0);
       }
       public void printLevel(Node root, int l, int x){
              if(root == null) return;
              if(x == l){
                     System.out.print(root.data + " ");
              }
              
              printLevel(root.left, l, x+1);
              printLevel(root.right, l, x+1);
       }

       //Exercise 10-5: LevelOrder traversal:
       public void BFS(){
              BFS(root);
       }
       public void BFS(Node root){
              if(root == null) return;
              Queue Q = new Queue();
              Q.enqueue(root);

              while(!Q.isEmpty()){
                     Node tmp = (Node) Q.dequeue();
                     System.out.print(tmp.data + " ");

                     if(tmp.left != null){
                            Q.enqueue(tmp.left);
                     }
                     if(tmp.right != null){
                            Q.enqueue(tmp.right);
                     }
              }
       }

       //Exercise 10-6: Print BST in descending order: (Reverse inorder (R -> Root -> L))
       public void descendingOrder(){
              descendingOrder(root);
       }
       public void descendingOrder(Node root){
              if(root == null) return;
              descendingOrder(root.right);
              System.out.print(root.data + " ");
              descendingOrder(root.left);
       }
       //Exercise 10-7: Print all nodes within range: (Lower Bound < Key < Upper Bound)
       public void printRange(int l, int u){
              printRange(root, l, u);
       }
       public void printRange(Node root, int l, int u){
              if(root == null) return;
              if((int) root.data >= l && (int) root.data <= u){
                     System.out.print(root.data + " ");
              }
              printRange(root.left, l, u);
              printRange(root.right, l, u);
       }

       //Exercise 10-8: Perform preorder traversal using an iterative approach:
       public void preOrderIterative(){
              preOrderIterative(root);
       }
       public void preOrderIterative(Node root){
              if(root == null) return;
              Stack s = new Stack();
              s.push(root);

              while(!s.isEmpty()){
                     Node tmp = (Node) s.pop();
                     System.out.print(tmp.data + " ");

                     if(tmp.right != null){
                            s.push(tmp.right);
                     }

                     if(tmp.left != null){
                            s.push(tmp.left);
                     }
              }
       }

       //Exercise 10-9: Return a linked list that gives the shortest path from root to node with key K:
      
       public LinkList shortestPath(int k){
              LinkList res = new LinkList();
              shortestPathHelper(root, k, res);
              return res;
       }
       
       public boolean shortestPathHelper(Node root, int k, LinkList res){
              if(root == null)return false;
              res.insertLast(root);
              if(root.data.equals(k)) return true;
              if(shortestPathHelper(root.left, k, res) || shortestPathHelper(root.right, k, res)) return true;
              res.removeLast();
              return false;
       }

       //Exercise 10-10: a) Recursive method to find height of a tree:
       public int heightRec(){
              return heightRec(root);
       }
       public int heightRec(Node root){
              if(root == null) return 0;
              return 1 + Math.max(heightRec(root.left), heightRec(root.right));
       }

       // b) Iterative method to find height of a tree:
       public int heightIter(){
              if(root == null) return -1;
              int h = -1;
              Queue Q = new Queue();
              Q.enqueue(root);

              while(!Q.isEmpty()){
                     Queue tempQ = new Queue();

                     while(!Q.isEmpty()){
                            Node tmp = (Node) Q.dequeue();
                            if(tmp.left != null){
                                   tempQ.enqueue(tmp.left);
                            }

                            if(tmp.right != null){
                                   tempQ.enqueue(tmp.right);
                            }
                     }
                     ++h;
                     Q = tempQ;
              }

              return h;
       }

       void printZigZagTraversal() {
              if (root == null) {
                     return;
              }

              Stack currentLevel = new Stack();
              Stack nextLevel = new Stack();

              currentLevel.push(root);
              boolean leftToRight = true;
              while (!currentLevel.isEmpty()) {
                     Node node = (Node) currentLevel.pop();
                     System.out.print(node.data + " ");
                     if (leftToRight) {
                            if (node.left != null) {
                                   nextLevel.push(node.left);
                            }
                            if (node.right != null) {
                                   nextLevel.push(node.right);
                            }
                     }
                     else {
                            if (node.right != null) {
                                   nextLevel.push(node.right);
                            } 
                            if (node.left != null) {
                                   nextLevel.push(node.left);
                            }
                     }
                     if (currentLevel.isEmpty()) {
                            leftToRight = !leftToRight;
                            Stack temp = currentLevel;
                            currentLevel = nextLevel;
                            nextLevel = temp;
                     }
              }
       }


       public void duplicate(){
              duplicate(root);
       }
       public void duplicate(Node root){
              if(root == null) return;

              duplicate(root.left);
              duplicate(root.right);
              //Stores left subtrees:
              Node n = root.left;
              //Duplicates the value to the left
              root.left = new Node(root.data);
              //Return the stored left subtree to left -> left
              root.left.left = n;
       }



       public int numNodes(){
              return numNodes(root);
       }
       public int numNodes(Node root){
              if(root == null) return 0;
              return 1 + numNodes(root.left) + numNodes(root.right);
       }
       public int weightBalance(){
              return weightBalance(root);
       }
       public int weightBalance(Node root){
              if(root == null){
                     return 0;
              }
              int LNum = numNodes(root.left);
              int RNum = numNodes(root.right);

              return Math.max(Math.abs(LNum-RNum), Math.max(weightBalance(root.left), weightBalance(root.right)));
       }
       public int diameter(){
              return diameter(root);
       }
       public int diameter(Node root){
              if(root == null) return 0;
              int LNum = numNodes(root.left);
              int RNum = numNodes(root.right);

              return Math.max(LNum + RNum + 1, Math.max(diameter(root.left), diameter(root.right)));
       }

       public void printInRange(int l, int h){
              printInRange(root, l, h);
       }
       public void printInRange(Node root, int lo, int hi){
              Stack s = new Stack();
              Node tmp = root;
              while(!s.isEmpty() || tmp != null){
                     if(tmp != null){
                            s.push(tmp);
                            tmp = tmp.left;
                     }else{
                            tmp = (Node) s.pop();
                            if((int)tmp.data >= lo && (int) tmp.data <= hi){
                                   System.out.print(tmp.data + " ");
                            }
                            tmp = tmp.right;
                     }
              }
       }

       public int getWidth(){
              return getMaxWidth(root);
       }
       public int getMaxWidth(Node root){
              int maxW = -1;
              int h = heightRec();

              for(int i = 0; i < h; i++){
                     int w = getWidth(root, i);
                     maxW = Math.max(w, maxW);
              }

              return maxW;
       }
       public int getWidth(Node root, int level){
             if(root == null) return 0;
             if(level == 0) return 1;
             else{
                     return getWidth(root.left, level -1) + getWidth(root.right, level -1);
              } 
       }

       public boolean validBST(){
              return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
       }
       public boolean validBST(Node root, int lo, int hi){
              if(root == null){
                     return true;
              }
              if((int) root.data <= lo || (int) root.data >= hi) return false;
              boolean l = validBST(root.left, lo, (int) root.data + 1);
              boolean r = validBST(root.right, (int) root.data -1, hi);
              if(l && r){
                     return true;
              }else{
                     return false;
              }
       }

       public void printCousisns(int n){
              printCousins(root, n);
       }

       public void printCousins(Node root, int n){
              Node curr = root , parent = root, grandParent = root;
              boolean cont = true;

              while(cont){
                     int res = ((Comparable) curr.data).compareTo(n);
                     if(res == 0){
                            cont = false;
                     }else if(res > 0){
                            grandParent = parent;
                            parent = curr;
                            curr = curr.left;
                            if(curr == null) cont = false;
                     }else{
                            grandParent = parent;
                            parent = curr;
                            curr = curr.right;
                            if(curr == null) cont = false;
                     }

                     if(curr == null){
                            System.out.println(-1);
                            return;
                     }

                     Node uncle;
                     if(grandParent.left == parent){
                            uncle = grandParent.right;
                     }else{
                            uncle = grandParent.left;
                     }

                     String cousins = "";
                     cousins += (uncle.left.data) + " " + (uncle.right.data);
                     System.out.println(cousins);
              }
              
       }

       public Node LowestCommonAncestor(int p, int q){
              return LowestCommonAncestor(root, p, q);
       }
       public Node LowestCommonAncestor(Node root, int p, int q){
              if(root == null) return null;
              if((int) root.data > p && (int) root.data > q){
                     return LowestCommonAncestor(root.left, p, q);
              }
              if((int) root.data < p && (int) root.data < q){
                     return LowestCommonAncestor(root.right, p, q);
              }
              return root;
       }
       
       public static void main(String[] args) {
              BTree t = new BTree();
              t.add(20);
              t.add(15);
              t.add(10);
              t.add(17);
              t.add(16);
              t.add(25);
              t.add(22);
              t.add(29);
              t.add(27);
              t.add(34);
              t.add(2);
              t.add(19);
              t.displayTree();  
              
              System.out.println(t.LowestCommonAncestor(22, 29));
       }
}
