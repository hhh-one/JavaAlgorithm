package programmers;

public class 다항식더하기 {
    public static void main(String[] args) {
        System.out.println(solution("3x + x"));
    }

    public static String solution(String polynomial) {
        String answer = "";
        String[] num = polynomial.replace(" ", "").split("\\+");
        int x = 0;
        int n = 0;

        for (String s : num) {
            if (s.substring(s.length() - 1).equals("x")) {
                if (s.length() == 1) {
                    x += 1;
                } else {
                    x += Integer.parseInt(s.substring(0, s.length() - 1));
                }
            } else {
                n += Integer.parseInt(s);
            }
        }

        if (x == 0) {
            answer = String.valueOf(n);
        } else if (x == 1) {
            answer = "x";
        } else{
            answer = x + "x";
        }

        if (n != 0 && x != 0) {
            answer += " + " + n;
        }

        return answer;
    }
}
