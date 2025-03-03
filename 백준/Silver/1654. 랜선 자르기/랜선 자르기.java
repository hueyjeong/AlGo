import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();

        long[] cables = new long[n];
        long maxLength = 0;
        for (int i = 0; i < n; i++) {
            cables[i] = sc.nextInt();
            if(cables[i] > maxLength) {
                maxLength = cables[i];
            }
        }

        long start = 0;
        long end = maxLength;
        long length = 1;

        if (canMakeKLengthCables(cables, k, end)) {
            System.out.println(end);
            return;
        }

        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid == 0) {
                break;
            }
            if (canMakeKLengthCables(cables, k, mid)) {
                length = Math.max(mid, length);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(length);
    }

    static boolean canMakeKLengthCables(long[] cables, long k, long x) {
        long sum = 0;
        for (long cable : cables) {
            sum += cable / x;
        }
        return sum >= k;
    }
}
