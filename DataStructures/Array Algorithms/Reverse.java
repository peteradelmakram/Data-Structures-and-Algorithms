public class Reverse{
    
    private static void reverse(int[] arr, int start, int end){
        int i = start, j = end;
        int length = (start + end)/2;
        for(; i < length + 1; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(arr, 1, 4);

        for(int i : arr){
            System.out.print(i + " ");
        }

    }
    
}
