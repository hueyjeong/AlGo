import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        Stack<int[]> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>(n * n);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    stack.push(new int[]{j, i});

                    int sum = 0;
                    while (!stack.isEmpty()) {
                        int[] p = stack.pop();
                        if (p[0] < 0 || p[1] < 0 || p[0] >= n || p[1] >= n || map[p[1]][p[0]] == 0)
                            continue;

                        map[p[1]][p[0]] = 0;
                        sum++;

                        stack.push(new int[]{p[0] - 1, p[1]});
                        stack.push(new int[]{p[0] + 1, p[1]});
                        stack.push(new int[]{p[0], p[1] + 1});
                        stack.push(new int[]{p[0], p[1] - 1});
                    }
                    arr.add(sum);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append('\n');
        arr.sort(Comparator.naturalOrder());
        for(Integer x : arr) {
            sb.append(x).append('\n');
        }
        System.out.println(sb);

    }
}
