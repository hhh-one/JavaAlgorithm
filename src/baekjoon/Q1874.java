package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//다시풀기
public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 1; i <= n; i++) { //4 3 6 8 7 5 2 1
            int num = Integer.parseInt(br.readLine());
            if (num > arr.length) {
                for (int j = 1; j <= num; j++) {
                    push(i);
                    System.out.println("+");
                }
                pop();
                System.out.println("-");
            } else {
                pop();
                System.out.println("-");
            }
        }
    }
    public static int[] arr;
    public static int index = 0;

    public static void push(int n) {
        if (index == arr.length) {
            return;
        }
        arr[index] = n;
        index++;
    }

    public static int pop() {
        if (arr.length == 0) {
            return 0;
        }
        int p = arr[index];
        index--;
        return p;
    }

    public static int peek() {
        return 0;
    }
}
