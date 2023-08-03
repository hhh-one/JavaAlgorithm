package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//1303
public class Q1303 {
    private static String[][] map;
    private static boolean[][] visited;
    private static int r;
    private static int c;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cr = br.readLine().split(" ");
        r = Integer.parseInt(cr[1]);
        c = Integer.parseInt(cr[0]);
        int w = 0;
        int b = 0;

        map = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = str[j];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    int s = bfs(new int[] {i, j});
                    if (map[i][j].equals("W")) {
                        w += s * s;
                    } else {
                        b += s * s;
                    }
                }
            }
        }

        System.out.println(w + " " + b);
    }

    public static int bfs(int[] start) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        visited[start[0]][start[1]] = true;
        int answer = 1;

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
                if (!map[nextRow][nextCol].equals(map[start[0]][start[1]])) {
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
