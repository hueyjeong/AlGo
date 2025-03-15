import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer tok = new StringTokenizer(br.readLine());

        int[] arr = new int[20000002];

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(tok.nextToken());
            arr[v + 10000001] = 1;
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(tok.nextToken());
            sb.append(arr[v + 10000001]).append(' ');
        }

        System.out.println(sb);

    }
}
