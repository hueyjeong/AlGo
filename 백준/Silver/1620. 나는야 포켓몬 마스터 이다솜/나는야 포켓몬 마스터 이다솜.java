import java.io.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        Dictionary<String, Integer> Dogam1 = new Hashtable<>();
        Dictionary<Integer, String> Dogam2 = new Hashtable<>();
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(br.readLine());
            String mon = tok.nextToken();

            Dogam1.put(mon, i + 1);
            Dogam2.put(i + 1, mon);
        }

        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            try {
                int x = Integer.parseInt(q);
                bw.write(Dogam2.get(x) + "\n");
            } catch (NumberFormatException e) {
                bw.write(Dogam1.get(q) + "\n");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }
}