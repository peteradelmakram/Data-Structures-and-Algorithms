import java.util.Arrays;

public class SessionA {
    
    public static void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    //Traverse array from index 0 to index n - 1, search arr[index] for key.
    public static int linearSearch(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    //Base case : i == arr.length
    public static int linearSearchRecursive(int[] arr, int key, int i){
        if(i >= arr.length) return -1;
        
        if(arr[i] == key) return i;

        return linearSearchRecursive(arr, key, i+1);
    }

    //Find middle index, if key is greater search the right side, if key is smaller search the left side.
    public static int binarySearch(int[] arr, int key){
        int lo = 0, hi = arr.length -1;
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == key) {
                return mid;
            }else if(key > arr[mid]){
                lo = mid + 1;
            }else{
                hi = mid -1;
            }
        }
        return -1;
    }

    //lo >= hi : base case
    public static int binarySearchRecursive(int[] arr, int key, int lo, int hi){
        if(lo > hi) return -1;

        int mid = (lo+hi)/2;

        if(arr[mid] == key){
            return mid;
        }else if(key > arr[mid]){
            return binarySearchRecursive(arr, key, mid + 1, hi);
        }else{
            return binarySearchRecursive(arr, key, lo, mid-1);
        }
    }

    //Normal bubble sort O(n^2), compares two elements and swaps them if the element at j is greater than the element at j+1
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    //Optimized bubble sort, if array is sorted, no swapping, therefore, break the loop.
    public static void bubbleSortOpt(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            boolean swapped = false;

            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }

            if(swapped == false) return;
        }
    }

    //Recursive bubble sort. n is arr.length.
    public static void bubbleSortRecursive(int[] arr, int n){
        if(n == 0 || n == 1) return;

        for(int i = 0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp; 
            }
        }

        bubbleSortRecursive(arr, n-1);
    }

    //Efteker el kotshena
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int j;

            for(j = i-1; j>= 0; j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }
            }

            arr[j+1] = tmp;
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIdx = i;

            for(int j = i +1; j < arr.length; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }

















    public static void main(String[] args) {
        System.out.println(603 + 382 / 281 * 32 -4);
    }
}
