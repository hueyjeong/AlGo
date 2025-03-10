import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine());

        int[][] arr = new int[n][2];
        int[][] firstOrder = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(tok.nextToken());
            firstOrder[i] = arr[i];
        }
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]));
        int k = -1;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] != prev) {
                prev = arr[i][1];
                k++;
            }
            arr[i][1] = k;
        }
        for (int i = 0; i < n; i++) {
            bw.write(firstOrder[i][1] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}