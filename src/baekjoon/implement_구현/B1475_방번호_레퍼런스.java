package baekjoon.implement_구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B1475_방번호_레퍼런스 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int ans =1;
        int arr[]= new int[10];
        String str = a+"";
        for(int i=0;i<str.length();i++) {
            arr[str.charAt(i)-'0']++;
        }
        for(int i=0;i<arr.length;i++) {
            if(i == 6 || i == 9)
                continue;
            ans = Math.max(ans, arr[i]);
        }
        ans = Math.max(ans,  (arr[6]+arr[9] + 1) /2);
        System.out.println(ans);
    }

}
