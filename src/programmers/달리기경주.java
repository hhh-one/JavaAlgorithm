package programmers;

import java.util.HashMap;
import java.util.Map;

//비슷한 문제 풀어봤는데 이번에는 조금 헤맸다
public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] arr = players;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int index = map.get(callings[i]);

            String temp = arr[index - 1];
            arr[index - 1] = arr[index];
            arr[index] = temp;

            map.put(temp, index);
            map.put(callings[i], index - 1);
        }

        String[] answer = arr;
        return answer;
    }
}