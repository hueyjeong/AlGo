import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final boolean[] arr = new boolean[20000002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        BigInteger a;
        BigInteger b;
        Queue<BigInteger> queue = new PriorityQueue<>();
        queue.offer(BigInteger.valueOf(1));
        int zeros = 0;
        for (int i = 1; i <= n; i++) {
            queue.offer(BigInteger.valueOf(i));
        }
        while (queue.size() > 1) {
            a = queue.poll();
            b = queue.poll();
            BigInteger c = a.multiply(b);
            int mod10 = c.mod(BigInteger.TEN).intValue();
            if (mod10 == 0) {
                zeros++;
                c = c.divide(BigInteger.TEN);
            }
            queue.offer(c);
        }

        bw.write(queue.poll() + "0".repeat(zeros) + "\n");
        bw.flush();
    }
}
