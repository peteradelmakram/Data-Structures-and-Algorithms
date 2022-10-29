public class BubbleSort {

    //Runs in O(n^2) time and uses O(1) space.
    // Horribly inefficient and takes a very long time even in best case scenario.

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp; 
                }
            }
        }
    }

    public static void bubbleSortDescending(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] < arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp; 
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7,};
        bubbleSortDescending(arr);
        for(int i : arr){
            System.out.print(i);
        }
    }
}
