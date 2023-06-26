package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//bfs
public class Q2606 {
    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());		//node 수
        int e = Integer.parseInt(br.readLine());	//edge 수

        map = new int[n][n];
        for (int i = 0; i < e; i++) {
            String[] s = br.readLine().split(" ");

            //index로 나타내기 위해 -1씩 계산
            int x = Integer.parseInt(s[0]) - 1;
            int y = Integer.parseInt(s[1]) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }

        // 시작점: 1번 컴퓨터 - 인덱스:0
        System.out.println(bfs(0));
    }

    public static int bfs(int start) {
        int result = 0;
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();

        q.offerLast(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.pollFirst();

            for (int i = 0; i < n; i++) {
                if (map[current][i] == 0) {
                    continue;
                }
                if (visited[i] == true) {
                    continue;
                }
                q.offerLast(i);
                visited[i] = true;
                result++;
            }
        }

        return result;
    }
}
