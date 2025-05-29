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

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            map.putIfAbsent(u, new HashMap<>());
            map.get(u).put(v, Math.min(w, map.get(u).getOrDefault(v, INF)));
        }

        long[] weights = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(weights, INF);
        weights[a] = 0;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        pq.add(new int[]{a, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0];
            int w = cur[1];
            if (visited[v]) {
                continue;
            }
            visited[v] = true;

            Map<Integer, Integer> vv = map.getOrDefault(v, new HashMap<>());
            for (int key : vv.keySet()) {
                int ww = vv.get(key) + w;
                if (weights[key] > ww) {
                    weights[key] = ww;
                    pq.offer(new int[]{key, ww});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(weights[i] == INF ? "INF" : weights[i]);
        }
    }
}