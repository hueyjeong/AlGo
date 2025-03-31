import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = br.readLine();
        }
        for (int i = 0; i <= ss[0].length(); i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(ss[j].substring(ss[j].length() - i));
            }
            if (set.size() == n) {
                System.out.println(i);
                break;
            }
        }
    }

}