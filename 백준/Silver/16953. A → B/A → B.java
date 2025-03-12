import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        long a = Long.parseLong(tok.nextToken());
        long b = Long.parseLong(tok.nextToken());
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] { a, 1 });
        long result = -1;
        while (!queue.isEmpty()) {
            long[] v = queue.poll();
            if (v[0] > b) {
                continue;
            }
            if (v[0] == b) {
                result = v[1];
                break;
            }
            queue.offer(new long[] { v[0] * 2, v[1] + 1 });
            queue.offer(new long[] { v[0] * 10 + 1, v[1] + 1 });
        }
        System.out.println(result);
    }

}
