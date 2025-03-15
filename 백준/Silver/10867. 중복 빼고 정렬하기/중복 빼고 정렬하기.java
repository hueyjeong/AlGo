import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringTokenizer tok = new StringTokenizer(br.readLine());
        int[] arr = new int[2002];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(tok.nextToken());
            arr[v + 1001]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                sb.append(i - 1001).append(' ');
            }
        }

        System.out.println(sb);

    }
}
