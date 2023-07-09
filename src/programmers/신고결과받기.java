package programmers;

import java.util.*;

public class 신고결과받기 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> set = new HashSet<>(); //report
        Map<String, Integer> map = new HashMap<>(); //id 당 신고당한 횟수
        List<String> list = new ArrayList<>(); //정지된 id
        Map<String, Integer> mailNum = new HashMap<>(); //id 당 결과 메일 수

        //report 중복 제거
        for (String rep : report) {
            set.add(rep);
        }

        //신호당한 횟수 초기화
        for (String r : set.toArray(new String[set.size()])) {
            String[] reportDetail = r.split(" ");
            map.put(reportDetail[1], map.getOrDefault(reportDetail[1], 0) + 1);
        }

        //정지된 id
        for (String key : map.keySet()) {
            if (map.get(key) >= k) {
                list.add(key);
            }
        }

        //id 당 결과 메일 수
        for (String r : set.toArray(new String[set.size()])) {
            String[] reportDetail = r.split(" ");
            if (list.contains(reportDetail[1])) {
                mailNum.put(reportDetail[0], mailNum.getOrDefault(reportDetail[0], 0) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailNum.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}
