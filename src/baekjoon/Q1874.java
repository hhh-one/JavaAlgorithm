package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//다시풀기
public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int count = 1; //push 세주는 용도
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (count <= num) {
                for (int j = count; j <= num; j++) {
                    stack.push(count);
                    sb.append("+").append("\n");
                    count++;
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                if (stack.peek() == num) {
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }
        }

        System.out.println(stack.size() != 0 ? "NO" : sb.toString());
    }
}
