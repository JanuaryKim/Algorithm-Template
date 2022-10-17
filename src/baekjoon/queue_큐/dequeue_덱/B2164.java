package baekjoon.queue_큐.dequeue_덱;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 템플릿화, 성공, 디큐(덱)  **/
public class B2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        ArrayDeque<Integer> arrayDeque = new ArrayDeque(list);

        while (arrayDeque.size() > 1) {
            arrayDeque.removeFirst();
            Integer top = arrayDeque.pollFirst();
            arrayDeque.addLast(top);
        }

        System.out.println(arrayDeque.getFirst());
    }
}
