import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine().substring(1);
            s = s.substring(0, s.length() - 1);
            StringTokenizer tok = new StringTokenizer(s, ",");

            boolean isError = false;
            AC ac = new AC(n);
            for (int i = 0; i < n; i++) {
                ac.offer(Integer.parseInt(tok.nextToken()));
            }
            for (int i = 0; i < commands.length(); i++) {
                char c = commands.charAt(i);
                if (c == 'R') {
                    ac.reverse();
                } else {
                    Integer x = ac.remove();
                    if (x == null) {
                        isError = true;
                        break;
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                Integer x;
                while ((x = ac.remove()) != null) {
                    sb.append(x).append(',');
                }
                if (sb.length() > 1) {
                    sb.setLength(sb.length() - 1);
                }
                sb.append(']');
                System.out.println(sb);
            }

        }
    }
    static class AC {
        private final Deque<Integer> deque;
        private boolean rOrder = true;
        public AC(int n) {
            deque = new ArrayDeque<>(n);
        }
        public Integer remove() {
            if (rOrder) {
                return deque.pollFirst();
            } else {
                return deque.pollLast();
            }
        }
        public void reverse() {
            rOrder = !rOrder;
        }
        public void offer(Integer x) {
            deque.offer(x);
        }
    }
}
