public class InsertionSort {
    // Runs in O(n^2) time and uses O(1) space
    // Best case scenario is O(n), much faster than Bubble Sort in Best Case.
    // Best to add data to an already sorted file.
    
    public static void insertionSort(int [] arr){
        for(int i = 1; i < arr.length ; i++){
            
            int value = arr[i];
            int j;

            for(j = i -1; j >= 0 && arr[j] > value; j--){
                arr[j+1] = arr[j];
            }

            arr[j+1] = value;
        }
    }

    public static void insertionSortDescending(int [] arr){
        for(int i = 1; i < arr.length ; i++){
            int value = arr[i];
            int j;
            for(j = i -1; j >= 0 && arr[j] < value; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = value;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        insertionSortDescending(arr);
        
        for(int i : arr){
            System.out.print(i + " ");
        }

    }
}
