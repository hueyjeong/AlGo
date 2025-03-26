import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        BigInteger f = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        String s = f.toString();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                bw.write(cnt + "\n");
                break;
            }
            cnt++;
        }

        bw.flush();
    }
}
