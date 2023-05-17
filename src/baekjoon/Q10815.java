package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nCard = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String card : nCard) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] mCard = br.readLine().split(" ");

        for (String card : mCard) {
            System.out.print(map.containsKey(card) ? "1 " : "0 ");
        }
    }
}
