package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ_11047_동전O {
	
	static int N, K;
	static int coin[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		coin = new int[N];
		int total = 0;
		
		for (int i = 0; i < N; i++) { // coin 리스트에 값 넣기
			int x = sc.nextInt();
			coin[i]=x;
		}
		
		for (int i = N-1; i>=0; i--) { // 배열을 거꾸로 돌면서 K값을 없애줌
			if(coin[i]<=K) {
				total += K/coin[i];
				K = K%coin[i];
			}
		}
		System.out.println(total);
		
	}
	
}
