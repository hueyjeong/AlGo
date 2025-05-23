import java.io.*;
import java.util.*;

public class Main {
	private static final boolean[][][] masks = new boolean[][][] {
		{
			{true,true,true,true},
		},
		{
			{true},
			{true},
			{true},
			{true}
		},
		{
			{true,true},
			{true,true}
		},
		{
			{true,true},
			{true},
			{true},
		},
		{
			{true,true},
			{false,true},
			{false,true},
		},
		{
			{true},
			{true},
			{true,true},
		},
		{
			{false,true},
			{false,true},
			{true,true},
		},
		{
			{true,true,true},
			{true},
		},
		{
			{true,true,true},
			{false,false,true},
		},
		{
			{true},
			{true,true,true},
		},
		{
			{false,false,true},
			{true,true,true}
		},
		{
			{true},
			{true,true},
			{false,true}
		},
		{
			{false,true},
			{true,true},
			{true}
		},
		{
			{true,true},
			{false,true,true}
		},
		{
			{false,true,true},
			{true,true}
		},
		{
			{true},
			{true,true},
			{true}
		},
		{
			{false,true},
			{true,true},
			{false,true}
		},
		{
			{false,true},
			{true,true,true}
		},
		{
			{true,true,true},
			{false,true}
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
				for(boolean[][] mask : masks) {
					try {
						int sum = 0;
						for(int k = 0; k < mask.length; k++) {
							for(int l = 0; l < mask[k].length; l++) {
								if (mask[k][l]) {
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