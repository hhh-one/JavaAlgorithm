package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2447 {
    private static String[][] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        str = new String[n][n];
        for (String[] s : str) {
            Arrays.fill(s, "*");
        }

        star(0, 0, n);
        for (String[] s : str) {
            sb.append(String.join("", s)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void star(int iStart, int jStart, int n) {
        if (n == 1) return;

        int size = n / 3;
        for (int i = iStart + size; i < iStart + size * 2; i++) {
            for (int j = jStart + size; j < jStart + size * 2; j++) {
                str[i][j] = " ";
            }
        }

        for (int i = iStart; i < iStart + n; i += size) {
            for (int j = jStart; j < jStart + n; j += size) {
                star(i, j, size);
            }
        }

    }
}
