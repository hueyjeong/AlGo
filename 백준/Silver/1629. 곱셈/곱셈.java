import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long ans = solve(a, b, c);
        System.out.println(ans);
    }

    private static long solve(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % c;
        }
        long bb = b;
        if (map.containsKey(b)) {
            return map.get(b);
        }
        long ans = 1;
        while (b > 0) {
            ans =(ans * solve(a, b / 2, c)) % c;
            if (b % 2 == 1) {
                ans = ((ans * (a % c)) % c) % c;
            }
            b = b / 2;
        }
        map.put(bb, ans % c);
        return ans;
    }
}