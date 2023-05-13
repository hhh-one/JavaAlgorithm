package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 왼쪽오른쪽 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"l"})));
    }

    public static String[] solution(String[] str_list) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                for (int j = i; j >= 0; j--) {
                    list.add(str_list[j]);
                }
                break;
            } else if (str_list[i].equals("r")) {
                for (int j = i; j < str_list.length; j++) {
                    list.add(str_list[j - i]);
                }
                break;
            }
        }

        String[] answer = new String[list.size()];
        if (list.size() == 0) {
            answer = new String[]{};
        } else {
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}
