import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        Stack<Point> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>(n * n);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    stack.push(new Point(j, i));

                    int sum = 0;
                    while (!stack.isEmpty()) {
                        Point p = stack.pop();
                        if (p.x < 0 || p.y < 0 || p.x >= n || p.y >= n || map[p.y][p.x] == 0)
                            continue;

                        map[p.y][p.x] = 0;
                        sum++;

                        stack.push(new Point(p.x - 1, p.y));
                        stack.push(new Point(p.x + 1, p.y));
                        stack.push(new Point(p.x, p.y + 1));
                        stack.push(new Point(p.x, p.y - 1));
                    }
                    arr.add(sum);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append('\n');
        arr.sort(Comparator.naturalOrder());
        for(Integer x : arr) {
            sb.append(x).append('\n');
        }
        System.out.println(sb);

    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
