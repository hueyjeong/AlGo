import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int[][] map = new int[n][m];
        int[][] result = new int[n][m];
        Point startPoint = new Point(0, 0, 0);
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = tok.nextToken().charAt(0) - '0';
                if (map[i][j] == 2) {
                    startPoint = new Point(j, i, 0);
                }
            }
        }

        Queue<Point> q = new ArrayDeque<>(n * m);
        q.add(startPoint);
        map[startPoint.y][startPoint.x] = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x < 0 || p.x >= m || p.y < 0 || p.y >= n) {
                continue;
            }
            if (result[p.y][p.x] != 0) {
                continue;
            }
            if (map[p.y][p.x] == 1 && result[p.y][p.x] == 0) {
                result[p.y][p.x] = p.hop;
                q.offer(new Point(p.x - 1, p.y, p.hop + 1));
                q.offer(new Point(p.x + 1, p.y, p.hop + 1));
                q.offer(new Point(p.x, p.y - 1, p.hop + 1));
                q.offer(new Point(p.x, p.y + 1, p.hop + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && result[i][j] == 0) {
                    result[i][j] = 0;
                } else if (map[i][j] == 1 && result[i][j] == 0) {
                    result[i][j] = -1;
                }
            }
        }
        result[startPoint.y][startPoint.x] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write('\n');
        }


        br.close();
        bw.close();
    }
    static class Point {
        public int x;
        public int y;
        public int hop;

        public Point(int x, int y, int hop) {
            this.x = x;
            this.y = y;
            this.hop = hop;
        }
    }
}