package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int a = 0; a < m; a++) {
            String[] str = br.readLine().split(" ");
            int i = Integer.parseInt(str[0]) - 1;
            int j = Integer.parseInt(str[1]) - 1;
            for (int x = i; x < j; x++) {
                for (int y = i; y < i + j - x; y++) {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }

        for(int a : arr) {
            System.out.print(a + " ");
        }
    }
}