package programmers.brute_force_완전탐색;

import java.util.*;

/** 성공, 재규적 풀이 **/
public class P_소수찾기 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("17"));
        System.out.println("---------- 구분 -------------");
        System.out.println(solution.solution("011"));

    }


    static class Solution {
        Set<Integer> sosooSet = new LinkedHashSet<>(); //소수를 저장하는 셋

        public int solution(String numbers) {

            for(int i = 0; i < numbers.length(); i++)
            {
                Set<Integer> indexSet = new LinkedHashSet<>(); //재귀 안에 있는 for문에서 현재까지 쓰인 인덱스 위치에 값들은 중복으로 추가하지 않기 위한 셋

                indexSet.add(i);

                Integer intValue = convertInteger(indexSet, numbers); //현재까지 쓰인 인덱스와 numbers 기반으로 정수형으로 변환

                if(check(intValue)) {
                    sosooSet.add(intValue);
                }

                recursion(indexSet, numbers);
            }

            System.out.println(sosooSet.toString());
            return sosooSet.size(); //소수 셋에 존재하는 요소의 갯수가 즉, 소수의 갯수
        }

        public void recursion(Set<Integer> set, String numbers){

            if(set.size() == numbers.length()) //만약 모든 인덱스가 한번씩 쓰였다면
            {
                Integer number = convertInteger(set,numbers);

                if(check(number))
                {
                    if(!sosooSet.contains(number))
                    {
                        sosooSet.add(number);
                    }
                }

                return;
            }

            for(int i = 0; i < numbers.length(); i++)
            {
                Set<Integer> indexSet = new LinkedHashSet<>(set);

                if(indexSet.contains(i)) //이미 사용된 인덱스(i) 일 경우는 제외
                    continue;

                indexSet.add(i);
                Integer intValue = convertInteger(indexSet, numbers);
                if(check(intValue))
                    sosooSet.add(intValue);
                recursion(indexSet, numbers);
            }
        }

        public boolean check(int number) //소수인지 판별
        {
            if(number == 0 || number == 1) //0, 1은 제외
                return false;
            for(int i = 2; i <= number/2; i++) //약수인지 확인을 위해선 특정수의 반까지만 확인하면 됨
            {
                if(number % i == 0)
                    return false;
            }

            return true;
        }

        public Integer convertInteger(Set<Integer> indexSet, String numbers) { //현재까지 쓰인 인덱스과 numbers 기반으로 정수로 변환

            StringBuilder sb = new StringBuilder();
            indexSet.stream().forEach(i-> sb.append(numbers.charAt(i)));

            return Integer.valueOf(sb.toString());
        }

    }
}



