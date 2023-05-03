package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] en = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String[] str = br.readLine().split("");
        int result = 0;

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < en.length; j++) {
                if (en[j].contains(str[i])) {
                   result += j + 3;
                }
            }
        }
        System.out.println(result);
    }
}
