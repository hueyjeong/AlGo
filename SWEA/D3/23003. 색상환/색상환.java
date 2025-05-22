import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int[] map = new int[255];
		map['r'] = 0;
		map['o'] = 1;
		map['y'] = 2;
		map['g'] = 3;
		map['b'] = 4;
		map['p'] = 5;
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			int ia = map[a];
			int ib = map[b];
			
			if (ia == ib) {
				sb.append('E');
			} else if ((ia + 3 + 6) % 6 == ib) {
				sb.append('C');
			} else if ((ia + 1 + 6) % 6 == ib || (ia - 1 + 6) % 6 == ib) {
				sb.append('A');
			} else {
				sb.append('X');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
