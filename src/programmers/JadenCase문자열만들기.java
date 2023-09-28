package programmers;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean whitespaceNext = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                whitespaceNext = true;
                continue;
            }
            if (whitespaceNext) {
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                whitespaceNext = false;
                continue;
            }
            sb.append(String.valueOf(s.charAt(i)).toLowerCase());
        }
        return sb.toString();
    }
}
