package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offerLast(1);
        dq.offerFirst(2);
        Integer polled1 = dq.pollLast();
        Integer polled2 = dq.pollFirst();
        dq.peekFirst(); // 안꺼내고 확인만 함
        dq.peekLast();

        dq.isEmpty(); // 비어있냐
    }
}
