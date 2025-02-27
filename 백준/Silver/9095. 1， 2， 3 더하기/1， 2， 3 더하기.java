import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int ways = foo(Integer.parseInt(br.readLine()));
            bw.write(ways + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    static int foo(int x) {
        if (x < 0) {
            return 0;
        }
        if (x == 0) {
            return 1;
        }
        return foo(x - 1) + foo(x - 2) + foo(x - 3);
    }
}