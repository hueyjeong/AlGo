import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(tok.nextToken());
        }
        int goal = Integer.parseInt(tok.nextToken()) * 4;
        System.out.println(Math.max(goal - sum, 0));
    }
}