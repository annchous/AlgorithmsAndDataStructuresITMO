import java.io.*;
import java.util.*;

public class Stack {
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
        new Stack().run();
    }

    private int[] array;
    private int top;

    public Stack() {
        array = new int[1000000];
        int top = 0;
    }

    public void push(int value) {
        array[top++] = value;
    }

    public int pop() {
        return array[--top];
    }

    public void solve() throws IOException {
        int amountOfCommands = nextInt();
        int value;
        char command;
        Stack array = new Stack();
        for (int i = 0; i < amountOfCommands; i++) {
            command = nextToken().charAt(0);
            if (command == '+') {
                value = nextInt();
                array.push(value);
            }
            else {
                out.print(array.pop() + "\n");
            }
        }
    }

    public void run() {
        try {
            //Files
            br = new BufferedReader(new FileReader("stack.in"));
            out = new PrintWriter("stack.out");

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}