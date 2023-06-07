package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Q18016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] card = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(card[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        int[] find = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < m; i++) {
            if (map.containsKey(find[i])) {
                sb.append(map.get(find[i])).append(" ");
                continue;
            }
            sb.append("0 ");
        }

        System.out.println(sb.toString());
    }
}
