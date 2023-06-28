package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q1012 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int a = 0; a < t; a++) {
            String[] mnk = br.readLine().split(" ");
            m = Integer.parseInt(mnk[0]);   //베추밭 가로길이
            n = Integer.parseInt(mnk[1]);   //배추밭 세로길이
            int k = Integer.parseInt(mnk[2]);   //배추가 심어진 위치의 개수

            map = new int[n][m];

            //배추 위치 표시하기
            for (int i = 0; i < k; i++) {
                String[] location = br.readLine().split(" ");
                int x = Integer.parseInt(location[0]);
                int y = Integer.parseInt(location[1]);
                map[y][x] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(new int[]{i, j});
                    }
                }
            }
        }
    }

    public static void bfs(int[] start) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        q.offerLast(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();

        }
    }
}
