import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = -1;
        int i = arr.length - 1;
        int j = arr.length - 2;
        int k = arr.length - 3;
        while (true) {
            if (canMakeTriangle(arr[i], arr[j], arr[k])) {
                max = Math.max(max, arr[i] + arr[j] + arr[k]);
                break;
            } else {
                if (k + 1 == j && j + 1 == i) {
                    k--;
                } else if (j + 1 == i) {
                    j--;
                } else {
                    i--;
                }
            }
            if (k < 0 || j < 0 || i < 0) {
                break;
            }
        }
        System.out.println(max);
    }
    static boolean canMakeTriangle(int a, int b, int c) {
        if (b + c > a) {
            return true;
        }
        return false;
    }
}