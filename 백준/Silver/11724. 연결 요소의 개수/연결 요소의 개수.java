import java.io.*;
import java.util.*;

public class Main {
    private static int[][] graph;
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        graph = new int[n][n] ;
        visited = new int[n];

        for (int i = 0; i < m; i++) {
            tok = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tok.nextToken()) - 1;
            int v = Integer.parseInt(tok.nextToken()) - 1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int x) {
        visited[x] = 1;
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && graph[x][i] == 1) {
                dfs(i);
            }
        }

    }
}