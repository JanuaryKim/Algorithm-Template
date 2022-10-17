package code.etc_기타;

import static code.etc_기타.C59_Solution.longestPalindrome;

/** 실패, 미완성 **/
public class C59_longestPalindrome {
    public static void main(String[] args) {
        String str = "My dad is a racecar athlete";
        int result = longestPalindrome(str);
        System.out.println(result); // --> 11 ('a racecar a')

        str = " dad ";
        result = longestPalindrome(str);
        System.out.println(result); // --> 5 (' dad ')
    }
}


class C59_Solution {
    public static int longestPalindrome(String str) {
        // TODO:

        //동일 갯수 변수;

        //str의 인덱스를 순차적으로 증가시키는 반복문

        //현재 인덱스 기준으로 인덱스를 -1, +1 시켜본다

        //-1, +1 시킨 위치의 문자가 동일하다면
        //계속 -1, +1 시켜본다
        //동일하지 않다면
        //현재까지 동일했던 갯수를 동일갯수 변수와 비교하여 더 큰 경우를 저장해둔다.


        //~ 반복문 종료

//        int sameCtn = 0;
//        for(int i = 0; i < str.length(); i++)
//        {
//            int left = i - 1;
//            int right = i + 1;
//            int tempSameCtn = 0;
//            while(left >= 0 && right < str.length())
//            {
//                if(str.charAt(left) == str.charAt(right))
//                {
//                    tempSameCtn++;
//                    left--;
//                    right++;
//                }
//                else
//                {
//                    break;
//                }
//            }
//
//            if(tempSameCtn != 0 && tempSameCtn > sameCtn)
//            {
//                sameCtn = tempSameCtn;
//            }
//
//        }
//
//        if(sameCtn != 0)
//            sameCtn = sameCtn * 2 + 1;
//        return sameCtn;


        if (str.length() < 2) return str.length();

        int LENGTH = str.length();
        boolean[][] isPalindrome = new boolean[LENGTH][];
        for(int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i] = new boolean[LENGTH];
        }

        int maxLen = 1;
        // 길이가 1인 회문
        for (int i = 0; i < LENGTH; i++) isPalindrome[i][i] = true;

        // 길이가 2인 회문
        for (int i = 0; i < LENGTH - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // 길이가 3 이상인 회문
        for (int len = 3; len <= LENGTH; len++) {
            for (int startIdx = 0; startIdx <= LENGTH - len; startIdx++) {
                int endIdx = startIdx + len - 1;
                if (
                        isPalindrome[startIdx + 1][endIdx - 1] &&
                                str.charAt(startIdx) == str.charAt(endIdx)
                ) {
                    isPalindrome[startIdx][endIdx] = true;
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }
}

