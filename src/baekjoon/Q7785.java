package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");

            if (log[1].equals("enter")) {
                map.put(log[0], 1);
            } else {
                map.put(log[0], 0);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }

        list.sort(Comparator.reverseOrder());

        for (String s : list) {
            System.out.println(s);
        }
    }
}
