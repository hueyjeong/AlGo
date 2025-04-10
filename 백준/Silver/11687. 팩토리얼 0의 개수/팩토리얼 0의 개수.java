import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int left = 0;
        int right = 400000015;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = getCnt(mid);
            if (cnt < n) {
                left = mid + 1;
            } else if (cnt == n) {
                if (getCnt(mid - 1) == n) {
                    left = mid - 1;
                    right = mid - 1;
                } else {
                    ans = mid;
                    break;
                }
            } else {
                right = mid - 1;
            }
        }


        System.out.println(ans);
    }

    private static int getCnt(int ans) {
        int cnt;
        cnt = 0;
        while (ans > 0) {
            cnt += ans / 5;
            ans /= 5;
        }
        return cnt;
    }

}