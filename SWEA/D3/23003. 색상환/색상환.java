import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		SortedMap<String, Integer> map = new TreeMap<>();
		map.put("red", 0);
		map.put("orange", 1);
		map.put("yellow", 2);
		map.put("green", 3);
		map.put("blue", 4);
		map.put("purple", 5);
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			int ia = map.get(a);
			int ib = map.get(b);
			
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
