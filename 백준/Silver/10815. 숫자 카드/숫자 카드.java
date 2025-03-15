import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer tok = new StringTokenizer(br.readLine());

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(tok.nextToken());
            map.put(v, true);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(tok.nextToken());
            if (map.getOrDefault(v, false)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);

    }
}
