import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Queue<Pair> q = new LinkedList<Pair>();
			q.offer(new Pair(a, null, '\0'));
			Pair ans = null;
			boolean[] visited = new boolean[10000];
			visited[a] = true;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if (p.x == b) {
					ans = p;
					break;
				}
				int d = D(p.x);
				int s = S(p.x);
				int l = L(p.x);
				int r = R(p.x);
				if (!visited[d]) {
					q.offer(new Pair(d, p, 'D'));
					visited[d] = true;
				}
				if (!visited[s]) {
					q.offer(new Pair(s, p, 'S'));
					visited[s] = true;
				}
				if (!visited[l]) {
					q.offer(new Pair(l, p, 'L'));
					visited[l] = true;
				}
				if (!visited[r]) {
					q.offer(new Pair(r, p, 'R'));
					visited[r] = true;
				}
			}
			StringBuilder ss = new StringBuilder();
			while (ans.parent != null) {
				ss.append(ans.c);
				ans = ans.parent;
			}
			sb.append(ss.reverse()).append('\n');
			q.clear();
		}
		System.out.println(sb);
	}
	
	static class Pair {
		int x;
		char c;
		Pair parent;
		
		public Pair(int x, Pair parent, char c) {
			this.x = x;
			this.parent = parent;
			this.c = c;
		}
	}
	
	static int D(int a) {
		return (a * 2) % 10000;
	}
	static int S(int a) {
		a--;
		if (a < 0) {
			a = 9999;
		}
		return a;
	}
	static int L(int a) {
		return (a * 10) % 10000 + a / 1000;
	}
	static int R(int a) {
		return a / 10 + (a % 10) * 1000;
	}
}
