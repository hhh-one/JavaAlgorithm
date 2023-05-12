package programmers;

public class 그림확대 {
    public static void main(String[] args) {
        for (String s : solution(new String[]{".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."}, 2)) {
            System.out.println(s);
        }
    }

    public static String[] solution(String[] picture, int k) {
        String[] answer = new String[2 * picture.length];

        for (int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] p = picture[i].split("");

            for (int j = 0; j < p.length; j++) {
                sb.append(p[j].repeat(k));
            }

            for (int n = 0; n < k; n++) {
                answer[k * i + n] = sb.toString();
            }
        }
        return answer;
    }
}
