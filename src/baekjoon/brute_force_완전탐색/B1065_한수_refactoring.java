package baekjoon.brute_force_완전탐색;

import java.util.Scanner;

public class B1065_한수_refactoring {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int count  = 0;
        for (int i = 1; i <= n; i++) {
            if(checkHanSoo(i))
                count++;
        }
        System.out.println(count);
    }

    public static boolean checkHanSoo(int number) {

        if (number < 100) {
            return true;
        }

        int preNum = number % 10;
        number /= 10;
        int curNum = number % 10;
        int diff = curNum - preNum;

        while (number > 10) {
            preNum = curNum;
            number /= 10;
            curNum = number % 10;
            if(diff != (curNum - preNum))
                return false;

        }
        return true;
    }
}
