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

        Dictionary<String, String> passwords = new Hashtable<>();
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(br.readLine());
            passwords.put(tok.nextToken(), tok.nextToken());
        }

        for (int i = 0; i < m; i++) {
            String addr = br.readLine();
            bw.write(passwords.get(addr) + "\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}