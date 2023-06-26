package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2178 {
    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int result = bfs(new int[]{0, 0, 1});
        System.out.println(result);
    }

    public static int bfs(int[] start) {
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        q.offerLast(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            for (int[] direction : directions) {
                int nextRow = direction[0] + current[0];
                int nextCol = direction[1] + current[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                if (map[nextRow][nextCol] == 0) {
                    continue;
                }

                if (nextRow == n - 1 && nextCol == m - 1) {
                    return current[2] + 1;
                }

                q.offerLast(new int[]{nextRow, nextCol, current[2] + 1});
                visited[nextRow][nextCol] = true;
            }
        }

        return -1;
    }
}