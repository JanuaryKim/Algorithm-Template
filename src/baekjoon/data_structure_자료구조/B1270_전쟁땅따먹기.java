package baekjoon.data_structure_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/** 메모리초과... **/
public class B1270_전쟁땅따먹기 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");

            int armyCtn = Integer.parseInt(input[0]);

            Map<String, Integer> map = new HashMap<>();

            for (int j = 1; j <= armyCtn; j++) {

                Integer number = map.get(input[j]);

                if(number == null)
                    map.put(input[j], 1);
                else
                    map.put(input[j], number+1);
            }

            int maxCtn = 0;
            String maxKey = "";
            for (String key : map.keySet()) {
                int ctn = map.get(key);
                if (ctn > maxCtn) {
                    maxCtn = ctn;
                    maxKey = key;
                }
            }

            boolean check = true;
            for (String key : map.keySet()) {
                if (!key.equals(maxKey) && map.get(key).equals(maxCtn)) {
                    check = false;
                    break;
                }
            }

            if(check && (armyCtn / 2 <= maxCtn))
                sb.append(maxKey+"\n");
            else
                sb.append("SYJKGW\n");
        }

        System.out.println(sb);
    }
}
