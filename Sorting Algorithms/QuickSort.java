public class QuickSort {
    //Divide and conquer algorithm, runs in best case: O(n log n ) time and worst case: O(n^2)
    // O(log n) memory used due to recursive calls stacking up memory.

    private static void quickSort(int[] arr, int start, int end) {
        if(end <= start) return; //Base-case for recursive calls.
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot -1);
        quickSort(arr, pivot +1, end);
    }
    
    private static int partition(int[] arr, int start, int end){
        int pointer = arr[end];
        int i = start -1;
        for(int j = start; j < end ; j++){
            if(arr[j] < pointer){
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[++i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }
    public static void main(String[] args) {
        int[] array = {9, -3, -4, -5, 5, 7, -10, -100, 486};

        quickSort(array, 0, array.length -1);
        
        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
