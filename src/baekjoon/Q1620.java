package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            map.put(s, i);
            list.add(s);
        }

        for (int i = 0; i < m; i++) {
            String find = br.readLine();

            if (map.containsKey(find)) {
                System.out.println(map.get(find));
                continue;
            }
            System.out.println(list.get(Integer.parseInt(find) - 1));
        }
    }
}
