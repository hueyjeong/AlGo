import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x = 1;
        int inc = 6;
        while (n > 1) {
            x ++;
            n -= inc;
            inc += 6;
        }
        System.out.println(x);
    }
}
