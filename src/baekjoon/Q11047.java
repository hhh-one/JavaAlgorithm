package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int answer = 0;

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[n - i - 1] = coin;
        }

        for (int i = 0; i < n; i++) {
            if (k < coins[i]) {
                continue;
            }
            if (k == 0) {
                break;
            }
            answer += k / coins[i];
            k = k % coins[i];
        }

        System.out.println(answer);
    }
}
