package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1926 {
    private static List<Integer> s; //그림의 넓이 list
    //인접행렬
    private static int[][] map;
    private static boolean[][] visited;
    private static int r;
    private static int c;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);

        visited = new boolean[r][c];
        map = new int[r][c];
        s = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String[] pictures = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(pictures[j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int answer = bfs(new int[] {i, j});
                    s.add(answer);
                }
            }
        }

        s.sort(Comparator.reverseOrder());
        System.out.println(s.size());
        System.out.println(s.size() == 0 ? 0 : s.get(0));
    }

    public static int bfs(int[] start) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> q = new ArrayDeque<>();
        int answer = 1;

        q.offerLast(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] current = q.pollFirst();
            for (int[] direction : directions) {
                int nextRow = current[0] + direction[0];
                int nextCol = current[1] + direction[1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                if (map[nextRow][nextCol] != 1) {
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
