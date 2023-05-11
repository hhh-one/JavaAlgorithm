package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[][] num = new int[2][3];
        int x = 0;
        int y = 0;

        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(str[3 * i + j]);
            }
        }

        int x1 = num[0][0];
        int x2 = num[1][0];

        if (x1 == 0) {
            y = num[0][2] / num[0][1];
            x = (num[1][2] - y * num[1][1]) / num[1][0];
        } else if (x2 == 0) {
            y = num[1][2] / num[1][1];
            x = (num[0][2] - y * num[0][1]) / num[0][0];
        } else {
            for(int j = 0; j < 3; j++) {
                num[0][j] = x2 * num[0][j];
                num[1][j] = x1 * num[1][j];

                y = (num[0][2] - num[1][2]) / (num[0][1] - num[1][1]);
                if (num[0][0] != 0) {
                    x = (num[0][2] - num[0][1] * y) / num[0][0];
                } else if (num[1][0] != 0) {
                    x = (num[1][2] - num[1][1] * y) / num[1][0];
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
