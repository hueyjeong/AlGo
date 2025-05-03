import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] v = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    v[i][j] = v[i - 1][j] + arr[i - 1][j];
                } else {
                    v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - 1]) + arr[i - 1][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, v[n][i]);
        }
        System.out.println(max);
    }

}