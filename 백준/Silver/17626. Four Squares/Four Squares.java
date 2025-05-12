import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int sqrt = (int) Math.sqrt(n) + 1;

        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i <= sqrt; i++) {
            int square = i * i;
            if (square > n) break;
            arr[square] = 1;
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 1; i <= sqrt; i++) {
                int square = i * i;
                for (int k = 0; k <= n; k++) {
                    if (arr[k] != Integer.MAX_VALUE) {
                        int sum = k + square;
                        if (sum <= n) {
                            arr[sum] = Math.min(arr[sum], arr[k] + 1);
                        }
                    }
                }
            }
        }


        System.out.println(arr[n]);
    }
}