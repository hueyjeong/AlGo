import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int minPack = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());
            if (pack < minPack) {
                minPack = pack;
            }
            if (each < minEach) {
                minEach = each;
            }
        }

        int a;
        int b;
        if (minEach * 6 > minPack) {
            int x = (int)Math.ceil(n / 6.0);
            a = x * minPack;
            b = (n / 6) * minPack;
            n = n % 6;
            if (n > 0) {
                b += n * minEach;
            }
        } else {
            a = b = n * minEach;
        }
        int min = Math.min(a, b);
        System.out.println(min);
    }
}