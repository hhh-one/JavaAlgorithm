package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//토마토
public class Q7569 {
    private static int[][][] map;
    private static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mnh = br.readLine().split(" ");
        int m = Integer.parseInt(mnh[0]); //가로
        int n = Integer.parseInt(mnh[1]); //세로
        int h = Integer.parseInt(mnh[2]); //높이

        map = new int[h][n][m];
        visited = new boolean[h][n][m];
        //map 초기화
        for (int i = 0; i < h; i++) {
            for (int r = 0; r < n; r++) {
                String[] tomato = br.readLine().split(" ");
                for (int c = 0; c < m; c++) {
                    map[i][r][c] = Integer.parseInt(tomato[c]);
                }
            }
        }

        //bfs
    }

    public static void bfs(int[] start) {
        int[][] directions = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        Deque<int[]> q = new ArrayDeque<>();

        q.offerLast(start);
        visited[start[0]][start[1]][start[2]] = true;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();

            for (int[] direction : directions) {
                int nextHeight = current[0] + direction[0];
                int nextRow = current[1] + direction[1];
                int nextCol = current[2] + direction[2];
            }
        }

    }
}
