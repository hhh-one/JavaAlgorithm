package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        //A진법 -> 10진법
        int decimal = 0;
        for (int i = m - 1; i >= 0; i--) {
            decimal += Math.pow(a, i) * Integer.parseInt(st.nextToken());
        }

        //10진법 -> B진법
        List<Integer> answer = new ArrayList<>();
        while (decimal >= b) {
            answer.add(decimal % b);
            decimal /= b;
            if (decimal < b) {
                answer.add(decimal);
            }
        }

        for (int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
