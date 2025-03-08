import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] arr = new int[n][n];

        Stack<Point> stack = new Stack<>();

        int k = 1;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 1) {
                    stack.push(new Point(j, i, k++));
                }
            }
        }

        Map<Integer, Integer> dazis = new HashMap<>();
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            if (p.x < 0 || p.y < 0 || p.x >= n || p.y >= n || arr[p.y][p.x] != 0 || map[p.y][p.x] == 0)
                continue;

            arr[p.y][p.x] = p.num;
            if (!dazis.containsKey(p.num))
                dazis.put(p.num, 0);
            dazis.put(p.num, dazis.get(p.num) + 1);

            stack.push(new Point(p.x + 1, p.y, p.num));
            stack.push(new Point(p.x - 1, p.y, p.num));
            stack.push(new Point(p.x, p.y + 1, p.num));
            stack.push(new Point(p.x, p.y - 1, p.num));
        }

        Stream<Integer> results = dazis.values().stream().sorted();
        System.out.println(dazis.size());
        Iterator<Integer> iter = results.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    static class Point {
        public int x;
        public int y;
        public int num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
