import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int sz = Math.min(n, m);
        int result = 1;
        while (sz > 1) {
            searching:
            for (int y1 = 0; y1 < n - (sz - 1); y1++) {
                for (int x1 = 0; x1 < m - (sz - 1); x1++) {
                    int y2 = y1 + (sz - 1);
                    int x2 = x1 + (sz - 1);
                    int v = arr[y1][x1];
                    if (arr[y1][x2] == v && arr[y2][x1] == v && arr[y2][x2] == v) {
                        result = sz * sz;
                        break searching;
                    }
                }
            }

            if (result > 1) {
                break;
            }
            sz --;
        }
        System.out.println(result);
    }
}
