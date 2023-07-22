package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q1388 {
    //인접 행렬
    private static String[][] map;
    private static boolean[][] visited;
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);

        map = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = str[j];
            }
        }


    }

    public static void dfs(int[] start) {
        int[][] directions = {{-1, 0}, {1, 0}};

    }
}
