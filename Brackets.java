import java.io.*;
import java.util.*;

public class Brackets {
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
        new Brackets().run();
    }

    private char[] array;
    private int top;

    public Brackets() {
        array = new char[1000000];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(char element) {
        array[top++] = element;
    }

    public char Top() {
        return array[top - 1];
    }

    public char pop() {
        return array[--top];
    }

    private static boolean bracketsChecker(char[] string) {
        Brackets stack = new Brackets();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(' || string[i] == '[') {
                stack.push(string[i]);
            }
            else if (!stack.isEmpty()) {
                if (string[i] == ')' && stack.Top() == '(') {
                    stack.pop();
                }
                else if (string[i] == ']' && stack.Top() == '[') {
                    stack.pop();
                }
                else return false;
            }
            else return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        else return false;
    }

    public void solve() throws IOException {
        String str = br.readLine();
        char[] string = str.toCharArray();

        while (str != null && str.length() > 0) {
            if (bracketsChecker(string)) {
                out.print("YES\n");
            }
            else {
                out.print("NO\n");
            }
            str = br.readLine();
            if (str == null) {
                break;
            }
            string = str.toCharArray();
        }
    }

    public void run() {
        try {
            //Files
            br = new BufferedReader(new FileReader("brackets.in"));
            out = new PrintWriter("brackets.out");

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}