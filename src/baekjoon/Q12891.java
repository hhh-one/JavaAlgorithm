package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//참고 - 책
public class Q12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] dna = br.readLine().split("");

        String[] num = br.readLine().split(" ");
        int a = Integer.parseInt(num[0]);
        int c = Integer.parseInt(num[1]);
        int g = Integer.parseInt(num[2]);
        int t = Integer.parseInt(num[3]);
        int count = 0;


        Map<String, Integer> map = new HashMap<>();
        map.put("A", map.getOrDefault("A", 0));
        map.put("C", map.getOrDefault("C", 0));
        map.put("G", map.getOrDefault("G", 0));
        map.put("T", map.getOrDefault("T", 0));

        for (int i = 0; i < m; i++) {
            map.put(dna[i], map.get(dna[i]) + 1);
        }
        for (int i = 0; i <= n - m; i++) {
            if (i != 0) {
                map.put(dna[i - 1], map.get(dna[i - 1]) - 1);
                map.put(dna[i + m - 1], map.get(dna[i + m - 1]) + 1);
            }
            if (map.get("A") >= a && map.get("C") >= c && map.get("G") >= g && map.get("T") >= t) {
                count++;
            }
        }

        System.out.println(count);
    }
}
