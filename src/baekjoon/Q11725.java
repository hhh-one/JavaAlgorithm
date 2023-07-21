package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q11725 {
    //인접리스트
    private static List<List<Integer>> list;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);

            list.get(start).add(end);
            list.get(end).add(start);
        }

        bfs(1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();

        q.offerLast(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.pollFirst();

            for (int next : list.get(current)) {
                if (visited[next]) {
                    continue;
                }
                q.offerLast(next);
                visited[next] = true;
                answer[next] = current;
            }
        }
    }
}
