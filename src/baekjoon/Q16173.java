package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16173 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;
    private static String answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        answer = "Hing";

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        dfs(new int[] {0, 0});
        System.out.println(answer);
    }

    public static void dfs(int[] start) {
        int[][] directions = {{1, 0}, {0, 1}};
        int num = map[start[0]][start[1]];
        visited[start[0]][start[1]] = true;

        if (num >= n && num == 0) {
            return;
        }

        for (int[] direction : directions) {
            int nextRow = direction[0] * num + start[0];
            int nextCol = direction[1] * num + start[1];

            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
                continue;
            }
            if (visited[nextRow][nextCol]) {
                continue;
            }

            if (map[nextRow][nextCol] == -1) {
                answer = "HaruHaru";
                return;
            }
            dfs(new int[] {nextRow, nextCol});
        }
    }

}
