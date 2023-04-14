package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B1181_단어정렬 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(bf.readLine());
        }

        set.stream().sorted((a,b) ->{
            if(a.length() > b.length()) {
                return 1;
            }
            else if(a.length() == b.length()) {
                int length = Math.min(a.length(), b.length());
                for (int i = 0; i < length; i++) {

                    if(a.charAt(i) == b.charAt(i))
                        continue;

                    if (a.charAt(i) > b.charAt(i)) {
                        return 1;
                    } else if (a.charAt(i) < b.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            }
            else {
                return -1;
            }
        }).forEach(str -> System.out.println(str));
    }
}
