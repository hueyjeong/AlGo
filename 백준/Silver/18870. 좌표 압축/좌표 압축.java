import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine());

        int[][] arr = new int[n][2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(tok.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]));
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i][1])) {
                map.put(arr[i][1], k++);
            }
            arr[i][1] = map.get(arr[i][1]);
        }
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i][1] + " ");
        }
        bw.flush();
    }

}