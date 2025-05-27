import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            sum += x;
            arr[i] = sum;
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean found = false;
            for (int j = 0; j < n - i; j++) {
                long temp = getSum(j, j + i);
                if (temp >= s) {
                    ans = i + 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        System.out.println(ans);
    }

    private static long getSum(int from, int to) {
        if (from == 0) {
            return arr[to];
        } else {
            return arr[to] - arr[from - 1];
        }
    }
}