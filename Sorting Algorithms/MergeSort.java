public class MergeSort {
    // runs in O(n log n) time but uses O(n) space faster than selection, insertion and bubble sort algorithms.
    //Divide and Conquer Algorithm. Breaks down the array into smaller subarrays.
    // However if memory is an issue, better use quicksort.
    // Preferred method of sorting for linked lists as you're given a head, tail and it's easy to work your way around them. 

    private static void mergeSort(int[] arr,int start, int end) {
        if(start < end){
        int mid = start + (end-start)/ 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end -mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for(int i = 0; i < n1; i++){
            L[i] = arr[start+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = start;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i++];
            }else{
                arr[k] = R[j++];
            }
            k++;
        }
        while(i < n1){
            arr[k++] = L[i++];
        }
        while(j < n2){
            arr[k++] = R[j++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};

        mergeSort(arr, 0, arr.length-1);
        
        for(int i : arr){
            System.out.print(i + " ");
        }
    }   
}
