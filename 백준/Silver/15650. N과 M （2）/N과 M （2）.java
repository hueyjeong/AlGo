import java.io.*;
import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int[] arr = new int[m + 1];
        arr[m] = Integer.MIN_VALUE;
        solve(0, n, m, arr);
        System.out.println(String.join("\n", list));
    }
    static void solve(int a, int b, int m, int[] arr) {
        if (m == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] >= arr[i - 1]) {
                    return;
                }
                sb.append(arr[i - 1]).append(' ');
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                list.add(sb.toString());
            }
            return;
        }
        for (int i = a + 1; i <= b; i++) {
            arr[m - 1] = i;
            solve(a + 1, b, m - 1, arr);
        }
    }
}