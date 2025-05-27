import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] sums;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        sums = new int[n];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sum += x;
            sums[i] = sum;
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean found = false;
            for (int j = 0; j < n - i; j++) {
                long temp;
                if (j == 0) {
                    temp =  sums[j + i];
                } else {
                    temp = sums[j + i] - sums[j - 1];
                }
                if (temp >= s) {
                    ans = i + 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        System.out.println(ans);
    }
}