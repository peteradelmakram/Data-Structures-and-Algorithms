public class Arrays {
    static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static int[] removeEven(int[] arr){
        int [] result;
        int odd = 0;
        for(int i= 0; i < arr.length; i++){
            if(arr[i] % 2 != 0)
                odd++;
        }
        result = new int[odd];
        int j = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] % 2 != 0){
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }
    static int[] reverseInPlace(int[] arr){
        int temp;
        for(int i = 0; i < arr.length/2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
    static int[] reverseTemp(int[] arr){
        int[] result = new int[arr.length];
        int j = arr.length;
        for(int i = 0; i < arr.length; i++){
            result[j-1] = arr[i];
            j--;
        }
        return result;
    }
    static int[] reverseAdvance(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
    static int findMinValue(int []arr){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    static int findSecondMax(int[] arr){
       int max = Integer.MIN_VALUE;
       int secondMax = Integer.MIN_VALUE;
       for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
       }
       return secondMax;
    }
    static int[] moveZerosToEnd(int [] arr){
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
        return arr;
    }
    static int[] resize(int [] arr, int capacity){
        int[] temp = new int[capacity];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        return temp;
    }
    static int missingNumber(int[] arr){
        int n = arr.length+1, total = n*(n+1)/2, sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return total-sum;
    }
    static boolean palindrome(String str){
        int j = str.length();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(j-1)){
                return false;
            }
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.print(palindrome("witchcraft"));
    }
}
