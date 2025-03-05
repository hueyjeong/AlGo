import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(tok.nextToken());
        int n = Integer.parseInt(tok.nextToken());
        int h = Integer.parseInt(tok.nextToken());

        int[][][] tomatoes = new int[h][][];
        for (int i = 0; i < h; i++) {
            tomatoes[i] = new int[n][];
            for (int j = 0; j < n; j++) {
                tomatoes[i][j] = new int[m];
            }
        }
        Queue<Tuple> queue = new ArrayDeque<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                tok = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    tomatoes[k][i][j] = Integer.parseInt(tok.nextToken());
                    if (tomatoes[k][i][j] == 1) {
                        queue.add(new Tuple(j, i, k, 0));
                    }
                }
            }
        }

        int maxHop = 0;
        while (!queue.isEmpty()) {
            Tuple tomato = queue.remove();
            if (tomatoes[tomato.z][tomato.y][tomato.x] <= -1)
                continue;

            tomatoes[tomato.z][tomato.y][tomato.x] = -2;

            if (tomato.hop > maxHop)
                maxHop = tomato.hop;

            if (tomato.x - 1 > -1) {
                queue.add(new Tuple(tomato.x - 1, tomato.y, tomato.z, tomato.hop + 1));
            }
            if (tomato.y - 1 > -1) {
                queue.add(new Tuple(tomato.x, tomato.y - 1, tomato.z, tomato.hop + 1));
            }
            if (tomato.z - 1 > -1) {
                queue.add(new Tuple(tomato.x, tomato.y, tomato.z - 1, tomato.hop + 1));
            }
            if (tomato.x + 1 < m) {
                queue.add(new Tuple(tomato.x + 1, tomato.y, tomato.z, tomato.hop + 1));
            }
            if (tomato.y + 1 < n) {
                queue.add(new Tuple(tomato.x, tomato.y + 1, tomato.z, tomato.hop + 1));
            }
            if (tomato.z + 1 < h) {
                queue.add(new Tuple(tomato.x, tomato.y, tomato.z + 1, tomato.hop + 1));
            }
        }

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tomatoes[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(maxHop);
    }
    static class Tuple {
        int x, y, z, hop;

        public Tuple(int x, int y, int z, int hop) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.hop = hop;
        }
    }
}