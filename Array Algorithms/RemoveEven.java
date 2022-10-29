public class RemoveEven {

    public static int[] removeEven(int[] arr){
        int oddCount = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] % 2 != 0){
                oddCount++;
            } 
        }
        int[] odd = new int[oddCount];
        int k = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] % 2 != 0){
                odd[k] = arr[j];
                k++;
            }
        }
        return odd;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = removeEven(arr);

        for(int i : result){
            System.out.print(i + " ");
        }

    }
}
