package programmers;

public class 문자열여러번뒤집기 {
    public static void main(String[] args) {
        int[][] arr = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        System.out.println(solution("rermgorpsam", arr));
    }

    public static String solution(String my_string, int[][] queries) {
        String answer = "";
        String[] strings = my_string.split("");

        for (int i = 0; i < queries.length; i++) {
            //바꿀 횟수의 절반 - swap
            int num = (int) Math.ceil((double) (queries[i][1] - queries[i][0]) / 2);

            for (int j = 0; j < num; j++) {
                String temp = strings[queries[i][0] + j];
                strings[queries[i][0] + j] = strings[queries[i][1] - j];
                strings[queries[i][1] - j] = temp;
            }
        }
        answer = String.join("", strings);
        return answer;
    }
}
