package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int q = Integer.parseInt(br.readLine());

        for (int x = 0; x < q; x++) {
            String[] test = br.readLine().split(" ");
            String alpha = test[0];
            int i = Integer.parseInt(test[1]);
            int j = Integer.parseInt(test[2]);
            int count = 0;

            for (int y = i; y <= j; y++) {
                if (s[y].equals(alpha)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
