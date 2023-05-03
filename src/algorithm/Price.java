package algorithm;

public class Price {

    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (isPrice(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrice(int number) {
        if (number <= 1) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
