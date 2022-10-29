package LeetCode;
import java.util.*;

public class SessionFive {
    //75. Sort Colors (Dutch national flag problem)
    public void sortColors(int[] arr) {
        int i = 0, j = 0, k = arr.length -1;
        while(i <= k){
            if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }else if(arr[i] == 1){
                i++;
            }else if(arr[i] == 2){
                swap(arr, i, k);
                k--;
            }
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //118. Pascal's triangle
    public List<List<Integer>> generate(int numRows) {
        // Instantiate return type
        List<List<Integer>> triangle = new ArrayList<>();
        //Prelimenary check (if number of rows = 0, return empty array.)
        if(numRows == 0) return triangle;
        
        List<Integer> firstRow = new ArrayList<>();
        //adds the first row with the 1
      
        firstRow.add(1);
        triangle.add(firstRow);
          /**
        triangle : [ [1] ]
        */
        
        for(int i = 1; i < numRows; i++){
            //gets the previous row.
            List<Integer> prevRow = triangle.get(i-1);
            //creates the new row to be added
            List<Integer> row = new ArrayList<>();
            //adds the first 1 on the left.
            row.add(1);
            //adds the element on the left of the previous row and right of the previous row
            for(int j = 1; j < i; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            //adds the last 1 on the right.
            row.add(1);
            //adds the row to the triangle.
            triangle.add(row);
        }
        
        return triangle;
    }
    
    //617. Merge Binary Trees
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        root1.val += root2.val; 
        
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
            
        return root1;
        
    }
}

