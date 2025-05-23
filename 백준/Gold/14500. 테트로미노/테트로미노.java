import java.io.*;
import java.util.*;

public class Main {
	private static final int[][][] masks = new int[][][] {
		{
			{1,1,1,1},
		},
		{
			{1},
			{1},
			{1},
			{1}
		},
		{
			{1,1},
			{1,1}
		},
		{
			{1,1},
			{1},
			{1},
		},
		{
			{1,1},
			{0,1},
			{0,1},
		},
		{
			{1},
			{1},
			{1,1},
		},
		{
			{0,1},
			{0,1},
			{1,1},
		},
		{
			{1,1,1},
			{1},
		},
		{
			{1,1,1},
			{0,0,1},
		},
		{
			{1},
			{1,1,1},
		},
		{
			{0,0,1},
			{1,1,1}
		},
		{
			{1},
			{1,1},
			{0,1}
		},
		{
			{0,1},
			{1,1},
			{1}
		},
		{
			{1,1},
			{0,1,1}
		},
		{
			{0,1,1},
			{1,1}
		},
		{
			{1},
			{1,1},
			{1}
		},
		{
			{0,1},
			{1,1},
			{0,1}
		},
		{
			{0,1},
			{1,1,1}
		},
		{
			{1,1,1},
			{0,1}
		}
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] p = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int[][] mask : masks) {
					try {
						int sum = 0;
						for(int k = 0; k < mask.length; k++) {
							for(int l = 0; l < mask[k].length; l++) {
								if (mask[k][l] == 1) {
									sum += p[i + k][j + l];
								}
							}
						}
						max = Math.max(max, sum);
					} catch (Exception e) {
						
					}
				}
			}
		}
		System.out.println(max);
	}
}