import java.io.*;
import java.util.*;

public class Main {
    private static boolean[][] graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        graph = new boolean[n][n] ;
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            tok = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tok.nextToken()) - 1;
            int v = Integer.parseInt(tok.nextToken()) - 1;
            graph[u][v] = true;
            graph[v][u] = true;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int x) {
        if (visited[x])
            return;
        visited[x] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[x][i] && !visited[i]) {
                dfs(i);
            }
        }

    }
}