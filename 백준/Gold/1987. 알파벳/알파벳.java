import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] matrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        int max = bar(new Foo(new Point(0, 0), new Visit(new int[r]), 0, 1), matrix, r, c);
        System.out.println(max);
    }

    static int bar(Foo foo, char[][] matrix, int r, int c) {
        Point p = foo.position;
        Visit visit = foo.visit;

        if (visit.isVisited(p.x, p.y)) {
            return foo.n;
        }
        if (foo.containsAlpha(matrix[p.y][p.x])) {
            return foo.n;
        }
        foo.putAlpha(matrix[p.y][p.x]);
        foo.visit.setVisit(p.x, p.y);

        int max = foo.n;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == j || -i == j) {
                    continue;
                }
                Point newPoint = new Point(p.x + i, p.y + j);
                if (newPoint.x < 0 || newPoint.y < 0 || newPoint.y >= r || newPoint.x >= c) {
                    continue;
                }
                if (visit.isVisited(newPoint.x, newPoint.y)) {
                    continue;
                }
                if (foo.containsAlpha(matrix[newPoint.y][newPoint.x])) {
                    continue;
                }
                max = Math.max(max, bar(new Foo(newPoint, visit, foo.alpha, foo.n + 1), matrix, r, c));
            }
        }
        foo.visit.unsetVisit(p.x, p.y);
        foo.deleteAlpha(matrix[p.y][p.x]);

        return max;
    }

    static class Visit {
        int[] visited;
        public Visit(int[] visited) {
            this.visited = Arrays.copyOf(visited, visited.length);
        }

        public boolean isVisited(int x, int y) {
            int row = visited[y];
            return (row & (1 << x)) > 0;
        }

        public void setVisit(int x, int y) {
            visited[y] |= (1 << x);
        }
        public void unsetVisit(int x, int y) {
            visited[y] &= ~(1 << x);
        }
    }

    static class Foo {
        Point position;
        Visit visit;
        int n;
        int alpha;
        public Foo(Point position, Visit visit, int alpha, int n) {
            this.position = position;
            this.visit = visit;
            this.n = n;
            this.alpha = alpha;
        }

        public boolean containsAlpha(char c) {
            int a = c - 'A';
            return (alpha & 1 << a) > 0;
        }
        public void putAlpha(char c) {
            int a = c - 'A';
            alpha |= 1 << a;
        }
        public void deleteAlpha(char c) {
            int a = c - 'A';
            alpha &= ~(1 << a);
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}