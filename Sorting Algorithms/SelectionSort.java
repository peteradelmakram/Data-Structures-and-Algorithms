public class SelectionSort {
    //Runs in O(n^2) time and uses O(1) memory space.
    //Horribly inefficient as well, faster than bubble sort in best case scenario.

    public static void selectionSort(int [] arr){
        for(int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void selectionSortDescending(int []arr){
        for(int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            int min = arr[minIndex];
            for(int j = i +1; j < arr.length; j++){
                if(arr[j] > min){
                    minIndex = j;
                    min = arr[minIndex];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

    public static void main(String[] args) {
        int [] arr = {6, 5, 4, 3, 2, 1, 0};
        selectionSort(arr);

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
