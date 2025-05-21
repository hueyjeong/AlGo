import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cW = 0;
            int sum = 0;
            int pos = 0;
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int xI = Integer.parseInt(st.nextToken());
                int wI = Integer.parseInt(st.nextToken());
                arr[i][0] = xI;
                arr[i][1] = wI;
            }
            for (int i = 0; i < n; i++) {
                int xI = arr[i][0];
                int wI = arr[i][1];
                sum += xI - pos;
                pos = xI;
                if (wI > (w - cW)) {
                    sum += pos;
                    cW = 0;
                    pos = 0;
                    i--;
                    continue;
                }
                cW += wI;
                if (cW >= w) {
                    sum += pos;
                    cW = 0;
                    pos = 0;
                }
            }
            sum += pos;
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}