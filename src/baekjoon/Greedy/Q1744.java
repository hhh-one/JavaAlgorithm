package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1744 {
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //1 초과 양수를 담은 우선순위큐
        Queue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        //음수를 담은 우선순위큐
        Queue<Integer> minQ = new PriorityQueue<Integer>();
        answer = 0;
        int zeroNum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) {
                minQ.add(num);
            } else if (num == 0) {
                zeroNum += 1;
            } else if (num == 1) {
                answer += 1;
            } else {
                maxQ.add(num);
            }
        }

        int max = bind(maxQ);
        int min = bind(minQ);

        answer += max;
        if (min != 0 && zeroNum == 0) {
            answer += min;
        }

        System.out.println(answer);
    }

    public static int bind(Queue<Integer> q) {
        while (q.size() > 1) {
            int a = q.remove();
            int b = q.remove();

            answer += a * b;
        }

        if (!q.isEmpty()) {
            return q.remove();
        }
        return 0;
    }
}
