package algorithm;

import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        pq.offer(10);
        pq.offer(100);
        pq.offer(3);

        System.out.println(pq.poll());
    }
}
