import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Map<Integer, Integer>> arr = new HashMap<>();
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.putIfAbsent(a, new HashMap<>());
            arr.putIfAbsent(b, new HashMap<>());
            arr.get(a).put(b, 1);
            arr.get(b).put(a, 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int[] parents = new int[n + 1];
        HashMap<Integer, Integer> empty = new HashMap<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for(Integer i : arr.getOrDefault(x, empty).keySet()) {
                if (!visited[i]) {
                    parents[i] = x;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
}