package LeetCode;
import java.util.*;

public class SessionNine {
   //496. Next Greater Element I
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Map<Integer, Integer> map = new HashMap<>();
    
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
    
        for(int j = 0; j < nums1.length; j++){
            int x = map.get(nums1[j]);
            int y = nums1[j];
            for(int k = x + 1; k < nums2.length; k++){
                if(nums2[k] > y){
                    y = nums2[k];
                    break;
                }
            }
            if(y == nums1[j]){
                res[j] = -1;
            }else{
                res[j] = y;
            }
        }   
        return res;
    }

    //503. Next Greater Element II
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = nums.length -1; i >= 0; i--){
            stack.push(nums[i]);
        }
        for(int i = nums.length -1; i >= 0; i--){
            int n = nums[i];
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                nums[i] = -1;
            }else{
                nums[i] = stack.peek();
            }
            
            stack.push(n);
        }
        return nums;
    }

    //74. Search a 2D Matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length -1;
        
        while (i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        
        return false;
    }

    //2239. Find Closest Number to Zero
    public static int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;

        for(int n : nums){
            if(Math.abs(n) < min){
                min = Math.abs(n);
                ans = n;
            }
            else if(Math.abs(n) == min){
                ans = Math.max(ans, n);
            }
        }

        return ans;
    }

    //66. Plus One
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newArr = new int[n +1];
        newArr[0] = 1;
        
        return newArr;
    }

    //70. Climbing Stairs
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1,1);
        memo.put(2,2);
        return climbStairs(n, memo);
    }
    
    private int climbStairs(int n , Map<Integer,Integer> memo){
        if(memo.containsKey(n)) return memo.get(n);
        
        memo.put(n, (climbStairs(n-1, memo) + climbStairs(n-2, memo)));
        
        return memo.get(n);
    }

    //509. Fibonacci Number
    public int fib(int n) {
        Map<Integer,Integer> memo = new HashMap<>();
        memo.put(0,0);
        memo.put(1,1);
        return fib(n, memo);
    }
    
    public int fib(int n , Map<Integer,Integer> memo){
        if(memo.containsKey(n)) return memo.get(n);
        
        memo.put(n, (fib(n-1, memo) + fib(n-2, memo) ) );
        
        return memo.get(n);
    }

    //746. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length];
        
        return Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
    }
    
    private int minCost(int[] cost, int n, int[] dp){
        if(n < 0) return 0;
        if(n == 0 || n == 1) return cost[n];
        
        if(dp[n] != 0) return dp[n];
        
        dp[n] = cost[n] + Math.min(minCost(cost, n-1, dp) , minCost(cost, n-2, dp));
        
        return dp[n];
    }
}
