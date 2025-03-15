import java.io.*;
import java.util.*;

public class Main {
    private static final boolean[] arr = new boolean[20000002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());

        StringTokenizer tok = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int v = parseInt(tok.nextToken());
            arr[v + 10000001] = true;
        }

        StringBuilder sb = new StringBuilder();
        int m = parseInt(br.readLine());
        tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int v = parseInt(tok.nextToken());
            sb.append(arr[v + 10000001] ? '1' : '0').append(' ');
        }

        System.out.println(sb);

    }

    public static int parseInt(String s) {
        boolean negative = false;
        int i = 0, len = s.length();
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        }
        int result = 0;
        while (i < len) {
            int digit = s.charAt(i++) - '0';
            result *= 10;
            result -= digit;
        }
        return negative ? result : -result;
    }
}
