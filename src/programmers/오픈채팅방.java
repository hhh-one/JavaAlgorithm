package programmers;

import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer;
        Map<String, String> map = new HashMap<>();
        int size = 0;

        for (String r : record) {
            String[] str = r.split(" ");
            size++;
            if (str[0].equals("Leave")) {
                continue;
            } else if (str[0].equals("Change")) {
                size--;
            }

            map.put(str[1], str[2]);
        }

        answer = new String[size];
        int index = 0;
        for (String r : record) {
            String[] str = r.split(" ");

            if (str[0].equals("Enter")) {
                answer[index] = map.get(str[1]) + "님이 들어왔습니다.";
                index++;
            } else if (str[0].equals("Leave")) {
                answer[index] = map.get(str[1]) + "님이 나갔습니다.";
                index++;
            }
        }
        return answer;
    }
}