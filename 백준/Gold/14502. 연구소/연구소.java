import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] lab = new int[n][m];
        List<Pair> virusAround = new ArrayList<>();
        int emptyCount = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virusAround.add(new Pair(i + 1, j));
                    virusAround.add(new Pair(i - 1, j));
                    virusAround.add(new Pair(i, j + 1));
                    virusAround.add(new Pair(i, j - 1));
                } else if (lab[i][j] == 0) {
                    emptyCount++;
                }
            }
        }

        int minVirusCount = Integer.MAX_VALUE;
        for (int x1 = 0; x1 < n; x1++) {
            for(int y1 = 0; y1 < m; y1++) {
                for (int x2 = 0; x2 < n; x2++) {
                    for (int y2 = 0; y2 < m; y2++) {
                        for (int x3 = 0; x3 < n; x3++) {
                            for (int y3 = 0; y3 < m; y3++) {
                                if (x1 == x2 && y1 == y2 || x1 == x3 && y1 == y3 || x2 == x3 && y2 == y3) {
                                    continue;
                                }
                                if (lab[x1][y1] == 0 && lab[x2][y2] == 0 && lab[x3][y3] == 0) {
                                    int[][] lab2 = new int[n][m];
                                    for (int i = 0; i < n; i++) {
                                        lab2[i] = lab[i].clone();
                                    }
                                    lab2[x1][y1] = 1;
                                    lab2[x2][y2] = 1;
                                    lab2[x3][y3] = 1;

                                    Queue<Pair> q = new LinkedList<>(virusAround);
                                    int virusCount = 0;
                                    while (!q.isEmpty()) {
                                        int x = q.peek().x;
                                        int y = q.poll().y;
                                        if (x < 0 || x >= n || y < 0 || y >= m || lab2[x][y] != 0) {
                                            continue;
                                        }
                                        lab2[x][y] = 2;
                                        virusCount++;
                                        q.add(new Pair(x - 1, y));
                                        q.add(new Pair(x + 1, y));
                                        q.add(new Pair(x, y - 1));
                                        q.add(new Pair(x, y + 1));
                                    }
                                    if (virusCount < minVirusCount) {
                                        minVirusCount = virusCount;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(emptyCount - minVirusCount - 3);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}