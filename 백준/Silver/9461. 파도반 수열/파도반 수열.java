import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] inputs = new int[t];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < t; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[i]);
        }
        max = Math.max(max, 4);
        long[] p = new long[max];
        p[0] = 1;
        p[1] = 1;
        p[2] = 1;
        for (int i = 3; i < max; i++) {
            p[i] = p[i - 2] + p[i - 3];
        }
        for (int j = 0; j < t; j++) {
            int n = inputs[j];
            System.out.println(p[n - 1]);
        }
    }
}