package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q1388 {
    //인접 행렬
    private static String[][] map;
    private static boolean[][] visited;
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);

        map = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = str[j];
            }
        }

        int answer = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    dfs(new int[] {i, j}, map[i][j]);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int[] start, String shape) {
        visited[start[0]][start[1]] = true;

        int[] direction = shape.equals("-") ? new int[]{0, 1} : new int[]{1, 0};
        int nextRow = direction[0] + start[0];
        int nextCol = direction[1] + start[1];

        if (nextRow >= r || nextCol >= c) {
            return;
        }

        if (map[nextRow][nextCol].equals(map[start[0]][start[1]])) {
            dfs(new int[] {nextRow, nextCol}, map[nextRow][nextCol]);
        }
    }
}
