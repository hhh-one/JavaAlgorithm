package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] arr = new int[2];

        for (int i = 0; i < s.length ; i++) {
            String[] str = s[i].split("");
            String s1 = "";

            for (int j = 2; j >= 0; j--) {
                s1 += str[j];
            }
            arr[i] = Integer.parseInt(s1);
        }

        if(arr[0] < arr[1]) {
            System.out.println(arr[1]);
        } else {
            System.out.println(arr[0]);
        }
    }
}
