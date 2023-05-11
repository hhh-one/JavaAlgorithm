package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        //투포인터
        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum > x) {
                end--;
            } else {
                start++;
            }

            if (sum == x) {
                count++;
                end--;
            }
        }
        System.out.println(count);
    }
}
