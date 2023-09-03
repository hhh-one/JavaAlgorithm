package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class n개의최소공배수 {
    public int solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a: arr) {
            stack.offerLast(a);
        }

        while (stack.size() > 1) {
            int a = stack.pollFirst();
            int b = stack.pollFirst();

            int gt = Math.max(a, b);
            int lt = Math.min(a, b);
            int gcd = gcd(gt, lt);
            int lcm = a * b / gcd;
            stack.offerFirst(lcm);
        }
        return stack.pollLast();
//         int answer = arr[0];
//         int gcd = arr[0];

//         for (int i = 1; i < arr.length; i++) {
//             int gt = Math.max(arr[i], answer);
//             int lt = Math.min(arr[i], answer);

//             gcd = gcd(gt, lt);
//             answer = answer * arr[i] / gcd;
//         }

//         return answer;
    }

    public int gcd(int gt, int lt) {
        if (gt % lt == 0) {
            return lt;
        }

        return gcd(lt, gt % lt);
    }
}
