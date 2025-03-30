import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int kk = 1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (kk == k) {
                list.add(next);
                kk = 1;
            } else {
                queue.offer(next);
                kk++;
            }
        }
        System.out.println("<" + String.join(", ", list.stream().map(String::valueOf).toArray(String[]::new)) + ">");
    }

}