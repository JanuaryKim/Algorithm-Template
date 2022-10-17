package code.etc_기타;

import static code.etc_기타.C52_Solution.uglyNumbers;

/** 성공 하지만 비효율적, 소인수분해 문제 **/
public class C52_uglyNumbers {
    public static void main(String[] args) {
        int result = uglyNumbers(1);
        System.out.println(result); // --> 1

        result = uglyNumbers(3);
        System.out.println(result); // --> 3

        System.out.println("=====================");
        result = uglyNumbers(15);
        System.out.println(result); // --> 24
    }
}

class C52_Solution {
    public static int uglyNumbers(int n) {
        // TODO:

        //ugly number가 될 수있는 조건 : 2,3,5 로 나누고 나누어서 결국 1이 되는 수

        int count = 0; //몇번째 ugly 수인지 체크하기 위해
        int i = 1; //0은 어차피 나누어 떨어질 수 없으므로 1부터 시작

        while(true){
            int temp = i; //2,3,5로 계속 나누어서 결국 1이 되는지 확인하기 위하여, i를 2,3,5로 나누는 몫이 변화되어 들어가는 변수 선언
            boolean check = false; //2,3,5 로 계속 나누어서 결국 1이 되는 수인지 체크 변수

            while(true) //우선 진입
            {
                if(temp == 1) //몫이 1일 경우, 탈출조건
                {
                    check = true; //1로 나누어졌다는 체크
                    break;
                }

                //아직 1이 아닌 경우 아래 내용 실행

                if(temp % 2 == 0) //2로 나누어 진다면
                    temp /= 2; //2로 나눈 몫을 저장
                else if(temp % 3 == 0) //3으로 나누어 진다면
                    temp /= 3; //3으로 나눈 몫을 저장
                else if(temp % 5 == 0) //5로 나누어 진다면
                    temp /= 5; //5로 나눈 몫을 저장
                else //2,3,5 중 아무것으로도 나누어 지지 않는다면 더 이상 나눌 수 없으므로 해당 수는 ugly number가 될 수 없으므로 그냥 탈출
                    break;
            }

            if(check) //만약 현재 수(i) 가 ugly number 였다면
            {
                count++; //몇번째를 세는 변수 증가

            }


            if(count == n) break; //n번째를 찾은거라면 탈출

            i++; //아직 못 찾았다면 다음 수로 넘어감

        }
        return i;
    }
}

