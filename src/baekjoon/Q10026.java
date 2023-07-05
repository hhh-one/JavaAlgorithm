package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//적록색약
public class Q10026 {
    private static int n;
    //아닌 사람
    private static String[][] map;
    private static boolean[][] visited;
    //적록색약인 사람
    private static String[][] blindMap;
    private static boolean[][] blindVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        blindMap = new String[n][n];
        visited = new boolean[n][n];
        blindVisited = new boolean[n][n];

        int count = 0;
        int blindCount = 0;

        //map 값 초기화
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = str[j];

                if (str[j].equals("G")) {
                    blindMap[i][j] = "R";
                    continue;
                }
                blindMap[i][j] = str[j];
            }
        }

        //bfs
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(new int[] {i, j});
                    count++;
                }
                if (!blindVisited[i][j]) {
                    blindBfs(new int[] {i, j});
                    blindCount++;
                }
            }
        }

        System.out.println(count + " " + blindCount);
    }

    //q가 겹쳐서 따로 함수를 만들었다
    public static void bfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        q.offerLast(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] current = q.pollFirst();

            for (int[] direction : directions) {
                int nextRow = direction[0] + current[0];
                int nextCol = direction[1] + current[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                if (!map[current[0]][current[1]].equals(map[nextRow][nextCol])) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                q.offerLast(new int[] {nextRow, nextCol});
                visited[nextRow][nextCol] = true;
            }
        }
    }

    public static void blindBfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        q.offerLast(start);
        blindVisited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] current = q.pollFirst();

            for (int[] direction : directions) {
                int nextRow = direction[0] + current[0];
                int nextCol = direction[1] + current[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                if (!blindMap[current[0]][current[1]].equals(blindMap[nextRow][nextCol])) {
                    continue;
                }
                if (blindVisited[nextRow][nextCol]) {
                    continue;
                }
                q.offerLast(new int[] {nextRow, nextCol});
                blindVisited[nextRow][nextCol] = true;
            }
        }
    }
}
