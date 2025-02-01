import java.util.*;

class FibonacciSearch {
  public static int fibonacciSearch(int[] arr, int x) {
    int n = arr.length;
    if (n == 0) {
      return -1;
    }

    int fib1 = 0, fib2 = 1, fib3 = fib1 + fib2;


    while (fib3 < n) {
      fib1 = fib2;
      fib2 = fib3;
      fib3 = fib1 + fib2;
    }

    int offset = -1;
    while (fib3 > 1) {
      int i = Math.min(offset + fib2, n-1);

      if (arr[i] < x) {
        fib3 = fib2;
        fib2 = fib1;
        fib1 = fib3 - fib2;
        offset = i;
      }
      else if (arr[i] > x) {
        fib3 = fib1;
        fib2 = fib2 - fib1;
        fib1 = fib3 - fib2;
      }
      else {
        return i;
      }
    }

    if (fib2 == 1 && arr[offset+1] == x) {
      return offset + 1;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100, 235};
    int n = arr.length;
    int x = 235;
    int ind = fibonacciSearch(arr, x);
    if (ind >= 0) {
      System.out.println("Found at index: " + ind);
    } else {
      System.out.println(x + " isn't present in the array");
    }
  }
}