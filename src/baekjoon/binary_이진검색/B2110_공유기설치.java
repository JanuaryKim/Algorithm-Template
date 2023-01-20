package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[n-1] - house[0];
        int ans = 1; //최소 간격간 최대 거리
        while (left <= right) {

            int mid = (left + right) / 2;
            int previousHouse = 0;
            int setCtn = 1;


            for (int i = 1; i < n; i++) {
                int dist = house[i] - house[previousHouse];

                if (dist >= mid) {
                    previousHouse = i;
                    setCtn++;
                }
            }

            if (setCtn >= c) {
                left = mid + 1;
                ans = Math.max(ans, mid); //기록
            }
            else
            {
                right = mid - 1;
            }
        }


        System.out.println(ans);

        //최초 수도코드
        //left 범위 중 최소 값 변수 선언. 최초 집 좌표
        //right 범위 중 최대 값 변수 선언. 마지막 집 좌표
        //반복 문 시작. left가 right 보다 작거나 같을 동안
        //  mid = (left + right) / 2
        //  이전 집 인덱스 = 최초 집
        //  설치 공유기 갯수 = 1;
        //  반복문 i = 1 ~ n, i++
        //      좌표 거리 = i번째 집 좌표 - 이전 집 좌표
        //      만약(설치 공유기 갯수가
        //      만약(좌표 거리가 mid 보다 크거나 같다면)
        //          이전집 인덱스 = i
        //          설치 공유기 갯수++
        //  반복문 종료
        //
        //  만약(설치 공유기 갯수가 c와 동일하거나
        //반복 문 종료
    }
}
