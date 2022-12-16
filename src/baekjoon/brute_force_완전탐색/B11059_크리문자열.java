package baekjoon.brute_force_완전탐색;

import java.util.Scanner;

/** 성공, 마감 - 2022-12-12 **/
public class B11059_크리문자열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(solution(s));

    }

    static int solution(String s){

        //크리문자열 중 가장 긴것을 찾는것이므로, 입력 받은 문자열의 길이가 짝수 일 경우 해당 문자열의 길이부터 크리문자열인지 체크하면 된다.
        //근데 만약 입력받은 문자열의 길이가 짝수가 아닐 경우는 -1 길이부터가 크리문자열 검사 대상의 길이가 된다. (크리 문자열은 짝수길이라고 문제에 명시되어 있음)
        int curLength = (s.length() % 2 == 0) ? s.length() : s.length() - 1; //curLength - 이번에 추측하는 크리 문자열의 길이

        //2 미만인 0, 1은 짝수가 아니므로 크리문자열이 될 수 없다.
        while (curLength >= 2) {

            //크리 문자열은 짝수만 되므로, 추측하는 크리 문자열의 길이가 짝수가 아니면 검사조차 필요 x
            if(curLength % 2 == 0)
            {
                //0 부터 시작하여 한칸씩 뒤로 면서 curLength 만큼의 연속되는 부분문자열을 떼서 크리문자열인지 검사해야 하기 때문에 for 문 사용
                for (int i = 0; i < s.length(); i++) {

                    if (i + curLength > s.length()) { //부분 문자열의 범위가 전체 문자열인 s의 길이보다 크다면
                        break;
                    }

                    //크리 문자열인지 검사하기 위해 연속된 부분문자열을 떼어냄
                    String subString = s.substring(i, i + curLength);

                    //크리 문자열 검사 대상의 반의 길이를 구함
                    int half = subString.length() / 2;

                    int hap1 = 0;

                    //부분 문자열의 앞부분의 합 구하기
                    for (int j = i; j < i+half; j++) {
                        hap1 += Integer.valueOf(String.valueOf(s.charAt(j)));
                    }

                    int start = i + half; //뒷부분의 시작 인덱스
                    int hap2 = 0;

                    //부분 문자열 뒷부분의 합 구하기
                    for (int j = start; j < start + half; j++) {
                        hap2 += Integer.valueOf(String.valueOf(s.charAt(j)));
                    }

                    //앞쪽 합과 뒤쪽 합이 같다면 크리 문자열이므로
                    if(hap1 == hap2)
                        return subString.length();


                }
            }

            curLength--;
        }
        return 0;
    }
}
