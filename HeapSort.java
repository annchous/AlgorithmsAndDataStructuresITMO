import java.util.Scanner;
import java.io.*;
import java.util.*;

public class HeapSort
{
    public void heapSort(int array[]) {
        int n = array.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            siftDown(array, n, i);

        // Deleting the elements
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            siftDown(array, i, 0);
        }
    }

    void siftDown(int array[], int n, int i) {
        int max = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && array[l] > array[max])
            max = l;

        if (r < n && array[r] > array[max])
            max = r;

        if (max != i) {
            int swap = array[i];
            array[i] = array[max];
            array[max] = swap;
            siftDown(array, n, max);
        }
    }

    public static void main(String args[]) throws Exception{
        Scanner input = new Scanner(new FileReader("sort.in"));
        PrintStream output = new PrintStream(new File("sort.out"));
        int n = input.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        HeapSort ob = new HeapSort();
        ob.heapSort(array);

        for (int i=0; i<n; ++i)
            output.print(array[i]+" ");
    }
}
