package baekjoon.math_수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 성공 **/
public class B2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = bf.readLine().split(" ");
        int[] result = new int[2];

        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);

        int small = Math.min(a,b);
        int big = Math.max(a,b);

        if (big % small == 0) {
            result[0] = small;
        } else {

            for (int i = small / 2; i >= 1; i--) {

                if (small % i == 0 && big % i == 0) {
                    result[0] = i;
                    break;
                }
            }
        }

        //최소 공배수 구하기
        int i = 1;
        while (true) {
            int mulValue = big * i;
            if (mulValue % small == 0) {
                result[1] = mulValue;
                break;
            }
            i++;
        }

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
