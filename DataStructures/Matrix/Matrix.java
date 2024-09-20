package Matrix;
public class Matrix {

  public static void search(int[][] arr, int x) {
    int i = 0, j = arr.length - 1;
    while (i < arr.length && j >= 0) {
      if (arr[i][j] == x) {
        System.out.print(x + " found at row " + i + " at column " + j);
        return;
      }
      if (arr[i][j] > x) {
        j--;
      } else {
        i++;
      }
    }
    System.out.print("Not Found!");
  }

  public static void printSpiral(int[][] arr) {
    // This has to be a m x m matrix.
    int i, k = 0, l = 0, r = arr.length, c = arr[0].length;
    while (k < r && l < c) {
      for (i = l; i < c; i++) // Left -> Right
        System.out.print(arr[k][i] + " ");
      k++;

      for (i = k; i < r; i++) // Top -> Bottom
        System.out.print(arr[i][c - 1] + " ");
      c--;

      if (k < r) {
        for (i = c - 1; i >= l; i--) // Right -> Left
          System.out.print(arr[r - 1][i] + " ");
        r--;
      }
      if (l < c) {
        for (i = r - 1; i >= k; i--) // Bottom -> Top
          System.out.print(arr[i][l] + " ");
        l++;
      }
    }
  }

  public static void main(String[] args) {
    int[][] arr = new int[3][3];
    int k = 1;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        arr[i][j] = k;
        k++;
      }
    }

    printSpiral(arr);
  }
}
