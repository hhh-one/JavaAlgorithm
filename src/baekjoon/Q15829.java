package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        BigInteger sum = new BigInteger("0");

        for (int i = 0; i < n; i++) {
            BigInteger asc = BigInteger.valueOf(c[i] - 96);
            sum = sum.add(asc.multiply(BigInteger.valueOf(31).pow(i)));

        }

        System.out.println(sum.remainder(new BigInteger("1234567891")));
    }
}
