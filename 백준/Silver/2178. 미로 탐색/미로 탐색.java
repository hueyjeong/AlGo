import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        int[][] map = new int[n][m];

        Queue<Point> queue = new ArrayDeque<>(n * n * n);
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        queue.offer(new Point (0, 0, 1));

        int len = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x < 0 || p.y < 0 || p.x >= m || p.y >= n || map[p.y][p.x] == 0)
                continue;

            map[p.y][p.x] = 0;
            if (p.count > len && p.x == m - 1 && p.y == n - 1)
            {
                len = p.count;
                break;
            }

            queue.offer(new Point (p.x - 1, p.y, p.count + 1));
            queue.offer(new Point (p.x + 1, p.y, p.count + 1));
            queue.offer(new Point (p.x, p.y + 1, p.count + 1));
            queue.offer(new Point (p.x, p.y - 1, p.count + 1));
        }

        System.out.println(len);

    }
    static class Point {
        public int x;
        public int y;
        public int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
