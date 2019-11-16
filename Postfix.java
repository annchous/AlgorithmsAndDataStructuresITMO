import java.io.*;
import java.util.*;

public class Postfix {
    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        new Postfix().run();
    }

    private int[] array;
    private int top;

    public Postfix() {
        array = new int[1000000];
        top = 0;
    }

    public void push(int value) {
        array[top++] = value;
    }

    public int Top() {
        return array[top - 1];
    }

    public int pop() {
        return array[--top];
    }

    public void solve() throws IOException {
        String str = br.readLine();
        String delimiter = " ";
        String[] string = str.split(delimiter);
        String element;
        int a, b;
        Postfix stack = new Postfix();
        for (int i = 0; i < string.length; i++) {
            element = string[i];
            if (element == " ") {
                continue;
            }
            else {
                switch (element) {
                    case ("+"):
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a + b);
                        break;
                    case ("-"):
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a - b);
                        break;
                    case ("*"):
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a * b);
                        break;
                    default:
                        stack.push(Integer.parseInt(element));
                        break;
                }
            }
        }
        out.print(stack.Top());
    }

    public void run() {
        try {
            //Files
            br = new BufferedReader(new FileReader("postfix.in"));
            out = new PrintWriter("postfix.out");

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}