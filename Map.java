import java.io.*;
import java.util.*;

public class Map {
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
        new Map().run();
    }

    public class hashContainer {
        String x;
        String y;

        public hashContainer(String x, String y) {
            this.x = x;
            this.y = y;
        }
    }

    public class myMap {

        int arraySize = 100000;

        ArrayList<ArrayList<hashContainer>> mapArray = new ArrayList<ArrayList<hashContainer>>();

        myMap() {
            for (int i = 0; i < arraySize; i++) {
                mapArray.add(new ArrayList<hashContainer>());
            }
        }

        int hashFunc(String x) {
            int hashCode = 0;
            for (int i = 0; i < x.length(); i++) {
                hashCode += ((x.toCharArray()[i] - 'A' + 1) * Math.pow(31, i)) % arraySize;
            }
            hashCode = hashCode % arraySize;

            return hashCode;
        }

        int exists(String x) {
            int hashCode = hashFunc(x);
            for (int i = 0; i < mapArray.get(hashCode).size(); i++) {
                if (mapArray.get(hashCode).get(i).x.equals(x)) {
                    return i;
                }
            }
            return -1;
        }

        void put(String x, String y) {
            int hashCode = hashFunc(x);
            int ifExists = exists(x);
            if (ifExists == -1) {
                hashContainer addIn = new hashContainer(x, y);
                mapArray.get(hashCode).add(addIn);
            }
            else {
                mapArray.get(hashCode).get(ifExists).y = y;
            }
        }

        String get(String x) {
            int hashCode = hashFunc(x);
            int ifExists = exists(x);
            if (ifExists != -1) {
                return mapArray.get(hashCode).get(ifExists).y;
            }
            else return "none";
        }

        void delete(String x) {
            int hashCode = hashFunc(x);
            int ifExists = exists(x);
            if (ifExists != -1) {
                mapArray.get(hashCode).remove(ifExists);
            }
        }
    }

    public void solve() throws IOException {
        String operation = br.readLine();
        String[] op = new String[3];
        myMap tab = new myMap();
        while (operation != null) {
            op = operation.split(" ");
            if (op[0].equals("get")) {
                out.println(tab.get(op[1]));
            }
            if (op[0].equals("put")) {
                tab.put(op[1], op[2]);
            }
            if (op[0].equals("delete")) {
                tab.delete(op[1]);
            }
            operation = br.readLine();
        }
    }

    public void run() {
        try {
            //Files
            br = new BufferedReader(new FileReader("map.in"));
            out = new PrintWriter("map.out");

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}