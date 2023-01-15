package baekjoon.dp_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 성공, DP 사용 x **/
public class B2839_설탕배달 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(bf.readLine());

        if(weight % 5 == 0)
        {
            System.out.println(weight / 5);
        }
        else
        {
            int start = weight / 5;

            for (int i = start; i >= 0; i--) {

                int temp = 5 * i;
                int diff = weight - temp;

                if (diff % 3 == 0) {
                    int result = i + (diff / 3);
                    System.out.println(result);
                    return;
                }
            }

            if(weight % 3 == 0)
            {
                System.out.println(weight / 3);
                return;
            }

            System.out.println(-1);
        }

    }
}
