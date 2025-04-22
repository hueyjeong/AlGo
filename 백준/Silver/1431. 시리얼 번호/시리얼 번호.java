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
        Arrays.sort(strs, Comparator.comparingInt(String::length).thenComparing((String s1,String s2) -> {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (Character.isDigit(s1.charAt(i))) {
                    sum1 += s1.charAt(i) - '0';
                }
                if (Character.isDigit(s2.charAt(i))) {
                    sum2 += s2.charAt(i) - '0';
                }
            }
            return Integer.compare(sum1, sum2);
        }).thenComparing((String s1, String s2) -> s1.compareTo(s2)));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append("\n");
        }
        System.out.print(sb.toString());
    }
}