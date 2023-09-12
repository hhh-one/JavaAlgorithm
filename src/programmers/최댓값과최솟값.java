package programmers;

public class 최댓값과최솟값 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : s.split(" ")) {
            int n = Integer.parseInt(str);
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
