package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q4779 {
    private static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String s;
        while((s = br.readLine()) != null) {
            int t = Integer.parseInt(s);
            int n = (int) Math.pow(3, t);
            str = new String[n];
            Arrays.fill(str, "-");

            cantor(0, n);
            sb.append(String.join("", str)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void cantor(int start, int n) {
        if (n == 1) return;

        int size = n / 3;
        //빈칸 칠하기
        for (int i = start + size; i < start + size * 2; i++) {
            str[i] = " ";
        }

        //앞쪽 재귀
        cantor(start, size);
        //뒤쪽 재귀
        cantor(start + 2 * size, size);
    }
}
