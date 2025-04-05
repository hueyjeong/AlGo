import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int[] arr = new int[m + 1];

        int[] set = new int[n];
        tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set[i] = Integer.parseInt(tok.nextToken());
        }
        boolean[] visited = new boolean[set.length];
        Arrays.sort(set);
        arr[m] = Integer.MIN_VALUE;
        solve(0, n, m, arr, set, visited);
        System.out.println(String.join("\n", list));
    }
    static void solve(int a, int b, int m, int[] arr, int[] set, boolean[] visited) {
        if (m == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i > 0; i--) {
                sb.append(arr[i - 1]).append(' ');
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                list.add(sb.toString());
            }
            return;
        }
        for (int i = a; i < set.length; i++) {
            if (!visited[i]) {
                arr[m - 1] = set[i];
                visited[i] = true;
                solve(a, b, m - 1, arr, set, visited);
                visited[i] = false;
            }
        }
    }
}