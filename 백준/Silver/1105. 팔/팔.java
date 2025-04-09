import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        long m = 10000000000L;
        int result = Math.min(solve(l, r, l, m), solve(l, r, r, m));
        System.out.println(result);
    }

    private static int solve(long l, long r, long x, long m) {
        if (x < l || x > r) {
            return Integer.MAX_VALUE;
        }

        int cnt = count(x);
        if (m == 0) {
            return cnt;
        }

        long cur = (x / m) % 10;

        if (cur == 8) {
            return Math.min(Math.min(Math.min(
                    solve(l, r, x + m, m / 10),
                    solve(l, r, x - m, m / 10)
            ), solve(l, r, x, m / 10)), cnt);
        } else {
            return Math.min(solve(l, r, x, m / 10), cnt);
        }
    }

    private static int count(long x) {
        int cnt = 0;
        while (x > 0) {
            if (x % 10 == 8) {
                cnt++;
            }
            x /= 10;
        }
        return cnt;
    }
}