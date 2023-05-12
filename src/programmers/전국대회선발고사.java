package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 전국대회선발고사 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, new boolean[]{true, true, true}));
    }

    public static int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                map.put(rank[i], i);
            }
        }

        Object[] key = map.keySet().toArray();
        Arrays.sort(key);

        answer = 10000 * map.get(key[0]) + 100 * map.get(key[1]) + map.get(key[2]);

//        List<Integer> keySort = map.keySet().stream().sorted().toList();
//
//        answer = 10000 * map.get(keySort.get(0)) + 100 * map.get(keySort.get(1)) + map.get(keySort.get(2));
        return answer;
    }
}
