package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Q1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] a = Stream.of(br.readLine().split(" ")).distinct().mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        int[] b = Stream.of(br.readLine().split(" ")).distinct().mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < m; i++) {
            map.put(b[i], map.getOrDefault(b[i], 0) + 1);
        }

        int count = 0;
        for (int num : map.keySet()) {
            if (map.get(num) != 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
