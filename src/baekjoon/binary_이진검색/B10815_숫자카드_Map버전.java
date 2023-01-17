package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/** 성공, Map 사용 버전 **/
public class B10815_숫자카드_Map버전 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Map<Integer, Boolean> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            map.put(card,true);
        }

        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {

            int card = Integer.parseInt(st.nextToken());

            if (map.get(card) != null) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
