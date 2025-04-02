import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int[] memo = new int[n + 1];
        int ans = foo(memo, n);
        System.out.println(ans);
    }
    static int foo(int[] memo, int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 3;
        if (memo[n] != 0) return memo[n];
        memo[n] = ((foo(memo, n - 3) % 10007) * 2 + (foo(memo, n - 2) % 10007) * 3) % 10007;
        return memo[n];
    }
}