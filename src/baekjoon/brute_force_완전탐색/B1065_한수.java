package baekjoon.brute_force_완전탐색;

import java.util.Scanner;

/** 성공, 마감 - 2022-12-12 **/
public class B1065_한수 {
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

        String iStr = String.valueOf(number);

        if (iStr.length() < 3) {
            return true;
        }

        int preNum = iStr.charAt(0);
        int curNum = iStr.charAt(1);
        int diff = curNum - preNum;
        for (int i = 2; i < iStr.length(); i++) {

            preNum = iStr.charAt(i-1);
            curNum = iStr.charAt(i);

            if(diff != (curNum - preNum)) return false;
        }

        return true;
    }
}
