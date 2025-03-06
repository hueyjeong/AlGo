import java.io.*;
import java.util.*;

public class Main {
    private static int[] trees;
    private static long m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tok.nextToken());
        m = Long.parseLong(tok.nextToken());

        tok = new StringTokenizer(br.readLine());

        trees = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(tok.nextToken());
            if (trees[i] > max)
                max = trees[i];
        }

        int left = 0;
        int right = max;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (enough(mid)) {
                left = mid + 1;
                if (mid> result) {
                    result = mid;
                }
            } else {
                right =  mid - 1;
            }
        }

        System.out.println(result);

    }

    static boolean enough(int h) {
        long sum = 0;
        for (int tree : trees) {
            long part = tree - h;
            if (part > 0)
                sum += part;
        }
        return sum >= m;
    }
}