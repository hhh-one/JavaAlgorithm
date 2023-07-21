package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2468 {
    //인접 행렬
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int highest = 0; //가장 높은 지역의 높이
        int max = 1; //안전한 영역 개수의 최대

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int rain = Integer.parseInt(s[j]);
                map[i][j] = rain;

                //모든 경우를 조사하기 위한 가장 높은 지역
                highest = Math.max(highest, rain);
            }
        }

        for (int height = 1; height < highest; height++) {
            visited = new boolean[n][n];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        bfs(height, new int[] {i, j});
                        answer++;
                    }
                }
            }
            max = Math.max(max, answer);
        }

        System.out.println(max);
    }

    public static void bfs(int height, int[] start) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> q = new ArrayDeque<>();

        q.offerLast(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] current = q.pollFirst();

            for (int[] direction : directions) {
                int nextRow = current[0] + direction[0];
                int nextCol = current[1] + direction[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                if (map[nextRow][nextCol] <= height) {
                    continue;
                }

                q.offerLast(new int[] {nextRow, nextCol});
                visited[nextRow][nextCol] = true;
            }
        }
    }
}
