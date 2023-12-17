package algorithm;

import java.io.BufferedReader;
import java.util.Scanner;

public class BJ_1522_문자열교환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int aCnt = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='a') {
				aCnt++;
			}
		}
	
		for(int i=0; i<s.length(); i++) {
			int bCnt = 0;
			for(int j=i; j<i+aCnt; j++) {
				int idx = j%s.length();
				if(s.charAt(idx) =='b') {
					bCnt++;
				}
			}
			min = Math.min(min, bCnt);
		}
		
		System.out.println(min);
		
		
	}

}
