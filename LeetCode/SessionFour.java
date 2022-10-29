package LeetCode;
import java.util.*;

public class SessionFour {

    //104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        
        root.left = right;
        root.right = left;
        
        return root;
    }

    // 257. Binary Tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        //In case root is empty
        if(root == null) return result;
        String currPath = Integer.toString(root.val);
        //In case root has no children.
        if(root.left == null && root.right == null) result.add(currPath);

        //Recursively traverse the left and right nodes. preOrder dfs.
        if(root.left != null) dfs(root.left, currPath, result);
        if(root.right != null) dfs(root.right, currPath, result);
        return result;
    }
    
    //preOrder traversal dfs (Operation on root -> Left subtree -> Right subtree)
    public void dfs(TreeNode root, String currPath,  List<String> result){
        //adds the value 
        currPath += "->" + root.val;
        
        //Base case defined, return only if leaf node reached.
        if(root.right == null && root.left == null){
            result.add(currPath);
            return;
        }
        
        if(root.left != null) dfs (root.left, currPath, result);
        if(root.right != null) dfs (root.right, currPath, result);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        left = null;
        right = null;
        this.val = val;
    }
}