package PracticeAssignments;

public class PracticeAssignmentOne {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        System.out.println(binarySearchRecursive(arr, 5));
    }
    //Linear search recursively.
    public static int linearSearchRecursive(int[] arr, int n, int key){
        if(arr.length < n) return -1;

        if(arr[n] == key) return n;

        return linearSearchRecursive(arr, n+1, key);
    }

    //Find node recursively.
    public static Link findRecursively(Link head, int key){
        if(head == null) return head;
        
        if(head.data == key) return head;

        return findRecursively(head.next, key);
    }

    //Binary search recursively.
    public static int binarySearchRecursive(int[] arr, int key){
        int start = 0, end = arr.length -1;
        int mid = start + (end-start)/2;

        return binarySearchRecursive(arr, start, mid, end, key);
    }
    
    //Helper method.
    public static int binarySearchRecursive(int[] arr, int start, int mid, int end, int key) {
        if(start > end) return -1;
        int middle = start + (end-start)/2;
        if(arr[mid] == key) return mid;
        else{
            if(key > arr[mid]){
                return binarySearchRecursive(arr, mid+1, middle, end, key);
            }else{
                return binarySearchRecursive(arr, start, middle, mid-1, key);
            }
        }
    }


    static class Link{
        public int data;
        public Link next;

        public Link(int data){
            this.data = data;
            this.next = null;
        }
    }
}
