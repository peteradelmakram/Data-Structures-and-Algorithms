package LeetCode;

public class SessionSeven {
    //1768. Merge strings alternatly.
    public String mergeAlternately(String word1, String word2) {
        
        String result = "";
        int i = 0, j = 0;
        boolean x = true;
        while(i < word1.length() && j < word2.length()){
            if(x){
                result += word1.charAt(i);
                i++;
            }else{
                result += word2.charAt(j);
                j++;
            }
            x = !x;
        }
        
        while(i < word1.length()){
            result += word1.charAt(i);
            i++;
        }

        while(j < word2.length()){
            result += word2.charAt(j);
            j++;
        }
        
        return result;
    }

    //1480. Running Sum of 1d Array (prefix sum array)
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            result[i] = sum;
        }
        
        return result;
    }

    //724. Find Pivot Index
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        
        int n = nums.length;
        int totalSum = 0, leftSum = 0;
        
        for(int i : nums){
            totalSum += i;
        }
        
        for(int i = 0; i < n; i++){
            if(leftSum == (totalSum - nums[i]))
                return i;
            else{
                leftSum += nums[i];
                totalSum -= nums[i];
            }
        }
        
        return -1;
    }

    //392. Is Subsequence
    public boolean isSubsequence(String s, String t) {
        for(int i = 0; i < t.length() && s.length() > 0; i++){
            if(t.charAt(i) == s.charAt(0))
               s = s.substring(1, s.length());
        }
        
        return s.isEmpty();
    }

}
