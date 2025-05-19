import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int mod = a / b;
			int mod2 = mod;
			sb.append("Data Set ").append(i).append(":\n");
			int x;
			int j = 0;
			for (x = 5; x < mod; x *= 5) {
				j++;
			}
			while (j-- > 0) {
				sb.append("mega ");
			}
			if (mod2 < 5) {
				sb.append("no drought\n\n");
			} else {
				sb.append("drought\n\n");
			}
		}
		System.out.println(sb);
	}
}
