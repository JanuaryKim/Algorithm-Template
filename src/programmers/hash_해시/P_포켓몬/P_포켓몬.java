package programmers.hash_해시.P_포켓몬;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** 성공 **/
public class P_포켓몬 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[]{3,1,2,3}));
        System.out.println(solution.solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution.solution(new int[]{3,3,3,2,2,2}));

    }

    static class Solution {
        public int solution(int[] nums) {

            int maxCount = nums.length / 2;

            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

            for(Integer value : nums)
            {
                map.put(value, 0);
            }

            return map.size() > maxCount ? maxCount : map.size();

        }
    }


}
