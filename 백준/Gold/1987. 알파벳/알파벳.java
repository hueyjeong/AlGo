import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] matrix;
    private static int alpha;
    private static int r;
    private static int c;
    private static int[] visited;
    private static int[][] iii = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];
        visited = new int[r];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }
        alpha = 0;
        int max = bar(0, 0, 1);
        System.out.println(max);
    }

    static int bar(int x, int y, int n) {
        int a = matrix[y][x] - 'A';
        alpha |= 1 << a;
        visited[y] |= (1 << x);

        if (alpha == 0x3FFFFFF) {
            return n;
        }

        int max = n;
        for (int[] ii : iii) {
            int newX = x + ii[0];
            int newY = y + ii[1];
            if (newX < 0 || newY < 0 || newY >= r || newX >= c) {
                continue;
            }
            if ((visited[newY] & (1 << newX)) > 0) {
                continue;
            }
            a = matrix[newY][newX] - 'A';
            if ((alpha & 1 << a) > 0) {
                continue;
            }
            max = Math.max(max, bar(newX, newY, n + 1));
        }

        a = matrix[y][x] - 'A';
        alpha &= ~(1 << a);
        visited[y] &= ~(1 << x);

        return max;
    }
}