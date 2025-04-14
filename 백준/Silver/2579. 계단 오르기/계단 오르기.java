import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr;
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        long[] dp = new long[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            long m2 = 0;
            if (i - 2 >= 0) {
                m2 = dp[i - 2];
            }
            long m3 = 0;
            if (i - 3 >= 0) {
                m3 = dp[i - 3];
            }
            dp[i] = Math.max(
                    m2 + arr[i],
                    m3 + arr[i - 1] + arr[i]
            );
        }
        System.out.println(dp[n - 1]);
    }
}