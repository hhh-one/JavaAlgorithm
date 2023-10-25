package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minusStr = br.readLine().split("-");
        int answer = 0;

        for (int i = 0; i < minusStr.length; i++) {
            int plusAnswer = 0;
            String[] plusStr = minusStr[i].split("\\+");

            for (String plus : plusStr) {
                int num = Integer.parseInt(plus);
                plusAnswer += num;
            }

            if (i == 0) {
                answer = plusAnswer;
                continue;
            }
            answer -= plusAnswer;
        }
        System.out.println(answer);
    }
}
