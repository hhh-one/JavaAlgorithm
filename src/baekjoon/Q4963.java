package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q4963 {
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(true) {
            if ((str = br.readLine()).equals("0 0")) {
                break;
            }
            String[] wh = str.split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);

            map = new int[w][h];

            for (int i = 0; i < h; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }
        }
    }

    public static void bfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        visited[start[0]][start[1]] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        while (!q.isEmpty()) {
            q.pollFirst();
        }
    }
}
