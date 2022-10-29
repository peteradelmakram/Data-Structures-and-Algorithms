package LeetCode;

public class SessionOne {
    //Problem 1365
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] > nums[j])
                    count++;
            }
            res[i] = count;
        }
        return res;
    }

    //Problem 88
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m-1, k = n-1, i = m+n -1;
        while (k >= 0){
            if(j >= 0 && nums1[j] > nums2[k]){
                nums1[i--] = nums1[j--];
            }else{
                nums1[i--] = nums2[k--];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2,4,0,0};
        int[] arr2 = {1,3};
        merge(arr1, 2, arr2, 2);

        for(int i : arr1){
            System.out.print(i + " ");
        }
    }
}
