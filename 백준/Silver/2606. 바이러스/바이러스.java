import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodes[a].connectTo(b);
            nodes[b].connectTo(a);
        }
        Set<Integer> infected = new TreeSet<>();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int num = queue.remove();
            if (nodes[num].getIsVisited()) {
                continue;
            }
            infected.add(num);
            nodes[num].setIsVisited(true);
            queue.addAll(nodes[num].getConnected());
        }

        System.out.println(infected.size() - 1);
    }

    static class Node {
        private Set<Integer> connected;
        private boolean isVisited;
        public Node() {
            connected = new TreeSet<>();
            isVisited = false;
        }

        public void connectTo(Integer target) {
            connected.add(target);
        }

        public Set<Integer> getConnected() {
            return connected;
        }

        public void setIsVisited(boolean isVisited) {
            this.isVisited = isVisited;
        }

        public boolean getIsVisited() {
            return isVisited;
        }
    }
}
