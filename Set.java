import java.io.*;
import java.util.*;

public class Set {
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
        new Set().run();
    }

    public class HASH {
        ArrayList<ArrayList<Integer>> hashArray = new ArrayList<ArrayList<Integer>>();

        int arraySize = 1000000;

        HASH() {
            for (int i = 0; i < arraySize; i++) {
                hashArray.add(new ArrayList<Integer>());
            }
        }

        boolean exists(int x) {
            int hashCode = hashFunc(x);
            if (hashArray.get(hashCode).indexOf(x) != -1) {
                return true;
            }
            return false;
        }

        void delete(int x) {
            if (exists(x)) {
                int hashCode = hashFunc(x);
                hashArray.get(hashCode).remove(hashArray.get(hashCode).indexOf(x));
            }
        }

        void insert(int x) {
            if (!exists(x)) {
                int hashCode = hashFunc(x);
                hashArray.get(hashCode).add(x);
            }
        }

        int hashFunc(int x) {
            int hashCode = Math.abs(x) % arraySize;
            return hashCode;
        }
    }

    public void solve() throws IOException {
        String operation = br.readLine();
        String[] op = new String[2];
        HASH tab = new HASH();
        while (operation != null) {
            op = operation.split(" ");
            if (op[0].equals("exists")) {
                out.println(tab.exists(Integer.valueOf(op[1])));
            }
            if (op[0].equals("insert")) {
                tab.insert(Integer.valueOf(op[1]));
            }
            if (op[0].equals("delete")) {
                tab.delete(Integer.valueOf(op[1]));
            }
            operation = br.readLine();
        }
    }

    public void run() {
        try {
            //Files
            br = new BufferedReader(new FileReader("set.in"));
            out = new PrintWriter("set.out");

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}