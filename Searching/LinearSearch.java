package Searching;

public class LinearSearch {

    //Linear search, O(n) search time
    public static int linearSearch(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key)
                return i;
        }
        return -1;
    }

    //Binary search, O(log n) search time
    public static int binarySearch(int[] arr, int key){
        int start = 0, end = arr.length -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }else if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

    public static int linearSearchRec(int[] arr, int key){
        return linearSearchRec(arr, key, 0);
    }

    public static int linearSearchRec(int[] arr, int key, int idx){
        if(idx >= arr.length) return -1;
        if(arr[idx] == key) return idx;
        return linearSearchRec(arr, key, idx+1);
    }

    public static int binarySearchRec(int[] arr, int key, int low, int mid, int high){
        if(low > high) return -1;
        if(arr[mid] == key) return mid;
        int middle = low + (high-low)/2;
        if(key> arr[mid]) return binarySearchRec(arr, key, mid +1, middle, high);
        else return binarySearchRec(arr, key, low, middle, mid +1);
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped) return;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
