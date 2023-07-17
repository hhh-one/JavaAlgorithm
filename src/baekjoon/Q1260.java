package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
    //인접리스트
    private static List<List<Integer>> list;
    private static boolean[] bfsVisited;
    private static boolean[] dfsVisited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmv = br.readLine().split(" ");
        int n = Integer.parseInt(nmv[0]); //정점(1~)
        int m = Integer.parseInt(nmv[1]); //간선
        int v = Integer.parseInt(nmv[2]); //그래프 탐색 시작할 정점

        //인접리스트 초기화
        list = new ArrayList<>();
        bfsVisited = new boolean[n + 1];
        dfsVisited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        //간선 초기화
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int x = Integer.parseInt(edge[0]);
            int y = Integer.parseInt(edge[1]);
            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(v);
        System.out.println();

        int[] answer = bfs(v);
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    public static int[] bfs(int start) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        q.offerLast(start);
        bfsVisited[start] = true;

        while (!q.isEmpty()) {
            int current = q.pollFirst();
            answer.add(current);

            //방문할 수 있는 정점이 여러 개인 경우, 정점 번호가 작은 것부터
            list.get(current).sort(Comparator.naturalOrder());

            for (int next : list.get(current)) {
                if (bfsVisited[next]) {
                    continue;
                }
                q.offerLast(next);
                bfsVisited[next] = true;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void dfs(int start) {
        dfsVisited[start] = true;
        System.out.print(start + " ");

        //방문할 수 있는 정점이 여러 개인 경우, 정점 번호가 작은 것부터
        list.get(start).sort(Comparator.naturalOrder());

        for (int node : list.get(start)) {
            if (!dfsVisited[node]) {
                dfs(node);
            }
        }
    }
}
