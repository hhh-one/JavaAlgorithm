package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 데이터의 삽입 삭제, 정렬이 자주 일어날 때 -> 우선순위 큐 이용
        Queue<Integer> q = new PriorityQueue<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            q.add(num);
        }

        while (q.size() != 1) {
            int a = q.remove();
            int b = q.remove();

            q.add(a + b);
            result += a + b;
        }
        System.out.println(result);
    }
}
