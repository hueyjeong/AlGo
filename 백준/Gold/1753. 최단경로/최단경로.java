import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(br.readLine()) - 1;

        List<Path>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            map[u].add(new Path(v, w));
        }

        long[] weights = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(weights, INF);
        weights[a] = 0;

        Queue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(Path::getW));

        pq.add(new Path(a, 0));
        while (!pq.isEmpty()) {
            Path cur = pq.poll();
            if (visited[cur.v]) {
                continue;
            }

            visited[cur.v] = true;

            for (Path p : map[cur.v]) {
                int ww = p.w + cur.w;
                if (weights[p.v] > ww) {
                    weights[p.v] = ww;
                    pq.offer(new Path(p.v, ww));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (weights[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(weights[i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Path {
        int v;
        int w;
        public Path(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int getV() {
            return v;
        }

        public int getW() {
            return w;
        }
    }

}