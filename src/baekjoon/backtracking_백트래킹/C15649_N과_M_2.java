package baekjoon.backtracking_백트래킹;

import java.util.*;

public class C15649_N과_M_2 {

    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        //N과 M (1) 에 비해 start라는 이자가 추가됨.
        //수열의 요소 추가할때 이전 숫자보다 큰것을 넣어야 하기 하므로, 추가를 시작할 숫자를 기억하기위해
        recursion(1,0, new Stack<>());

    }

    private static void recursion(int start, int count, Stack<Integer> stack) {

        if(count >= m)
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (int num : stack) {

                stringBuilder.append(num);
                stringBuilder.append(" ");
            }

            if(stringBuilder.length() != 0)
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            System.out.println(stringBuilder.toString());
            return;
        }

        //i를 수열의 이전 수보다 큰것 부터 탐색하기 위해 start 로 시작함.
        for (int i = start; i <= n; i++) {

            if(stack.contains(i))
                continue;

            stack.push(i);

            //현재 탐색 (i) 보다 큰 수부터 탐색해야 하기 때문에 +1
            recursion(i + 1,count + 1,stack);
            stack.pop();
        }
    }
}
