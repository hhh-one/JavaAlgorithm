package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q18258 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains("push")) {
                String[] str = s.split(" ");
                queue.offer(Integer.parseInt(str[1]));
            } else if (s.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(queue.poll());
            } else if (s.equals("size")) {
                System.out.println(queue.size());
            } else if (s.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (s.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(queue.peek());
            } else {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(queue.peekLast());
            }
        }
    }
}
