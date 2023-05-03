package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {
    private static final int MAP_LENGTH = 6;

    private static int[][] map = {
            {0, 0, 0, 1, 1, 0},
            {1, 1, 0, 1 ,0 ,0},
            {0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1 ,0, 1},
            {0, 1, 0 ,0, 0, 1},
            {0, 0, 0, 1 ,0, 0}
    };

    private static boolean[][] visited;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        visited = new boolean[6][6];

        visited[0][0] = true;
        bfs(new int[]{0, 0});
    }

    public static void bfs(int[] start) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(start);
        visited[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int[] current = dq.pollFirst();
            printMap();
            for (int[] direction : directions) {
                int row = current[0] + direction[0];
                int col = current[1] + direction[1];

                if (row < 0 || row >= MAP_LENGTH || col < 0 || col >= MAP_LENGTH) {
                    continue;
                }

                if (map[row][col] == 1) {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                visited[row][col] = true;
                dq.offerLast(new int[]{row, col});
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < MAP_LENGTH; i++) {
            for (int j = 0; j < MAP_LENGTH; j++) {
                if (visited[i][j]) {
                    System.out.print("V ");
                    continue;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

