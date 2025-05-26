import java.util.*;
import java.io.*;
public class Main {
    private static char[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        int max = bar(0, 0, new Visit(new int[r]), 0, 1, r, c);
        System.out.println(max);
    }

    static int bar(int x, int y, Visit visit, int alpha, int n, int r, int c) {
        if (visit.isVisited(x, y)) {
            return n;
        }
        if (containsAlpha(alpha, matrix[y][x])) {
            return n;
        }
        alpha = putAlpha(alpha, matrix[y][x]);
        visit.setVisit(x, y);

        int max = n;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == j || -i == j) {
                    continue;
                }
                int newX = x + i;
                int newY = y + j;
                if (newX < 0 || newY < 0 || newY >= r || newX >= c) {
                    continue;
                }
                if (visit.isVisited(newX, newY)) {
                    continue;
                }
                if (containsAlpha(alpha, matrix[newY][newX])) {
                    continue;
                }
                max = Math.max(max, bar(newX, newY, visit, alpha, n + 1, r, c));
            }
        }
        visit.unsetVisit(x, y);
        alpha = deleteAlpha(alpha, matrix[y][x]);

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

    public static boolean containsAlpha(int alpha, char c) {
        int a = c - 'A';
        return (alpha & 1 << a) > 0;
    }
    public static int putAlpha(int alpha, char c) {
        int a = c - 'A';
        alpha |= 1 << a;
        return alpha;
    }
    public static int deleteAlpha(int alpha, char c) {
        int a = c - 'A';
        alpha &= ~(1 << a);
        return alpha;
    }
}