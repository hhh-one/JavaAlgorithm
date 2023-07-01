package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        test:for (int i = 0; i < t; i++) {
            Deque<Integer> q = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            boolean deleteFirst = true;
            String[] functions = br.readLine().split(""); //함수들
            int n = Integer.parseInt(br.readLine()); //배열의 개수

            String[] strArr = br.readLine().split(",");
            for (int x = 0; x < n; x++) {
                q.offerLast(Integer.parseInt(strArr[x].replace("[", "").replace("]","")));
            }

            for (String f : functions) {
                if (f.equals("R")) {
                    deleteFirst = !deleteFirst;
                } else {
                    if (q.isEmpty()) {
                        System.out.println("error");
                        continue test;
                    }

                    if (deleteFirst) {
                        q.pollFirst();
                    } else {
                        q.pollLast();
                    }
                }
            }

            sb.append("[");
            int size = q.size();
            for (int a = 0; a < size; a++) {
                if (deleteFirst) {
                    sb.append(q.pollFirst());
                } else {
                    sb.append(q.pollLast());
                }

                if (a == size - 1) {
                    break;
                }
                sb.append(",");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
