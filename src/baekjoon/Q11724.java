package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q11724 {
    private static List<List<Integer>> list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int answer = 0; //연결 요소의 개수
        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        //list 초기화
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int x = Integer.parseInt(edge[0]);
            int y = Integer.parseInt(edge[1]);

            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int node : list.get(start)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
