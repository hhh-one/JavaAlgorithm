package baekjoon;

import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//토마토
public class Q7569 {
    private static int h;
    private static int m;
    private static int n;
    private static int[][][] map;
    private static boolean[][][] visited;
    private static Deque<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mnh = br.readLine().split(" ");
        m = Integer.parseInt(mnh[0]); //가로
        n = Integer.parseInt(mnh[1]); //세로
        h = Integer.parseInt(mnh[2]); //높이

        map = new int[h][n][m];
        visited = new boolean[h][n][m];
        q = new ArrayDeque<>();

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
        for (int i = 0; i < h; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (map[i][r][c] == 1) {
                        q.offerLast(new int[]{i, r, c, 0});
                        visited[i][r][c] = true;
                    }
                }
            }
        }
        int result = bfs();

        no: for (int i = 0; i < h; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (map[i][r][c] == 0 && !visited[i][r][c]) {
                        result = -1;
                        break no;
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs() {
        int[][] directions = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}}; //x, y, z

        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            max = Math.max(max, current[3]);

            for (int[] direction : directions) {
                int nextHeight = current[0] + direction[0];
                int nextRow = current[1] + direction[1];
                int nextCol = current[2] + direction[2];

                if (nextHeight < 0 || nextHeight >= h || nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                if (map[nextHeight][nextRow][nextCol] == -1) {
                    continue;
                }
                if (visited[nextHeight][nextRow][nextCol]) {
                    continue;
                }

                q.offerLast(new int[]{nextHeight, nextRow, nextCol, current[3] + 1});
                visited[nextHeight][nextRow][nextCol] = true;
            }
        }

        return max;
    }
}
