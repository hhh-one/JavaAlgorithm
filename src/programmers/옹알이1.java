package programmers;

import java.util.Arrays;

public class 옹알이1 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] pron = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            for (String p : pron) {
                babbling[i] = babbling[i].replace(p, "1");
            }
            babbling[i] = babbling[i].replace("1", "");
        }

        for (String b : babbling) {
            if (b.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}
