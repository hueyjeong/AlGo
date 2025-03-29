import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] map2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                if (ch == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = ch - '0';
                    map2[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    for (int k = i-1; k <= i+1; k++) {
                        for (int l = j-1; l <= j+1; l++) {
                            if (k < 0 || k >= n || l < 0 || l >= n) {
                                continue;
                            }
                            map2[k][l] += map[i][j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < 0) {
                    map2[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map2[i][j] < 0) {
                    sb.append("*");
                } else if (map2[i][j] > 9) {
                    sb.append('M');
                } else {
                    sb.append(map2[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}