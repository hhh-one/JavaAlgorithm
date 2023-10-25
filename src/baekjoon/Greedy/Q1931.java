package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] meeting = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(meeting[0]);
            times[i][1] = Integer.parseInt(meeting[1]);
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int end = 0;
        for (int i = 0; i < n; i++) {
            if (times[i][0] >= end) {
                end = times[i][1];
                answer ++;
            }
        }

        System.out.println(answer);
    }
}
