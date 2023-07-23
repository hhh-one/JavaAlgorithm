package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2583 {
    private static int r;
    private  static int c;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rck = br.readLine().split(" ");
        r = Integer.parseInt(rck[0]);
        c = Integer.parseInt(rck[1]);
        int k = Integer.parseInt(rck[2]);
        int num = 0; //분리되는 영역의 개수
        List<Integer> answer = new ArrayList<>();

        visited = new boolean[r][c];

        for (int i = 0; i < k; i++) {
            String[] xy = br.readLine().split(" ");
            int c1 = Integer.parseInt(xy[0]);
            int c2 = Integer.parseInt(xy[2]);
            int r1 = Integer.parseInt(xy[1]);
            int r2 = Integer.parseInt(xy[3]);

            for (int row = r1; row < r2; row++) {
                for (int col = c1; col < c2; col++) {
                    visited[row][col] = true;
                }
            }

        }

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (!visited[row][col]) {
                    int s = bfs(new int[] {row, col});
                    num++;
                    answer.add(s);
                }
            }
        }

        answer.sort(Comparator.naturalOrder());

        System.out.println(num);
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    public static int bfs(int[] start) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        int s = 1;

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

                q.offerLast(new int[] {nextRow, nextCol});
                visited[nextRow][nextCol] = true;
                s++;
            }
        }

        return s;
    }
}
