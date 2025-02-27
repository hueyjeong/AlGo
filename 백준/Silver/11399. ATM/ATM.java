import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine());
        List<Integer> sarams = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            sarams.add(Integer.parseInt(tok.nextToken()));
        }
        
        sarams.sort(Comparator.naturalOrder());
        int z = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            z += sarams.get(i);
            sum += z;
        }

        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}