import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr;
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Map<Integer, Long> dp = new HashMap<>();
        dp.put(0, arr[0]);

        for (int i = 1; i < n; i++) {
            var m2 = dp.getOrDefault(i - 2, 0L);
            var m3 = dp.getOrDefault(i - 3, 0L);
            dp.put(i, Math.max(
                    m2 + arr[i],
                    m3 + arr[i - 1] + arr[i]
            ));
        }
        System.out.println(dp.get(n - 1));
    }
}