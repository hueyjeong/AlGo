import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int goal;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        goal = sc.nextInt();
        arr = new int[goal + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{ 1, 0 });
        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            if (item[0] > goal) {
                continue;
            }
            if (item[1] < arr[item[0]]) {
                arr[item[0]] = item[1];
            } else if (arr[item[0]] != Integer.MAX_VALUE) {
                continue;
            }
            queue.offer(new int[]{ item[0] * 2, item[1] + 1 });
            queue.offer(new int[]{ item[0] * 3, item[1] + 1 });
            queue.offer(new int[]{ item[0] + 1, item[1] + 1 });
        }
        arr[0] = 1;
        arr[1] = 0;
        System.out.println(arr[goal]);
    }
}
