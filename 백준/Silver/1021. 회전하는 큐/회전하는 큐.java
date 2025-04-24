import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[m];
        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int num = numbers[i];
            int shl = shiftLeft(deque, num, true);
            int shr = shiftRight(deque, num, true);
            if (shl < shr) {
                sum += shl;
                shiftLeft(deque, num, false);
                deque.pollFirst();
            } else {
                sum += shr;
                shiftRight(deque, num, false);
                deque.pollFirst();
            }

        }
        System.out.println(sum);
    }
    public static int shiftLeft(Deque<Integer> deque, int num, boolean isWwe) {
        int count = 0;
        while (deque.peekFirst() != num) {
            deque.addLast(deque.pollFirst());
            count++;
        }
        if (isWwe) {
            for (int i = 0; i < count; i++) {
                deque.addFirst(deque.pollLast());
            }
        }

        return count;
    }

    public static int shiftRight(Deque<Integer> deque, int num, boolean isWwe) {
        int count = 0;
        while (deque.peekFirst() != num) {
            deque.addFirst(deque.pollLast());
            count++;
        }
        if (isWwe) {
            for (int i = 0; i < count; i++) {
                deque.addLast(deque.pollFirst());
            }
        }
        return count;
    }

}