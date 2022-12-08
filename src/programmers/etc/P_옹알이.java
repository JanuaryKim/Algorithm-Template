package programmers.etc;

/** 성공 **/
public class P_옹알이 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(solution.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));

    }

    static class Solution {

        String[] basicBabbling = new String[]{"aya", "ye", "woo", "ma"};

        public int solution(String[] babbling) {
            int answer = 0;

            //주어진 babbling 문자열을 하나씩 꺼내서 조건 검사
            for(int i = 0; i < babbling.length; i++)
            {
                String str = babbling[i];
                boolean check = false; //발음 가능한 것인지 체크 변수
                int pre = -1; //이전 발음 저장 위해

                while(true) //발음이 가능한 문자열인지 체크 로직 진입을 위한 반복문 시작
                {
                    for(int j = 0; j < basicBabbling.length; j++) //발음 가능 기본 문자열을 하나씩 꺼내서 검사
                    {
                        if(pre == j) continue; //만약 이전에 발음한 문자열이라면 넘어감 (연달아 발음이 불가능 하기 때문)

                        if(str.startsWith(basicBabbling[j])) //발음 가능한 기본 발음으로 시작하는 문자열인지 체크
                        {
                            int start = basicBabbling[j].length();
                            int end = str.length();
                            str = str.substring(start, end); //(초반) 문자열중에 발음가능한 문자열을 빼고 나머지 문자열을 구함
                            pre = j; //발음한 인덱스를 기억 해둠
                            j = -1; //다시 발음 가능 문자열을 탐색해야 하기 때문에 -1 로 초기화하여 해당 반복문이 0부터 다시 돌도록

                            if(str.equals("")) //발음이 다 가능한 경우
                            {
                                check = true; //발견했음을 체크
                                break;
                            }
                            continue;
                        }
                    }

                    if(check) //발견한 경우
                        answer++;
                    break;
                }
            }

            return answer;
        }
    }
}
