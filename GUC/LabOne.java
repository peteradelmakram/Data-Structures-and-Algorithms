package GUC;

class LabOne {
    public static void shakeSort(int[] arr){
        for(int i = 0; i < (arr.length)/2 ; i++){
            for(int j = i; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp; 
                }
            }
            for(int k = arr.length - 2 - i; k >= i; k--){
                if(arr[k] > arr[k+1]){
                    int tmp = arr[k];
                    arr[k] = arr[k+1];   
                    arr[k+1] = tmp;                
                }
            }
        }
    }

    public static void booleanSort(int[] arr){
        //O(n) <---
        int max = Integer.MIN_VALUE;
        for(int x : arr){
            if(x > max){
                max = x;
            }
        }
        boolean[] flag = new boolean[max+1];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= max){
                flag[arr[i]] = true;
            }
        }
        int j = 0;
        for(int k = 0; k < flag.length; k++){
            if(flag[k] && j <= arr.length){
                arr[j] = k;
                j++;
            }
        }

    }

    public static void countingSort(int[] arr){
        // O(n^2)
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }        
        int[] x = new int[max+1];     
        
        for(int i = 0; i < max +1; i++){
            x[i] = 0;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= max){
                x[arr[i]]++;
            }
        }

        int j = 0;
        for(int k = 0; k < x.length; k++){
            if(x[k] > 0 && j < arr.length){
                for(int i = 0; i < x[k] && j < arr.length; i++){
                    arr[j] = k;
                    j++;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {9,8,7,7,6,5,4,4,7};

        countingSort(arr);
    }    
}
