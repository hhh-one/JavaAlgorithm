package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//워노가 알려준 문제에요 내가 다시 생각하세요
public class Q1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sum = new int[n];

        sum[0] = num[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + num[i], num[i]);
        }

        int result = Integer.MIN_VALUE;
        for (int i : sum) {
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}
