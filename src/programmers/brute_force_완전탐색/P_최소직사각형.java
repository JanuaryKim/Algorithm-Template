package programmers.brute_force_완전탐색;

/** 성공 **/
public class P_최소직사각형 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}); //4000
        solution.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}); //120

        solution.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}); //133


    }

    static class Solution {
        public int solution(int[][] sizes) {

            //가로든, 세로든, 명함의 긴쪽들 중 제일 긴쪽
            int max = 0;

            //가로든, 세로든, 명함의 짧은 쪽들 중 제일 긴쪽
            int min = 0;


            for (int i = 0; i < sizes.length; i++) {

                int[] card = sizes[i];

                int tempMax = Math.max(card[0], card[1]); //명함의 가로, 세로 중 긴쪽 구함
                int tempMin = Math.min(card[0], card[1]); //명함의 가로, 세로 중 짧은쪽 구함

                max = Math.max(max, tempMax); //지금까지 구한 긴쪽 중 제일 긴 길이와, 이번 명함의 긴쪽 중 긴것을 저장 (제일 큰 사이즈를 구해야 하기 때문)
                min = Math.max(min, tempMin); //지금까지 구한 짧은 쪽 중 제일 긴 길이와, 이번 명함의 짧은 쪽중에 긴것을 저장 (제일 큰 사이즈를 구해야 하기 때문)
            }

            return max * min;
        }
    }
}
