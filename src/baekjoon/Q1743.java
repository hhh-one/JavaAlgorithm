package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q1743 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int r;
    private static int c;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String[] rck = br.readLine().split(" ");
        r = Integer.parseInt(rck[0]);
        c = Integer.parseInt(rck[1]);
        int k = Integer.parseInt(rck[2]);

        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < k; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]) - 1;
            int end = Integer.parseInt(edge[1]) - 1;

            map[start][end] = 1;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int n = bfs(new int[] {i, j});
                    answer = Math.max(answer, n);
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int answer = 1;

        q.offerLast(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] current = q.pollFirst();

            for (int[] direction : directions) {
                int nextRow = direction[0] + current[0];
                int nextCol = direction[1] + current[1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                if (map[nextRow][nextCol] == 0) {
                    continue;
                }

                q.offerLast(new int[] {nextRow, nextCol});
                visited[nextRow][nextCol] = true;
                answer++;
            }
        }

        return answer;
    }
}
