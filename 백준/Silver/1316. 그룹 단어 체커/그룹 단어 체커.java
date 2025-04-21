import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            boolean flag = true;
            set.add(strs[i].charAt(0));
            for (int j = 1; j < strs[i].length(); j++) {
                if (strs[i].charAt(j - 1) != strs[i].charAt(j) && set.contains(strs[i].charAt(j))) {
                    flag = false;
                    break;
                }
                set.add(strs[i].charAt(j));
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}