import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][n];
        int[][] rgB = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                rgb[i][j] = s.charAt(j);
                if (rgb[i][j] == 'R' || rgb[i][j] == 'G') {
                    rgB[i][j] = 1;
                } else {
                    rgB[i][j] = 2;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int areaRgb = 0;
        int areaRGb = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rgb[i][j] != 0) {
                    q.add(new int[]{i, j});
                    areaRgb++;
                }
                int color = rgb[i][j];
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    
                    if (rgb[x][y] == color) {
                        rgb[x][y] = 0;

                        q.add(new int[]{x - 1, y});
                        q.add(new int[]{x + 1, y});
                        q.add(new int[]{x, y - 1});
                        q.add(new int[]{x, y + 1});	
                    }
                }
                
                if (rgB[i][j] != 0) {
                    q.add(new int[]{i, j});
                    areaRGb++;
                }
                color = rgB[i][j];
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    
                    if (rgB[x][y] == color) {
                    	rgB[x][y] = 0;

                        q.add(new int[]{x - 1, y});
                        q.add(new int[]{x + 1, y});
                        q.add(new int[]{x, y - 1});
                        q.add(new int[]{x, y + 1});	
                    }
                }
            }
        }
        System.out.println(areaRgb + " " + areaRGb);
    }
}