import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] str = br.readLine().substring(0, m).toCharArray();
        int[] arr = new int[m];
        
        int cnt = 0;
        for (int i = 0; i < m - 2; i++) {
            if (str[i] == 'I' && str[i+1] == 'O' && str[i+2] == 'I') {
                cnt++;
                i++;
            } else {
                cnt = 0;
            }
            arr[i] = cnt;
        }
        cnt = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] >= n) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}