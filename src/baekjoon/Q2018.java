package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //포인터 start, end
        int s = 0;
        int e = 0;
        int count = 0;
        long sum = 0;
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        while (s < n) {
            if (sum < n) {
                sum += arr[e];
                e++;
            } else {
                sum -= arr[s];
                s++;
            }

            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}
