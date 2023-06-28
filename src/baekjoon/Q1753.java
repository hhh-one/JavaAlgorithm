package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//다익스트라 공부하고 오기 - 다음에 풀어보기
//bfs - 방향그래프 + 가중치
public class Q1753 {
    //인접 행렬
    private static int[][] map;
    private static int v;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //노드 간선
        String[] ve = br.readLine().split(" ");
        v = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);

        //각 노드별 최단거리를 구한 배열
        answer = new int[v];

        //시작 노드 인덱스
        int start = Integer.parseInt(br.readLine()) - 1;

        //간선 + 가중치
        map = new int[v][v];
        for (int i = 0; i < e; i++) {
            String[] edge = br.readLine().split(" ");
            int first = Integer.parseInt(edge[0]) - 1;
            int last = Integer.parseInt(edge[1]) - 1;
            int weight = Integer.parseInt(edge[2]);

            //여러 개의 간선 중 가중치가 가장 적은 것
            if (map[first][last] != 0 && map[first][last] < weight) {
                continue;
            }
            map[first][last] = weight;
        }

        //탐색
        bfs(start);

        for (int i = 0; i < v; i++) {
            if (i != start && answer[i] == 0) {
                System.out.println("INF");
                continue;
            }
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[v];
        Deque<Integer[]> q = new ArrayDeque<>();

        //시작 정점 넣기
        q.offerLast(new Integer[]{start, 0});
        visited[start] = true;
        answer[start] = 0;

        while (!q.isEmpty()) {
            Integer[] currents = q.pollFirst();
            int current = currents[0];
            int w = currents[1];

            for (int i = 0; i < v; i++) {
                //이미 방문한 노드
                if (visited[i]) {
                    continue;
                }
                //연결되어 있지 않은 노드
                if (map[current][i] == 0) {
                    continue;
                }
                q.offerLast(new Integer[]{i, w + map[current][i]});
                visited[i] = true;
                answer[i] = w + map[current][i];
            }
        }
    }
}
