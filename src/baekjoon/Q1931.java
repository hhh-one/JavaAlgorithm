package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> times = new HashMap<>();
        int answer = 0;
        int min = -1; //최대 회의 개수의 시작 시간의 최소
        int max = -1; //최대 회의 개수의 종료 시간의 최대

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            //시작과 끝 시간이 같을 때 -> 따로 map에 처리하지 않고 답에 더해준다
            if (end == start) {
                answer += 1;
                continue;
            }
            //값이 없을 때
            if (times.get(end) == null) {
                times.put(end, start);
            } else {
                if (times.get(end) < start) {
                    times.put(end, start);
                }
            }
        }

        List<Integer> endSortKeys = times.keySet().stream().sorted().collect(Collectors.toList());
        max = endSortKeys.get(0);
        answer += 1;

        for (int currentEnd : endSortKeys) {
            int currentStart = times.get(currentEnd);
            if (currentStart < max) {
                continue;

            }
            max = currentEnd;
            answer += 1;
        }

        System.out.println(answer);
    }
}
