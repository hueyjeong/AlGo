import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> visited = new TreeSet<>();
        queue.add(new int[]{n, 0});
        int answer = 0;
        while (true) {//!queue.isEmpty()
            int[] entry = queue.remove();
            if (entry[0] == k) {
                answer = entry[1];
                break;
            }
            if (entry[0] < -100 || entry[0] > 100002 || visited.contains(entry[0])) {
                continue;
            }
            visited.add(entry[0]);

            queue.add(new int[]{entry[0] * 2, entry[1] + 1});
            queue.add(new int[]{entry[0] + 1, entry[1] + 1});
            queue.add(new int[]{entry[0] - 1, entry[1] + 1});
        }

        System.out.println(answer);
    }

}
