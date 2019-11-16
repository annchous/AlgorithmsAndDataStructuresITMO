import java.util.*;
import java.io.*;

public class BinarySearch {

    private int binSearchFirst (int[] array, int[] request, int i) {
        int left = 0;
        int right = array.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (array[mid] < request[i]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (right < array.length && array[right] == request[i])
            return right;
        else
            return -1;
    }

    private int binSearchLast (int[] array, int[] request, int i) {
        int left = 0;
        int right = array.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (array[mid] <= request[i]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (left > 0 && array[left] == request[i])
            return left;
        else
            return -1;
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(new FileReader("binsearch.in"));
        PrintStream output = new PrintStream(new File("binsearch.out"));
        int n = input.nextInt();
        int array[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = input.nextInt();
        }
        int m = input.nextInt();
        int request[] = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            request[i] = input.nextInt();
        }

        BinarySearch ob = new BinarySearch();
        for (int i = 1; i <= m; i++) {
            int pos1 = ob.binSearchFirst(array, request, i);
            int pos2 = ob.binSearchLast(array, request, i);
            output.print(pos1 + " " + pos2 + "\n");
        }
    }
}
