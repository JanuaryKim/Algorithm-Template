package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 성공 **/
public class B2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        long[] trees = new long[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        //하나도 안 잘라도 되는 경우도 있을 수 있기 때문에 최소 범위를 0부터 시작
        long left = 0;
        long right = trees[trees.length-1];
        while (left <= right) {

            long mid = (left+right) / 2;

            long sum = 0;
            for (int i = 0; i < trees.length; i++) {
                long diff = trees[i] - mid;
                sum += diff < 0 ? 0 : diff;
            }

            if(sum >= m)
            {
                left = mid + 1;

            }
            else
            {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
