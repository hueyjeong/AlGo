import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingLong((long[] a)-> a[1]).thenComparingLong(a->a[0]));
        long[] cur = arr[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] < cur[1]) {
                continue;
            }
            cur = arr[i];
            cnt++;
        }
        System.out.println(cnt);
    }

}