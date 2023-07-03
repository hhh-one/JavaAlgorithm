package programmers;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String[][] mbti = new String[][]{{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};

        for (int i = 0; i < survey.length; i++) {
            String[] type = survey[i].split("");

            if (choices[i] < 4) {
                map.put(type[0], map.getOrDefault(type[0], 0) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                map.put(type[1], map.getOrDefault(type[1], 0) + choices[i] - 4);
            }
        }

        for (String[] mbtiType : mbti) {
            int first = map.getOrDefault(mbtiType[0], 0);
            int second = map.getOrDefault(mbtiType[1], 0);

            if (first >= second) {
                sb.append(mbtiType[0]);
            } else {
                sb.append(mbtiType[1]);
            }
        }

        answer = sb.toString();
        return answer;
    }
}