package programmers;

import java.util.ArrayList;
import java.util.List;

public class 소수만들기 {
    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        //소수판별
        for (Integer l : list) {
            int prime = 1;

            for (int i = 2; i < l; i++) {
                if (l % i == 0) {
                    break;
                }
                prime++;
            }

            if (prime == l - 1) {
                answer++;
            }
        }

        return answer;
    }
}
