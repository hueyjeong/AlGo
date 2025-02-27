import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        int[] coinTypes = new int[n];
        int coinCount = 0;
        for (int i = 0; i < n; i++) {
            coinTypes[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n - 1; i >= 0; i--) {
            coinCount += m / coinTypes[i];
            m = m % coinTypes[i];
        }

        bw.write(coinCount + "\n");


        bw.flush();
        br.close();
        bw.close();
    }
}