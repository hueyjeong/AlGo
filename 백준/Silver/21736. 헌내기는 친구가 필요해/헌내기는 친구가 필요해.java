import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        int[][] map = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    q.add(new int[]{i, j});
                }
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (map[y][x] == 'X') {
                continue;
            }
            if (map[y][x] == 'P') {
                cnt++;
            }
            map[y][x] = 'X';
            q.add(new int[]{y, x - 1});
            q.add(new int[]{y - 1, x});
            q.add(new int[]{y, x + 1});
            q.add(new int[]{y + 1, x});
        }
        System.out.println((cnt == 0) ? "TT" : cnt);
    }
}