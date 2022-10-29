package LeetCode;
import java.util.*;

public class SessionEight {
    //2154. Keep Multiplying Found Values by Two
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        boolean flag = true;
        while(flag){
            if(binarySearch(nums,original)){
                original *=2;
                binarySearch(nums, original);
            }else{
                flag = false;
            }
        }
        return original;
    }
    
    public boolean binarySearch(int[] nums, int key){
        int i = 0, j = nums.length -1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if(nums[mid] == key) return true;
            if(key > nums[mid]) i = mid +1;
            if(key < nums[mid]) j = mid -1;
        }
        return false;
    }


    //1305. All Elements in Two Binary Search Trees
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        
        Helper(root1, result);
        Helper(root2, result);
        
        Collections.sort(result);
        
        return result;
    }
    
   
    public void Helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        
        Helper(root.left, list);
        Helper(root.right, list);
        
    }

    //215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        heapSort(nums);
        
        int index = nums.length -k;
        
        return nums[index];
    }
    
    public static void heapSort(int[] arr){
        int n = arr.length;
        
        for(int i = n/2 -1; i >= 0; i--){
            maxHeapify(arr, n,  i);
        }
        
        for(int i = n -1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, i, 0);
        }
    }
    
    public static void maxHeapify(int[] arr,int n, int i){
        int left = 2*i + 1, right = 2*i + 2;
        int largest = i;
        
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n, largest);
        }
    }
}
