import java.io.*;
import java.util.*;

public class Main {
    private static int[][] sheet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sheet = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sheet[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        int[] result = new int[2];
        divideSheet(0, 0, n, result);
        System.out.println(result[0]);
        System.out.println(result[1]);

        br.close();
    }
    static void divideSheet(int left, int top, int size, int[] result) {
        if (top < 0 || top > sheet.length || left < 0 || left > sheet[top].length) {
            return;
        }
        if (size == 1) {
            result[sheet[top][left]]++;
            return;
        }
        int[] whiteAndBlue = new int[2];
        for (int i = top; i < top + size; i++) {
            for (int j = left; j < left + size; j++) {
                whiteAndBlue[sheet[i][j]]++;
            }
        }
        if (whiteAndBlue[0] == 0) {
            result[1]++;
        } else if (whiteAndBlue[1] == 0) {
            result[0]++;
        } else {
            int half = size / 2;
            divideSheet(left + half, top + half, half, result);
            divideSheet(left, top + half, half, result);
            divideSheet(left + half, top, half, result);
            divideSheet(left, top, half, result);
        }
    }
}