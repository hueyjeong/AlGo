import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        Set<String> nugu1 = new HashSet<>();
        Set<String> nugu2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nugu1.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            nugu2.add(br.readLine());
        }

        Object[] nuguOfNugus = nugu1.stream().filter(nugu2::contains).toArray();
        Arrays.sort(nuguOfNugus);
        bw.write(nuguOfNugus.length + "\n");
        for (int i = 0; i < nuguOfNugus.length; i++) {
            bw.write(nuguOfNugus[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}