import java.io.*;
import java.util.*;

public class Main {
    private static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        memo = new int[n + 1];
        int ans = foo(n);
        System.out.println(ans);
    }
    static int foo(int n) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = ((foo(n - 2) % 10007) + (foo(n - 1) % 10007)) % 10007;
        return memo[n];
    }
}