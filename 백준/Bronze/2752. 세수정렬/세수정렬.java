import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        SortedSet<Integer> set = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            set.add(n);
        }
        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }
}