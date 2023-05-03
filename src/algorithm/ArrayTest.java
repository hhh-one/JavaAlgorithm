package algorithm;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4}; // 선언 하면서 초기화 할 땐 정적 배열로 가능
        int[] arr2;
//        arr2 = {1, 2, 3, 4}; // 왜 안되냐! -> 정적 배열이기 때문 -> 동적 배열로 초기화 해줘야됨
        arr2 = new int[4]; // 이렇게 크기만 해주거나 (초기화는 자동으로 됨 ex int: 0, boolean: false)
        arr2 = new int[]{1, 2, 3, 4}; // 꽤 씀 -> 특히 알고리즘 풀 때 엄청 씀
    }
}
