import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] edges = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            edges[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] cities = new long[n];
        for (int i = 0; i < n; i++) {
            cities[i] = Long.parseLong(st.nextToken());
        }
        long sum = 0;
        long cheapest = cities[0];
        for (int i = 0; i < n - 1; i++) {
            if (cities[i] < cheapest) {
                cheapest = cities[i];
            }
            sum += cheapest * edges[i];
        }
        System.out.println(sum);
    }
}