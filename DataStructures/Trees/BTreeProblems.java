package Trees;
import LinkedLists.LinkList;
import Queues.Queue;
import javax.crypto.spec.RC5ParameterSpec;

class Node {

  public Comparable data;
  public Node left, right;

  public Node(Comparable data) { this(data, null, null); }

  public Node(Comparable data, Node left, Node right) {

    this.data = data;
    this.left = left;
    this.right = right;
  }

  public String toString() { return this.data + " "; }
}

class BTreeProblems {
  private Node root;

  public BTreeProblems() { root = null; }

  public void add(Comparable key) {
    Node current = root, parent = null;
    while (current != null) {
      if (key.compareTo(current.data) < 0) {
        parent = current;
        current = current.left;
      }

      else {
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
      if (key.compareTo(current.data) < 0) {
        right = false;
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
    }                    // case 3 done
    if (current == root) // Replacing the deleted node
      root = substitute;
    else if (right)
      parent.right = substitute;
    else
      parent.left = substitute;
    return true;
  }

  public void displayTree() {
    java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
    globalStack.push(root);
    int nBlanks = 32;
    boolean isRowEmpty = false;
    System.out.println(
        "......................................................");
    while (isRowEmpty == false) {
      java.util.Stack<Node> localStack = new java.util.Stack<Node>();
      isRowEmpty = true;

      for (int j = 0; j < nBlanks; j++)
        System.out.print(' ');

      while (globalStack.isEmpty() == false) {
        Node temp = globalStack.pop();
        if (temp != null) {
          System.out.print(temp.data);
          localStack.push(temp.left);
          localStack.push(temp.right);

          if (temp.left != null || temp.right != null)
            isRowEmpty = false;
        } else {
          System.out.print("--");
          localStack.push(null);
          localStack.push(null);
        }
        for (int j = 0; j < nBlanks * 2 - 2; j++)
          System.out.print(' ');
      } // end while globalStack not empty
      System.out.println();
      nBlanks /= 2;
      while (localStack.isEmpty() == false)
        globalStack.push(localStack.pop());
    } // end while isRowEmpty is false
    System.out.println(
        "......................................................");
  }

  public int numOfLeaves() { return numOfLeavesHelper(root); }

  public int numOfLeavesHelper(Node root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null) {
      return 1;
    }
    return numOfLeavesHelper(root.left) + numOfLeavesHelper(root.right);
  }

  public int level(Comparable key) { return levelHelper(key, root); }

  public int levelHelper(Comparable key, Node root) {
    if (root == null)
      return -1;
    if (root.data.compareTo(key) == 0) {
      return 0;
    }

    int l = levelHelper(key, root.left);

    if (l != -1) {
      return 1 + l;
    }

    int r = levelHelper(key, root.right);

    if (r != -1) {
      return 1 + r;
    }

    return -1;
  }

  public boolean equal(BTreeProblems T2) {
    return equalHelper(this.root, T2.root);
  }

  public boolean equalHelper(Node root1, Node root2) {
    if (root1 == null && root2 == null)
      return true;
    else if (root1 == null || root2 == null)
      return false;
    else {
      return (root1.data.compareTo(root2.data) == 0 &&
              equalHelper(root1.left, root2.left) &&
              equalHelper(root1.right, root2.right));
    }
  }

  public int sum() { return sumHelper(root); }

  public int sumHelper(Node root) {
    if (root == null) {
      return 0;
    }

    return (Integer)root.data + sumHelper(root.left) + sumHelper(root.right);
  }

  public boolean validBST() {
    return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean validBST(Node root, int min, int max) {
    if (root == null) {
      return true;
    }
    if ((Integer)root.data <= min || (Integer)root.data >= max) {
      return false;
    }
    boolean left = validBST(root.left, min, (Integer)root.data);
    if (left) {
      boolean right = validBST(root.right, (Integer)root.data, max);
      return right;
    }
    return false;
  }

  public int numLeftChildren() { return numLeftChildrenHelper(root); }

  public int numLeftChildrenHelper(Node root) {
    if (root == null)
      return 0;
    if (root.right == null && root.left != null) {
      return 1;
    }
    return numLeftChildrenHelper(root.left) + numLeftChildrenHelper(root.right);
  }

  public int countOccur(Comparable key) { return countOccurHelper(root, key); }

  public int countOccurHelper(Node root, Comparable key) {
    if (root == null)
      return 0;
    if (root.data.compareTo(key) == 0) {
      return 1 + countOccurHelper(root.left, key) +
          countOccurHelper(root.right, key);
    }

    return countOccurHelper(root.left, key) + countOccurHelper(root.right, key);
  }

  public boolean hasDups(Comparable key) {
    if (countOccurHelper(root, key) < 2) {
      return false;
    }
    return true;
  }

  public void mirror() { mirror(root); }

  public void mirror(Node root) {
    if (root == null)
      return;

    mirror(root.left);
    mirror(root.right);

    Node tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    return;
  }

  public void multiply(BTreeProblems t2) { multiplyHelper(this.root, t2.root); }

  public void multiplyHelper(Node root1, Node root2) {
    if (root1 == null || root2 == null) {
      return;
    }

    multiplyHelper(root1.left, root2.left);
    multiplyHelper(root1.right, root2.right);

    int tmp = (Integer)root1.data;
    int newVal = tmp * (Integer)root2.data;

    root1.data = newVal;

    return;
  }

  public boolean rightDivisibleByLeft() {
    return rightDivisibleByLeft(this.root);
  }

  public boolean rightDivisibleByLeft(Node root) {
    if (root.left == null || root.right == null) {
      return true;
    }

    return ((int)root.right.data % (int)root.left.data == 0) &&
        rightDivisibleByLeft(root.left) && rightDivisibleByLeft(root.right);
  }

  public boolean allOdd() { return allOddHelper(this.root); }

  public boolean allOddHelper(Node root) {
    if (root == null) {
      return true;
    }

    return ((int)root.data % 2 != 0) && allOddHelper(root.left) &&
        allOddHelper(root.right);
  }

  public boolean isSmaller(BTreeProblems tree2) {
    return isSmallerHelper(this.root, tree2.root);
  }

  public boolean isSmallerHelper(Node root1, Node root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null && root2 != null) {
      return true;
    } else if (root1 != null && root2 == null) {
      return false;
    }

    return ((int)root1.data < (int)root2.data) &&
        isSmallerHelper(root1.left, root2.left) &&
        isSmallerHelper(root1.right, root2.right);
  }

  public void printLevel(int n) { printLevel(0, n, this.root); }

  public void printLevel(int l, int n, Node root) {
    if (root == null) {
      return;
    }

    if (n != l) {
      printLevel(l + 1, n, root.left);
      printLevel(l + 1, n, root.right);
    }

    if (l == n) {
      System.out.print(root.data + " ");
    }
  }

  public void BFSTree() {
    Node curr = root;
    Queue Q = new Queue();

    Q.enqueue(curr);

    while (!Q.isEmpty()) {
      Node tmp = (Node)Q.dequeue();
      System.out.print(tmp.data + " ");
      if (tmp.left != null) {
        Q.enqueue(tmp.left);
      }
      if (tmp.right != null) {
        Q.enqueue(tmp.right);
      }
    }
  }

  public LinkList pathToKey(Comparable key) {
    LinkList res = new LinkList();
    pathToKey(res, this.root, key);
    return res;
  }

  public boolean pathToKey(LinkList res, Node root, Comparable key) {
    if (root == null) {
      return false;
    }

    res.insertLast(root);

    if (root.data.compareTo(key) == 0) {
      return true;
    }

    if (pathToKey(res, root.left, key) || pathToKey(res, root.right, key)) {
      return true;
    }

    res.removeLast();

    return false;
  }

  public String descendingOrder() { return descendingOrder(root); }

  // opposite of inorder traversal.
  public String descendingOrder(Node root) {
    if (root == null) {
      return " ";
    }
    return descendingOrder(root.right) + " " + root.data + " " +
        descendingOrder(root.left);
  }

  public static void main(String[] args) {
    BTreeProblems tree1 = new BTreeProblems();
    tree1.add(4);
    tree1.add(2);
    tree1.add(3);
    tree1.add(1);
    tree1.add(5);
    tree1.add(11);
    tree1.add(10);

    String r = tree1.descendingOrder();

    System.out.println(r);
  }
}