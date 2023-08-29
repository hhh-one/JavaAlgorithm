package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4963 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int w;
    private static int h;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int answer = 0;
            String[] wh = br.readLine().split(" ");
            if (wh[0].equals("0") && wh[1].equals("0")) {
                break;
            }

            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0 ; i < h; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(new int[] {i, j});
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int[] start) {
        visited[start[0]][start[1]] = true;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] direction : directions) {
            int nextRow = direction[0] + start[0];
            int nextCol = direction[1] + start[1];

            if (nextRow < 0 || nextCol < 0 || nextRow >= h || nextCol >= w) {
                continue;
            }
            if (visited[nextRow][nextCol]) {
                continue;
            }
            if (map[nextRow][nextCol] == 0) {
                continue;
            }

            dfs(new int[] {nextRow, nextCol});
        }
    }
}
