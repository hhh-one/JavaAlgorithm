package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] s = br.readLine().split(" ");
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + Integer.parseInt(s[i]);
        }

        int start = 0;
        int end = 1;
        int min = Integer.MAX_VALUE;
        while (end != n + 1) {
            if (sum[end] - sum[start] < m) {
                end++;
            } else {
                min = Math.min(min, end - start);
                start++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.println(min);
    }
}
