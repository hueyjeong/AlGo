import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Map<Integer, List<Bus>> cities = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            cities.computeIfAbsent(start, k -> new ArrayList<>()).add(new Bus(start, end, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Bus> pq = new PriorityQueue<>(Comparator.comparingInt(Bus::getCost));
        pq.add(new Bus(start, start, 0)); // 시작점 추가
        boolean[] visited = new boolean[n + 1];
        int[] minCost = new int[n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[start] = 0;

        while (!pq.isEmpty()) {
            Bus current = pq.poll();
            int currentCity = current.getEnd();

            if (visited[currentCity]) continue;
            visited[currentCity] = true;

            for (Bus next : cities.getOrDefault(currentCity, new ArrayList<>())) {
                if (!visited[next.getEnd()] && minCost[currentCity] + next.getCost() < minCost[next.getEnd()]) {
                    minCost[next.getEnd()] = minCost[currentCity] + next.getCost();
                    pq.add(new Bus(currentCity, next.getEnd(), minCost[next.getEnd()]));
                }
            }
        }

        System.out.println(minCost[end]);
    }

    private static class Bus {
        int start;
        int end;
        int cost;

        public Bus(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}
