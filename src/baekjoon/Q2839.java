package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;


        for (int i = 0; i <= n / 5; i++) {
            int num = n;
            int count = 0;

            num -= 5 * (i);
            count += i;

            if (num % 3 == 0) {
                  count += num / 3;
                min = Math.min(min, count);
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }
}
