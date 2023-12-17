package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2583_영역구하기 {
    static StringTokenizer st;
    static int M,N,K;
    static int map[][];
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int cnt;
    static boolean visited[][];
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) { // 열과 행에 맞춰서 map지정
                for (int j2 = x1; j2 < x2; j2++) {
                    map[j][j2] = 9;
                    visited[j][j2] = true;
                }
            }

        }
        cnt = 1;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    total = 1;
                    visited[i][j] = true;
                    dfs(i,j, cnt++);
                    list.add(total);
                }
            }
        }

        Collections.sort(list);
        System.out.println(cnt-1);
        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1) System.out.println(list.get(i));
            else System.out.print(list.get(i)+" ");
        }

    }

    private static void dfs(int r, int c, int cnt) {

        map[r][c] = cnt;
        for (int dir = 0; dir < 4; dir++) {
            int nr = r+dr[dir];
            int nc = c+dc[dir];

            if(nr<0 || nc<0 || nr>=M || nc>=N || map[nr][nc]==9 || visited[nr][nc]) continue;
            total++;
            map[nr][nc] = cnt;

            visited[nr][nc] = true;
            dfs(nr,nc,cnt);

        }
    }


}
