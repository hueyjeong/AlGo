import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tok.nextToken());
        int b = Integer.parseInt(tok.nextToken());
        System.out.println(a * b - (a * b) % 2);
    }
}