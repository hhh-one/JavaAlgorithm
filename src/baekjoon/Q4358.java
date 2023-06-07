package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Q4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0; //입력받은 개수
        SortedMap<String, Integer> map = new TreeMap<>();
        String s;

        while ((s = br.readLine()) != null) {
            count ++;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String key : map.keySet()) {
            double result = (double) map.get(key) / count * 100;
            String formatResult = String.format("%.4f", result);
            sb.append(key).append(" ").append(formatResult).append("\n");
        }

        System.out.println(sb.toString());
    }
}
