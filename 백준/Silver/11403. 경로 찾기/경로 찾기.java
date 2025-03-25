import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] arr2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = tok.nextToken().charAt(0) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    findPath(j, arr, arr2[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr2[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void findPath(int x, int[][] arr, int[] memo) {
        if (memo[x] == 1) {
            return;
        }
        memo[x] = 1;
        for (int i = 0; i < arr[x].length; i++) {
            if (arr[x][i] == 1) {
                findPath(i, arr, memo);
            }
        }
    }
}