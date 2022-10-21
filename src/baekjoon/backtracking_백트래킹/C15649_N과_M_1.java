package baekjoon.backtracking_백트래킹;

import java.util.*;

public class C15649_N과_M_1 {

    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();


        //------- 수도 코드
        //재귀, 인자(숫자 스택)
        //{
        //만약 스택 요소 갯수가 m일 경우
            //결과 처리

        //반복문, i= 1 ~ n, i++
            //이번 순서 숫자가 숫자 스택에 포함되어 있다면
                //컨티뉴
            //재귀(숫자 스택에 넣음)
            //스탭에서 pop
        //~반복문
        //}
        //-------


        //------ count 인자 필요 없이, stack 요소의 갯수로 count 변수의 역할을 대신하면 되지만, 메모리리가 10000KB가 늘어남
        recursion(0, new Stack<>());

    }

    private static void recursion(int count, Stack<Integer> stack) {

        if(count >= m)
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (int num : stack) {

                //-------     stringBuilder.append(num + " "); 이렇게 한줄로도 되지만, 메모리에서 큰 차이가 남
                stringBuilder.append(num);
                stringBuilder.append(" ");
            }

            if(stringBuilder.length() != 0)
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            System.out.println(stringBuilder.toString());
            return;
        }


        for (int i = 1; i <= n; i++) {

            if(stack.contains(i))
                continue;

            stack.push(i);
            recursion(count + 1,stack);
            stack.pop();
        }
    }
}
