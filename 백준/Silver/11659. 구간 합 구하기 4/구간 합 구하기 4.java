import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tok = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());
        int[] arr = new int[N];
        tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        long[] sums = new long[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            sums[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken())-1;
            int b = Integer.parseInt(tok.nextToken())-1;
            if (a > 0)
                sum = sums[b] - sums[a - 1];
            else
                sum = sums[b];
            bw.write(sum + "\n");
        }

        bw.flush();
    }
}
