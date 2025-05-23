import java.io.*;
import java.util.*;

public class Main {
	private static char[][] map;
	private static int width;
	private static int height;
	private static boolean[] mova = new boolean[128];
	private static final int UP = 'U';
	private static final int DOWN = 'D';
	private static final int LEFT = 'L';
	private static final int RIGHT = 'R';
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		mova['.'] = true;
		mova['O'] = true;
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		Point red = new Point();
		Point blue = new Point();
		
		map = new char[height][width];
		for (int i = 0; i < height; i++) {
			String str = br.readLine();
			for (int j = 0; j < width; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					red.x = j;
					red.y = i;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue.x = j;
					blue.y = i;
					map[i][j] = '.';
				}
			}
		}
		
		Queue<Session> queue = new LinkedList<>();
		queue.add(new Session(new Ball(red), new Ball(blue), 1, UP));
		queue.add(new Session(new Ball(red), new Ball(blue), 1, DOWN));
		queue.add(new Session(new Ball(red), new Ball(blue), 1, LEFT));
		queue.add(new Session(new Ball(red), new Ball(blue), 1, RIGHT));
		int ans = -1;
		while(!queue.isEmpty()) {
			Session cur = queue.poll();
			cur.move();
//			cur.print();
//			System.out.println(queue);
			
			if (cur.n > 10) {
				continue;
			}
			
			if (cur.isWin()) {
				ans = cur.n;
				break;
			}
			
			if (!cur.isLose()) {
				Session ns = new Session(cur.getRed(), cur.getBlue(), cur.n + 1, UP);
				if (ns.isMoveable()) {
					queue.add(ns);	
				}
				ns = new Session(cur.getRed(), cur.getBlue(), cur.n + 1, DOWN);
				if (ns.isMoveable()) {
					queue.add(ns);	
				}
				ns = new Session(cur.getRed(), cur.getBlue(), cur.n + 1, LEFT);
				if (ns.isMoveable()) {
					queue.add(ns);	
				}
				ns = new Session(cur.getRed(), cur.getBlue(), cur.n + 1, RIGHT);
				if (ns.isMoveable()) {
					queue.add(ns);	
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static class Session {
		Ball red;
		Ball blue;
		int n;
		int dir;
		public Session(Ball red, Ball blue, int n, int dir) {
			super();
			this.red = red;
			this.blue = blue;
			this.n = n;
			this.dir = dir;
		}
		public boolean isMoveable() {
			return red.isMoveable(dir) || blue.isMoveable(dir);
		}
		public void move() {
			boolean rm;
			boolean bm;
			do {
				rm = red.move(dir, blue.pos);
				bm = blue.move(dir, red.pos);
			} while (rm || bm);
		}
		
		public boolean isWin() {
			return red.pos == null && blue.pos != null;
		}
		
		public boolean isLose() {
			return blue.pos == null;
		}
		public Ball getRed() {
			return new Ball(this.red.pos);
		}
		
		public Ball getBlue() {
			return new Ball(this.blue.pos);
		}
		
		public void print() {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					if (red.pos != null && i == red.pos.y && j == red.pos.x) {
						sb.append('R');
						continue;
					}
					
					if (blue.pos != null && i == blue.pos.y && j == blue.pos.x) {
						sb.append('B');
						continue;
					}
					
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			System.out.println(sb);
		}
		@Override
		public String toString() {
			return (char)dir + "";
		}
	}
	
	static class Ball {
		Point pos;
		
		
		public Ball(Point pos) {
			super();
			this.pos = pos;
		}
		
		public boolean isMoveable(int dir) {
			Point newPos;
			switch (dir) {
			case UP:
				newPos = new Point(pos.x, pos.y - 1);
				break;
			case DOWN:
				newPos = new Point(pos.x, pos.y + 1);
				break;
			case LEFT:
				newPos = new Point(pos.x - 1, pos.y);
				break;
			case RIGHT:
				newPos = new Point(pos.x + 1, pos.y);
				break;
			default:
				return false;
			}
			
			if (map[newPos.y][newPos.x] == '#') {
				return false;
			}
			return true;
		}


		public boolean move(int dir, Point other) {
			if (pos == null) {
				return false;
			}
			if (map[pos.y][pos.x] == 'O') {
				pos = null;
				return false;
			}
			Point newPos;
			
			switch (dir) {
			case UP:
				newPos = new Point(pos.x, pos.y - 1);
				break;
			case DOWN:
				newPos = new Point(pos.x, pos.y + 1);
				break;
			case LEFT:
				newPos = new Point(pos.x - 1, pos.y);
				break;
			case RIGHT:
				newPos = new Point(pos.x + 1, pos.y);
				break;
			default:
				return false;
			}
			
			if (newPos.x < 0 || newPos.y < 0 || newPos.x >= width || newPos.y >= height) {
				return false;
			}
			
			if (map[newPos.y][newPos.x] == '#') {
				return false;
			}
			
			if (!mova[map[newPos.y][newPos.x]]) {
				return false;
			}
			
			if (other != null && newPos.x == other.x && newPos.y == other.y) {
				return false;
			}
			
			
			pos = newPos;
			
			return true;
		}
	}
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Point() {
		}
		
	}
}