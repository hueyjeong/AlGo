import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        String X = new StringBuilder(tok.nextToken()).reverse().toString();
        String Y = new StringBuilder(tok.nextToken()).reverse().toString();
        int z = Integer.parseInt(X) + Integer.parseInt(Y);
        System.out.println(Integer.parseInt(new StringBuilder(String.valueOf(z)).reverse().toString()));

    }

}