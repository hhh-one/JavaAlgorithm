package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q2644 {
    private static List<List<Integer>> list;
    private static boolean[] visited;
    private static int findEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); //전체 사람 수

        //선언
        list = new ArrayList<>();
        visited = new boolean[num + 1];
        for (int i = 0; i < num + 1; i++) {
            list.add(new ArrayList<>());
        }

        String[] find = br.readLine().split(" ");
        int findStart = Integer.parseInt(find[0]);
        findEnd = Integer.parseInt(find[1]);

        int edges = Integer.parseInt(br.readLine());
        //초기화
        for (int i = 0; i < edges; i++) {
            String[] edge = br.readLine().split(" ");
            int p1 = Integer.parseInt(edge[0]);
            int p2 = Integer.parseInt(edge[1]);
            list.get(p1).add(p2);
            list.get(p2).add(p1);
        }

        int answer = bfs(new int[] {findStart, 0});
        System.out.println(answer);
    }

    public static int bfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        visited[start[0]] = true;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            for (int node : list.get(current[0])) {
                if (visited[node]) {
                    continue;
                }
                if (node == findEnd) {
                    return current[1] + 1;
                }
                q.offerLast(new int[] {node, current[1] + 1});
                visited[node] = true;
            }
        }
        return -1;
    }
}
