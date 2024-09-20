public class MaxHeap {
  int[] heap;
  int size;

  /*
                          10 at index == 1 (node.left at index 2*1 && node.right
     at 2*1+1)
                        /    \
                      9       8 left at index 2 and right at index 3. (for left:
     left at 2*2 && right at 2*2+1) & (for right: left at 2*3 && right at 2*3+1)
                   /    \    /   \
                   7(4) 6(5) 5(6) 4(7)
                 /   \ / \ / \   / \
               3     2 1 n n  n  n  n    (n == null)

      For parent n:
          left son at 2*n and right son at 2*n+1

      For son at n:
          Parent at n//2. (6//2 == 3 and 5//2== 3)

   */

  int[] sampleHeap = {
      Integer.MIN_VALUE, 16, 10, 4, 5, 6, 14, 7, 3, 2, 1, 4, 2, 8, 1};

  public MaxHeap(int cap) {
    heap = new int[cap + 1];
    size = 0;
  }

  public boolean isEmpty() { return size == 0; }

  public int[] resize(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < heap.length; i++) {
      arr[i] = heap[i];
    }
    return arr;
  }

  public void insert(int x) {
    // if Heap array is full, resize it to add one extra spot to insert.
    if (size == heap.length - 1)
      heap = resize(heap.length + 1);
    // increment the position attribute
    size++;
    // place the int int the binary heap at location n.
    heap[size] = x;
    // relocate it within the heap so it's balanced
    swim(size);
  }

  public void swim(int n) {
    // while the parent node is less than the node inserted at location n.
    // replace the son node inserted at n to the parent by using temp vars.
    while (n > 1 && heap[n / 2] < heap[n]) {
      int temp = heap[n];
      heap[n] = heap[n / 2];
      heap[n / 2] = temp;
      n = n / 2;
    }
  }

  public int deleteMax() {
    int max = heap[1];

    swap(1, size);
    size--;
    sink(1);

    heap[size + 1] = -1; // signifying null.

    if (size > 0 && size == (heap.length - 1) / 4) {
      heap = resize(heap.length / 2);
    }

    return max;
  }

  public void sink(int k) {
    // There must be enough parents to compare with children, so 2*k must be
    // less than or equal to n (total number of nodes.)
    while (2 * k <= size) {
      // the left child of k.
      int j = 2 * k; // == (k.left)
      // Must ensure that parent has a right child aswell && if the right child
      // is greater than the left child, go to right and increment j.
      if (j < size && heap[j] < heap[j + 1]) {
        j++; //(go to k.right)
      }
      // Make sure that the parent node is less than the child node.
      if (heap[k] >= heap[j]) {
        break;
      }
      // swap the child the node with the parent node.
      swap(k, j);
      // update the counter.
      k = j;
    }
  }

  // Algorithms Chapter 6.1:
  public int[] maxHeapify(int n, int[] heap) {
    int left = 2 * n, right = 2 * n + 1;
    int largest;
    if (left <= heap.length && heap[left] > heap[n]) {
      largest = left;
    } else {
      largest = n;
    }

    if (right <= heap.length && heap[right] > heap[largest]) {
      largest = right;
    }

    if (largest != n) {
      int temp = heap[n];
      heap[n] = heap[largest];
      heap[largest] = temp;
      maxHeapify(largest, heap);
    }

    return heap;
  }

  public void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(14);

    int[] newHeap = maxHeap.maxHeapify(3, maxHeap.sampleHeap);

    for (int x : newHeap) {
      System.out.print(x + " ");
    }
  }
}
