public class Heapsort{
    //Forcing an array into a heap structure.
    public static int[] buildMaxHeap(int[] arr){
        int n = arr.length;
        for(int i = n/2 - 1; i >= 0; i--){
            maxHeapify(arr,n, i);
        }
        return arr;
    }

    public static void buildMinHeap(int[] arr){
        for(int i = arr.length/2; i >= 0; i--){
            minHeapify(arr, i);
        }
    }
    
    //maxHeapify function O(logn)
    public static void maxHeapify(int arr[], int N, int i){
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2;
        if (l < N && arr[l] > arr[largest])
            largest = l;
        if (r < N && arr[r] > arr[largest])
            largest = r;
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            maxHeapify(arr, N, largest);
        }
    }

    public static void minHeapify(int[] arr, int i){
        int left = 2*i + 1, right = 2*i +2;
        int least;
        if(left < arr.length && arr[left] < arr[i]){
            least = left;
        }else{
            least = i;
        }

        if(right < arr.length && arr[right] < arr[least]){
            least = right;
        }

        if(least != i){
            int temp = arr[least];
            arr[least] = arr[i];
            arr[i] = temp;
            minHeapify(arr, least);
        }
    }

    public static void heapSort(int arr[]){
        int N = arr.length;
        buildMaxHeap(arr);

        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, i, 0);
        }
    }
    
    public static void main(String[] args) {

        int[] arr = {1,2,8,4,5,3,9,6,9};

        heapSort(arr);

        for(int x : arr){
            System.out.print(x + " ");
        }


    
    }
}
