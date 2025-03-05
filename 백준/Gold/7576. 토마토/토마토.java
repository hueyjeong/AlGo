import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] tomatoes = new int[n][];
        for (int i = 0; i < n; i++) {
            tomatoes[i] = new int[m];
        }
        Queue<Tuple> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = sc.nextInt();
                if (tomatoes[i][j] == 1) {
                    queue.add(new Tuple(j, i, 0));
                }
            }
        }

        int maxHop = 0;
        while (!queue.isEmpty()) {
            Tuple tomato = queue.remove();
            if (tomatoes[tomato.y][tomato.x] <= -1)
                continue;

            tomatoes[tomato.y][tomato.x] = -2;

            if (tomato.hop > maxHop)
                maxHop = tomato.hop;

            if (tomato.x - 1 > -1) {
                queue.add(new Tuple(tomato.x - 1, tomato.y, tomato.hop + 1));
            }
            if (tomato.y - 1 > -1) {
                queue.add(new Tuple(tomato.x, tomato.y - 1, tomato.hop + 1));
            }
            if (tomato.x + 1 < m) {
                queue.add(new Tuple(tomato.x + 1, tomato.y, tomato.hop + 1));
            }
            if (tomato.y + 1 < n) {
                queue.add(new Tuple(tomato.x, tomato.y + 1, tomato.hop + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {;
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(maxHop);
    }
    static class Tuple {
        int x, y, hop;

        public Tuple(int x, int y, int hop) {
            this.x = x;
            this.y = y;
            this.hop = hop;
        }
    }
}