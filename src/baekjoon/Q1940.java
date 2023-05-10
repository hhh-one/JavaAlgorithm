package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        int s = 0;
        int e = n - 1;
        int count = 0;

        while (s < e) {
            int sum = arr[s] + arr[e];

            if (sum == m) {
                count++;
                s++;
                e--;
            } else if (sum < m) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(count);
    }
}
