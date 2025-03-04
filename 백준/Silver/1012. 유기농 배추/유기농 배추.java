import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[m];
            }

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            }

            Stack<Point> stack = new Stack<>();

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 1)
                        continue;

                    stack.push(new Point(j, i));
                    while (!stack.isEmpty()) {
                        Point p = stack.pop();
                        int x = p.x;
                        int y = p.y;
                        if (arr[y][x] != 1)
                            continue;

                        arr[y][x] = 2;
                        // 좌우
                        if (x - 1 >= 0)
                            stack.push(new Point(x - 1, y));
                        if (x + 1 < m)
                            stack.push(new Point(x + 1, y));
                        // 상하
                        if (y - 1 >= 0)
                            stack.push(new Point(x, y - 1));
                        if (y + 1 < n)
                            stack.push(new Point(x, y + 1));
                    }
                    count++;
                }
            }

            System.out.println(count);
        }
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
