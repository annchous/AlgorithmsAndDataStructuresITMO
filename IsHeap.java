import java.util.*;
import java.io.*;

public class IsHeap {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new FileReader("isheap.in"));
        PrintStream output = new PrintStream(new File("isheap.out"));
        int n = input.nextInt();
        int array[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = input.nextInt();
        }
        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (2*i < n) {
                if (array[i] > array[2*i]) {
                    k++;
                }
            }
            if (2*i + 1 < n) {
                if (array[i] > array[2*i + 1]) {
                    k++;
                }
            }
        }

        if (k > 0) {
            output.print("NO");
        }
        else {
            output.print("YES");
        }

    }
}
