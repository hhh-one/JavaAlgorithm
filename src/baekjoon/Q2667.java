package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();
        int danji = 0;

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int house = bfs(new int[]{i, j});
                    danji++;
                    answer.add(house);
                }
            }
        }

        System.out.println(danji);
        answer.sort(Comparator.naturalOrder());
        for (int a : answer) {
            System.out.println(a);
        }
    }

    public static int bfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        visited[start[0]][start[1]] = true;
        int count = 1;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();

            for (int[] direction : directions) {
                int nextRow = current[0] + direction[0];
                int nextCol = current[1] + direction[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                if (map[nextRow][nextCol] == 0) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                q.offerLast(new int[]{nextRow, nextCol});
                visited[nextRow][nextCol] = true;
                count++;
            }
        }
        return count;
    }
}
